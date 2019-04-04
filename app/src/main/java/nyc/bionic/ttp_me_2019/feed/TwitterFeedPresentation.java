package nyc.bionic.ttp_me_2019.feed;

import java.util.List;
import nyc.bionic.ttp_me_2019.model.StatusesItem;

public interface TwitterFeedPresentation {

  void refresh();

  void showStatuses(List<StatusesItem> statusesItemList);

  void showLoading();

  void hideLoading();

}
