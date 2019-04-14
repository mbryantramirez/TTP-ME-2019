package nyc.bionic.ttp_me_2019.di;

import static nyc.bionic.ttp_me_2019.db.GroupDatabase.DB_NAME;

import android.app.Application;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import nyc.bionic.ttp_me_2019.db.GroupDAO;
import nyc.bionic.ttp_me_2019.db.GroupDatabase;

@Module
class DatabaseModule {

  @Provides
  @Singleton
  GroupDatabase providesGroupDatabase(Application application, Boolean memoryOnly) {
    RoomDatabase.Builder<GroupDatabase> builder;
    if (memoryOnly) {
      builder = Room.inMemoryDatabaseBuilder(application, GroupDatabase.class);
    } else {
      builder = Room.databaseBuilder(application, GroupDatabase.class, DB_NAME);
    }
    return builder.fallbackToDestructiveMigration().build();
  }

  @Provides
  GroupDAO providesGroupDao(GroupDatabase groupDatabase) {
    return groupDatabase.groupDAO();
  }

}
