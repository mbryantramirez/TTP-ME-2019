package nyc.bionic.ttp_me_2019.repo;

import io.reactivex.Flowable;
import java.util.List;
import nyc.bionic.ttp_me_2019.model.StatusesItem;

public interface TwitterRepositoryContract {

  Flowable<List<StatusesItem>> getSearchTweets(String q, String loc);

  Flowable<List<StatusesItem>> getUserTimelineTweets(String userId, int count);
}
