package nyc.bionic.ttp_me_2019.repo;

import android.content.Context;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import nyc.bionic.ttp_me_2019.model.SearchResponse;
import nyc.bionic.ttp_me_2019.model.StatusesItem;
import nyc.bionic.ttp_me_2019.util.Retrofit2Client;
import nyc.bionic.ttp_me_2019.util.TwitterService;

public class TwitterApiRepository implements TwitterRepository {

  private static TwitterApiRepository instance;
  private static TwitterService twitterService;

  private TwitterApiRepository() {
  }

  public static TwitterApiRepository getInstance(Context context) {
    if (instance == null) {
      twitterService = Retrofit2Client.getInstance(context).getTwitterService();
      instance = new TwitterApiRepository();
    }
    return instance;
  }

  @Override
  public Flowable<List<StatusesItem>> getSearchTweets(String q, String loc) {
    return twitterService.searchTweets(q, loc).subscribeOn(Schedulers.io()).map(
        SearchResponse::getStatuses);
  }

  @Override
  public Flowable<List<StatusesItem>> getUserTimelineTweets(String userId, int count) {
    return twitterService.getUserTimeline(userId,count).subscribeOn(Schedulers.io());
  }
}
