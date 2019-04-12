package nyc.bionic.ttp_me_2019.profile;

import java.util.List;
import nyc.bionic.ttp_me_2019.model.StatusesItem;

public interface TwitterProfileContract {
  void showStatuses(List<StatusesItem> statusesItemList);

}
