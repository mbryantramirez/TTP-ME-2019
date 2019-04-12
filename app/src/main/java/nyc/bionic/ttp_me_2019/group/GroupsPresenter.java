package nyc.bionic.ttp_me_2019.group;

import android.content.Context;
import android.util.Log;
import androidx.lifecycle.LifecycleOwner;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import nyc.bionic.ttp_me_2019.feed.TwitterFeedPresenter;
import nyc.bionic.ttp_me_2019.db.Group;
import nyc.bionic.ttp_me_2019.db.GroupDatabase;
import nyc.bionic.ttp_me_2019.db.GroupDAO;

public class GroupsPresenter {


  private GroupDAO groupDAO;
  private GroupsPresentationContract groupsPresentation;
  private List<Group> groupList = new ArrayList<>();

  public GroupsPresenter(Context context) {
    groupDAO = GroupDatabase.getInstance(context).groupStore();
  }

  public void attach(GroupsPresentationContract groupsPresentation) {
    this.groupsPresentation = groupsPresentation;
  }

  public void detach() {
    this.groupsPresentation = null;
  }

  public void getGroups(LifecycleOwner lifecycleOwner) {
    groupDAO.flowAllGroups().observeOn(AndroidSchedulers.mainThread())
        .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(lifecycleOwner)))
        .subscribe(groups -> {
          groupList = groups;
          Log.d(TwitterFeedPresenter.class.getName(), "onSubscribe: " + groupList.size());
          groupsPresentation.showGroups(groupList);
        });
  }

  public void deleteGroup(Group group) {
    groupDAO.delete(group).subscribeOn(Schedulers.io()).subscribe();
  }


}
