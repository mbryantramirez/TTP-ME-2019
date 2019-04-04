package nyc.bionic.ttp_me_2019.util;

import android.content.Context;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class Retrofit2Client {

  private static Retrofit2Client instance = null;
  private TwitterService twitterService;

  private Retrofit2Client(Context context) {
    int cacheSize = 10 * 1024 * 1024;
    Cache cache = new Cache(context.getCacheDir(), cacheSize);
    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
    loggingInterceptor.setLevel(Level.BODY);
    OkHttpClient okHttpClient = new OkHttpClient.Builder()
        .cache(cache)
        .addNetworkInterceptor(new CachingInterceptor())
        .addInterceptor(new TwitterInterceptor())
        .addInterceptor(loggingInterceptor)
        .build();

    String BASE_URL = "https://api.twitter.com/1.1/";
    Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();

    twitterService = retrofit.create(TwitterService.class);
  }

  public static Retrofit2Client getInstance(Context context) {
    if (instance == null) {
      instance = new Retrofit2Client(context);
    }
    return instance;
  }


  public TwitterService getTwitterService() {
    return twitterService;
  }

}
