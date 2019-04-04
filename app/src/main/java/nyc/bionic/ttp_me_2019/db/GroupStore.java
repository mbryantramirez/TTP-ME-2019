package nyc.bionic.ttp_me_2019.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import io.reactivex.Flowable;
import java.util.List;

@Dao
public interface GroupStore {

  @Query("SELECT * FROM groups ORDER BY name")
  Flowable<List<Group>> flowAllGroups();

  @Insert()
  void insert(Group... group);

  @Delete
  void delete(Group... group);


}
