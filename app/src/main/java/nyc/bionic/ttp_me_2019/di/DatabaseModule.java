package nyc.bionic.ttp_me_2019.di;

import android.app.Application;
import androidx.room.Room;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import nyc.bionic.ttp_me_2019.db.GroupDatabase;

@Module
class DatabaseModule {

  @Provides
  @Singleton
  GroupDatabase providesGroupDatabase(Application application) {
    return Room.databaseBuilder(application, GroupDatabase.class, GroupDatabase.DB_NAME)
        .fallbackToDestructiveMigration()
        .build();
  }

}
