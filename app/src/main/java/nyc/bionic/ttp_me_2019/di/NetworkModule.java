package nyc.bionic.ttp_me_2019.di;

import android.app.Application;
import com.squareup.moshi.Moshi;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import nyc.bionic.ttp_me_2019.repo.TwitterApiRepository;
import nyc.bionic.ttp_me_2019.util.CachingInterceptor;
import nyc.bionic.ttp_me_2019.util.TwitterOauthInterceptor;
import nyc.bionic.ttp_me_2019.util.TwitterService;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
class NetworkModule {

  @Provides
  @Singleton
  Retrofit providesRetrofit(MoshiConverterFactory moshiConverterFactory,
      RxJava2CallAdapterFactory rxJava2CallAdapterFactory, OkHttpClient okHttpClient) {
    String BASE_URL = "https://api.twitter.com/1.1/";
    return new Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(moshiConverterFactory)
        .addCallAdapterFactory(rxJava2CallAdapterFactory)
        .client(okHttpClient)
        .build();
  }

  @Provides
  @Singleton
  Cache providesOKhttpCache(Application application) {
    int cacheSize = 10 * 1024 * 1024;
    return new Cache(application.getCacheDir(), cacheSize);
  }

  @Provides
  @Singleton
  OkHttpClient providesOkHttpClient(Cache cache) {
    return new OkHttpClient.Builder().cache(cache)
        .addNetworkInterceptor(new CachingInterceptor())
        .addInterceptor(new TwitterOauthInterceptor())
        .addInterceptor(new HttpLoggingInterceptor().setLevel(Level.BODY))
        .build();
  }

  @Provides
  @Singleton
  Moshi providesMoshi() {
    return new Moshi.Builder().build();
  }

  @Provides
  @Singleton
  MoshiConverterFactory providesMoshiConverterFactory() {
    return MoshiConverterFactory.create();
  }

  @Provides
  @Singleton
  RxJava2CallAdapterFactory providesRxJava2CallAdapterFactory() {
    return RxJava2CallAdapterFactory.create();
  }

  @Provides
  @Singleton
  TwitterService providesTwitterService(Retrofit retrofit) {
    return retrofit.create(TwitterService.class);
  }

  @Provides
  TwitterApiRepository providesTwitterApiRepository(Application application) {
    return TwitterApiRepository.getInstance(application);
  }

}
