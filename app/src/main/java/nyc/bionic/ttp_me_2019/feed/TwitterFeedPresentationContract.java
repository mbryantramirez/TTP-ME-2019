package nyc.bionic.ttp_me_2019.feed;

import java.util.List;
import nyc.bionic.ttp_me_2019.model.StatusesItem;

public interface TwitterFeedPresentationContract {

  void refresh();

  boolean testIsValid();

  void showStatuses(List<StatusesItem> statusesItemList);

  void showLoading();

  void hideLoading();

}
