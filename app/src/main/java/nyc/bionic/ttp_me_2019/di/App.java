package nyc.bionic.ttp_me_2019.di;


import android.content.Context;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class App extends DaggerApplication {

  @Override
  protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
    return DaggerCoreComponent.builder().application(this).build();
  }

  @Override
  protected void attachBaseContext(Context base) {
    super.attachBaseContext(base);
  }
}
