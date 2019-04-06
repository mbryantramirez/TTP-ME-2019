package nyc.bionic.ttp_me_2019.feed;

import android.content.Context;
import android.util.Log;
import androidx.lifecycle.LifecycleOwner;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.ArrayList;
import java.util.List;
import nyc.bionic.ttp_me_2019.model.StatusesItem;
import nyc.bionic.ttp_me_2019.repo.TwitterApiRepository;

public class TwitterFeedPresenter {

  private TwitterFeedPresentation twitterFeedPresentation;

  private TwitterApiRepository twitterApiRepository;

  private List<StatusesItem> statusesItemList = new ArrayList<>();

  public TwitterFeedPresenter(Context context) {
    twitterApiRepository = TwitterApiRepository.getInstance(context);
  }

  public void attach(TwitterFeedPresentation presentation) {
    this.twitterFeedPresentation = presentation;
  }

  public void detach() {
    this.twitterFeedPresentation = null;
  }

  public void refresh() {
    twitterFeedPresentation.refresh();
  }

  public void getStatuses(String tag, String latLong, LifecycleOwner lifecycleOwner) {
    twitterFeedPresentation.showLoading();
    if (latLong != null) {
      latLong = latLong + "," + "1mi";
    }
    twitterApiRepository.getSearchTweets(tag, latLong).observeOn(AndroidSchedulers.mainThread())
        .as(AutoDispose.autoDisposable(
            AndroidLifecycleScopeProvider.from(lifecycleOwner)))
        .subscribe(statusesItems -> {
          twitterFeedPresentation.hideLoading();
          statusesItemList = statusesItems;
          Log.d(TwitterFeedPresenter.class.getName(), "onSubscribe: " + statusesItemList.size());
          twitterFeedPresentation.showStatuses(statusesItemList);
        });
  }
}
