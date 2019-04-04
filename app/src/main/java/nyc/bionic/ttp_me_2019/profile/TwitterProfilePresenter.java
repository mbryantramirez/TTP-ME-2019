package nyc.bionic.ttp_me_2019.profile;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.ArrayList;
import java.util.List;
import nyc.bionic.ttp_me_2019.model.StatusesItem;
import nyc.bionic.ttp_me_2019.repo.TwitterApiRepository;

public class TwitterProfilePresenter {

  private TwitterProfilePresentation twitterProfilePresentation;

  private TwitterApiRepository twitterApiRepository;

  private List<StatusesItem> statusesItems = new ArrayList<>();

  public TwitterProfilePresenter(Context context) {
    twitterApiRepository = TwitterApiRepository.getInstance(context);
  }

  public void attach(TwitterProfilePresentation twitterProfilePresentation) {
    this.twitterProfilePresentation = twitterProfilePresentation;
  }

  public void detach() {
    this.twitterProfilePresentation = null;
  }

  public void getUserTimeline(String userId, LifecycleOwner lifecycleOwner) {
    twitterApiRepository.getUserTimelineTweets(userId, 10).observeOn(AndroidSchedulers.mainThread())
        .as(
            AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(lifecycleOwner)))
        .subscribe(statusesItems1 -> {
          statusesItems = statusesItems1;
          twitterProfilePresentation.showStatuses(statusesItems);
        });
  }
}
