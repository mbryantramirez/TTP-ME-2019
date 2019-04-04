package nyc.bionic.ttp_me_2019.controller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class TabAdapter extends FragmentStatePagerAdapter {

  private List<Fragment> fragmentList = new ArrayList<>();
  private List<String> fragmentTitleList = new ArrayList<>();

  public TabAdapter(FragmentManager supportFragmentManager) {
    super(supportFragmentManager);
  }

  @NonNull
  @Override
  public Fragment getItem(int position) {
    return fragmentList.get(position);
  }

  @Nullable
  @Override
  public CharSequence getPageTitle(int position) {
    return fragmentTitleList.get(position);
  }

  public void addFragment(Fragment fragment, String title) {
    fragmentList.add(fragment);
    fragmentTitleList.add(title);
  }

  @Override
  public int getCount() {
    return fragmentList.size();
  }
}
