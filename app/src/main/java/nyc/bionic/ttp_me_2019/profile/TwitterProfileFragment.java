package nyc.bionic.ttp_me_2019.profile;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import nyc.bionic.ttp_me_2019.R;
import nyc.bionic.ttp_me_2019.controller.StatusesAdapter;
import nyc.bionic.ttp_me_2019.model.StatusesItem;
import nyc.bionic.ttp_me_2019.model.User;
import org.jetbrains.annotations.NotNull;


/**
 * A simple {@link Fragment} subclass.
 */
public class TwitterProfileFragment extends Fragment implements TwitterProfilePresentation {

  @BindView(R.id.twitter_profile_iv)
  ImageView twitterProfileImageView;

  @BindView(R.id.profile_screename_tv)
  TextView profileScreenNameTextView;

  @BindView(R.id.profile_name_tv)
  TextView profileNameTextView;

  @BindView(R.id.followercount_tv)
  TextView followerCountTextView;

  @BindView(R.id.followingcount_tv)
  TextView followingCountTextView;

  @BindView(R.id.location_tv)
  TextView locationTextView;

  @BindView(R.id.lasttweets_rv)
  RecyclerView lastTweetsRecycler;

  private TwitterProfilePresenter twitterProfilePresentation;
  private List<StatusesItem> statusesItems = new ArrayList<>();
  private StatusesAdapter statusesAdapter;
  private String userId;
  private String screenname;
  private String name;
  private int followerCount;
  private int followingCount;
  private String profileImageUrl;
  private String location;


  public TwitterProfileFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_twitter_profile, container, false);
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      userId = getArguments().getString("userId");
      screenname = getArguments().getString("screenname");
      name = getArguments().getString("name");
      followerCount = getArguments().getInt("followercount");
      followingCount = getArguments().getInt("followingcount");
      profileImageUrl = getArguments().getString("profilepic");
      location = getArguments().getString("location");
    }
  }

  @Override
  public void onStart() {
    super.onStart();
    twitterProfilePresentation.attach(this);
    twitterProfilePresentation.getUserTimeline(userId, this);
  }

  @Override
  public void onStop() {
    super.onStop();
    twitterProfilePresentation.detach();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);
    Picasso.get().load(profileImageUrl).resize(500, 500).into(twitterProfileImageView);
    profileScreenNameTextView.setText(screenname);
    profileNameTextView.setText(name);
    followerCountTextView.setText(String.valueOf(followerCount));
    followingCountTextView.setText(String.valueOf(followingCount));
    locationTextView.setText(location);
    twitterProfilePresentation = new TwitterProfilePresenter(getActivity());
    initRecyclerView(statusesItems);
  }

  @Override
  public void showStatuses(List<StatusesItem> statusesItemList) {
    statusesItems = statusesItemList;
    statusesAdapter.setData(statusesItemList);
  }

  private void initRecyclerView(List<StatusesItem> statusesItems) {
    lastTweetsRecycler
        .setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
    statusesAdapter = new StatusesAdapter(statusesItems);
    lastTweetsRecycler.setAdapter(statusesAdapter);
  }

  public static TwitterProfileFragment newInstance(User user) {
    Bundle args = new Bundle();
    TwitterProfileFragment fragment = new TwitterProfileFragment();
    args.putString("userId", user.getIdStr());
    args.putString("screenname", user.getScreenName());
    args.putString("name", user.getName());
    args.putInt("followercount", user.getFollowersCount());
    args.putInt("followingcount", user.getFriendsCount());
    args.putString("profilepic", user.getProfileImageUrlHttps());
    args.putString("location", user.getLocation());
    fragment.setArguments(args);
    return fragment;
  }


}
