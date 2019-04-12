package nyc.bionic.ttp_me_2019.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import nyc.bionic.ttp_me_2019.MainActivity;

@Module
abstract class ActivityBuilderModule {

  @ContributesAndroidInjector(modules = {MainActivityProviders.class})
  abstract MainActivity mainActivity();
}
