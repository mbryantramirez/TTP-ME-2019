package nyc.bionic.ttp_me_2019;


import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import nyc.bionic.ttp_me_2019.feed.TwitterFeedFragment;
import nyc.bionic.ttp_me_2019.group.GroupFragmentInteractor;
import nyc.bionic.ttp_me_2019.model.User;
import nyc.bionic.ttp_me_2019.profile.TwitterProfileFragment;
import nyc.bionic.ttp_me_2019.profile.TwitterProfileInteractor;

public class MainActivity extends AppCompatActivity implements GroupFragmentInteractor,
    TwitterProfileInteractor {

  @BindView(R.id.viewpager_fab)
  FloatingActionButton floatingActionButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    getSupportFragmentManager().beginTransaction()
        .replace(R.id.main_container, new MainViewPagerFragment()).commit();
  }

  @OnClick(R.id.viewpager_fab)
  public void goToAddGroupActivity() {
    startActivity(new Intent(this, CreateGroupActivity.class));
  }


  @Override
  public void goToGroup(String groupName) {
    getSupportFragmentManager().beginTransaction()
        .replace(R.id.main_container, TwitterFeedFragment.newInstance(groupName))
        .addToBackStack(null).commit();
  }

  @Override
  public void goToProfileFragment(User user) {
    getSupportFragmentManager().beginTransaction()
        .replace(R.id.main_container, TwitterProfileFragment.newInstance(user)).addToBackStack(null)
        .commit();
  }
}