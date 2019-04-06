package nyc.bionic.ttp_me_2019.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Group.class}, version = 2, exportSchema = false)
public abstract class GroupDatabase extends RoomDatabase {

  public abstract GroupDAO groupStore();

  private static final String DB_NAME = "groups.db";
  private static volatile GroupDatabase INSTANCE = null;

  public synchronized static GroupDatabase getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = create(context, false);
    }

    return INSTANCE;
  }

  public static GroupDatabase create(Context context, boolean memoryOnly) {
    RoomDatabase.Builder<GroupDatabase> builder;
    if (memoryOnly) {
      builder = Room.inMemoryDatabaseBuilder(context.getApplicationContext(), GroupDatabase.class);
    } else {
      builder = Room.databaseBuilder(context.getApplicationContext(), GroupDatabase.class, DB_NAME);
    }
    return builder.fallbackToDestructiveMigration().build();
  }
}
