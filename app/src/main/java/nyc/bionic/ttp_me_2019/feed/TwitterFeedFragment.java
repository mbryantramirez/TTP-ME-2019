package nyc.bionic.ttp_me_2019.feed;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;
import java.util.ArrayList;
import java.util.List;
import nyc.bionic.ttp_me_2019.R;
import nyc.bionic.ttp_me_2019.controller.StatusesAdapter;
import nyc.bionic.ttp_me_2019.model.StatusesItem;
import nyc.bionic.ttp_me_2019.profile.TwitterProfileInteractor;
import nyc.bionic.ttp_me_2019.repo.LocationRepository;

public class TwitterFeedFragment extends Fragment implements TwitterFeedPresentation {

  @BindView(R.id.main_feed_rv)
  RecyclerView mainFeedRecyclerView;

  @BindView(R.id.mainfeed_pgbar)
  ProgressBar progressBar;

  private TwitterFeedPresenter twitterFeedPresentation;
  private List<StatusesItem> statusesItems = new ArrayList<>();
  private TwitterProfileInteractor twitterProfileInteractor;
  private StatusesAdapter statusesAdapter;
  private String latLong;
  private String tag;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_mainfeed, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    ButterKnife.bind(this, view);
    twitterFeedPresentation = new TwitterFeedPresenter(getActivity());
    initRecyclerView(statusesItems);
  }

  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    if (context instanceof TwitterProfileInteractor) {
      twitterProfileInteractor = (TwitterProfileInteractor) context;
    }
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);
    if (getArguments() != null) {
      tag = getArguments().getString("GroupTag", "");
    } else {
      tag = "";
    }
  }

  @Override
  public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
    super.onCreateOptionsMenu(menu, inflater);
    inflater.inflate(R.menu.twitter_feed_menu, menu);
  }

  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    if (item.getItemId() == R.id.refresh_tweets) {
      twitterFeedPresentation.refresh();
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  public void onStart() {
    super.onStart();
    twitterFeedPresentation.attach(this);

    RxPermissions rxPermissions = new RxPermissions(this);
    LocationRepository locationRepository = new LocationRepository(getActivity(), rxPermissions);

    locationRepository.getLastLocation().as(
        AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(this)))
        .subscribe(latLong -> {
          this.latLong = latLong;
          Log.d(TwitterFeedFragment.class.getName(), "onSubscribe: " + latLong);
          if (tag.equals("")) {
            twitterFeedPresentation.getStatuses(tag, latLong, this);
          } else {
            twitterFeedPresentation.getStatuses(tag, null, this);

          }
        });
  }

  @Override
  public void onStop() {
    super.onStop();
    twitterFeedPresentation.detach();
  }

  @Override
  public void refresh() {
    twitterFeedPresentation.getStatuses(tag, latLong, this);
  }

  @Override
  public void showStatuses(List<StatusesItem> statusesItemList) {
    statusesItems = statusesItemList;
    Log.d(TwitterFeedFragment.class.getName(), "onLoadStatuses: " + statusesItems.size());
    statusesAdapter.setData(statusesItemList);
  }

  @Override
  public void showLoading() {
    progressBar.setVisibility(View.VISIBLE);
    mainFeedRecyclerView.setVisibility(View.GONE);
  }

  @Override
  public void hideLoading() {
    progressBar.setVisibility(View.GONE);
    mainFeedRecyclerView.setVisibility(View.VISIBLE);
  }

  private void initRecyclerView(List<StatusesItem> statusesItems) {
    mainFeedRecyclerView
        .setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
    statusesAdapter = new StatusesAdapter(statusesItems, twitterProfileInteractor);
    mainFeedRecyclerView.setAdapter(statusesAdapter);
  }

  public static TwitterFeedFragment newInstance(String str) {
    Bundle args = new Bundle();
    args.putString("GroupTag", str);
    TwitterFeedFragment fragment = new TwitterFeedFragment();
    fragment.setArguments(args);
    return fragment;
  }


}
