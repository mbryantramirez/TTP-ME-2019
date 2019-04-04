package nyc.bionic.ttp_me_2019.util;

import io.reactivex.Flowable;
import java.util.List;
import nyc.bionic.ttp_me_2019.model.SearchResponse;
import nyc.bionic.ttp_me_2019.model.StatusesItem;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TwitterService {

  @GET("search/tweets.json")
  Flowable<SearchResponse> searchTweets(@Query("q") String query, @Query("geocode") String geocode);

  @GET("statuses/user_timeline.json")
  Flowable<List<StatusesItem>> getUserTimeline(@Query("user_id") String userId, @Query("count") int count);
}
