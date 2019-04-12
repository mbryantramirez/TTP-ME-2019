package nyc.bionic.ttp_me_2019.di;


import android.app.Application;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import javax.inject.Singleton;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, ActivityBuilderModule.class,
    DatabaseModule.class, NetworkModule.class, LocationModule.class})
interface CoreComponent extends AndroidInjector<App> {

  @Component.Builder
  interface Builder {

    @BindsInstance
    Builder application(Application application);

    CoreComponent build();

  }

}
