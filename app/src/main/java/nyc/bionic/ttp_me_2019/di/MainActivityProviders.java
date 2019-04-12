package nyc.bionic.ttp_me_2019.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import nyc.bionic.ttp_me_2019.MainViewPagerFragment;
import nyc.bionic.ttp_me_2019.feed.TwitterFeedFragment;
import nyc.bionic.ttp_me_2019.group.GroupsFragment;

@Module
abstract class MainActivityProviders {

  @ContributesAndroidInjector
  abstract MainViewPagerFragment providesMainViewPagerFragment();

  @ContributesAndroidInjector
  abstract GroupsFragment providesGroupsFragment();

  @ContributesAndroidInjector
  abstract TwitterFeedFragment providesTwitterFeedFragment();
}
