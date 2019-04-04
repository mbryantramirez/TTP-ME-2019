package nyc.bionic.ttp_me_2019;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.tabs.TabLayout;
import nyc.bionic.ttp_me_2019.controller.TabAdapter;
import nyc.bionic.ttp_me_2019.feed.TwitterFeedFragment;
import nyc.bionic.ttp_me_2019.group.GroupsFragment;
import org.jetbrains.annotations.NotNull;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainViewPagerFragment extends Fragment {

  @BindView(R.id.main_act_tabs)
  TabLayout tabLayout;

  @BindView(R.id.main_viewpager)
  ViewPager viewPager;

  public MainViewPagerFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_main_view_pager, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    ButterKnife.bind(this, view);
    TabAdapter adapter = new TabAdapter(getChildFragmentManager());
    adapter.addFragment(new TwitterFeedFragment(), "Main Feed");
    adapter.addFragment(new GroupsFragment(), "Groups");
    viewPager.setAdapter(adapter);
    tabLayout.setupWithViewPager(viewPager);
  }
}
