package nyc.bionic.ttp_me_2019.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Group.class}, version = 2, exportSchema = false)
public abstract class GroupDatabase extends RoomDatabase {

  public abstract GroupDAO groupDAO();

  public static final String DB_NAME = "groups.db";

}
