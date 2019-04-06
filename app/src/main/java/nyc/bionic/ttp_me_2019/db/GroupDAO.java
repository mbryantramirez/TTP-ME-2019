package nyc.bionic.ttp_me_2019.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import java.util.List;

@Dao
public interface GroupDAO {

  @Query("SELECT * FROM groups ORDER BY name")
  Flowable<List<Group>> flowAllGroups();

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insert(Group... group);

  @Delete()
  Completable delete(Group... group);
}
