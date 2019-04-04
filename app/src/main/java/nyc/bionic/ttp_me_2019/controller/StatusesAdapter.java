package nyc.bionic.ttp_me_2019.controller;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.squareup.picasso.Picasso;
import java.util.List;
import nyc.bionic.ttp_me_2019.R;
import nyc.bionic.ttp_me_2019.model.StatusesItem;
import nyc.bionic.ttp_me_2019.profile.TwitterProfileInteractor;

public class StatusesAdapter extends Adapter<StatusesAdapter.MainFeedViewHolder> {

  private List<StatusesItem> statusesItems;
  private TwitterProfileInteractor twitterProfileInteractor;

  public StatusesAdapter(List<StatusesItem> statusesItems,
      TwitterProfileInteractor twitterProfileInteractor) {
    this.twitterProfileInteractor = twitterProfileInteractor;
    this.statusesItems = statusesItems;
  }

  public StatusesAdapter(List<StatusesItem> statusesItems) {
    this.statusesItems = statusesItems;
  }

  @NonNull
  @Override
  public MainFeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new MainFeedViewHolder(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.mainfeed_item, parent, false),
        twitterProfileInteractor);
  }

  @Override
  public void onBindViewHolder(@NonNull MainFeedViewHolder holder, int position) {
    holder.onBind(statusesItems.get(position));
  }

  @Override
  public int getItemCount() {
    return statusesItems.size();
  }

  public void setData(List<StatusesItem> newStatuses) {
    statusesItems = newStatuses;
    notifyDataSetChanged();
  }

  public class MainFeedViewHolder extends ViewHolder {

    @BindView(R.id.mainfeed_screename)
    TextView screenNameTextView;

    @BindView(R.id.mainfeed_profile_photo)
    ImageView profilePhotoImageView;

    @BindView(R.id.mainfeed_created_time)
    TextView createdTimeTextView;

    @BindView(R.id.mainfeed_status)
    TextView statusTextView;

    private TwitterProfileInteractor twitterProfileInteractor;

    public MainFeedViewHolder(@NonNull View itemView,
        TwitterProfileInteractor twitterProfileInteractor) {
      super(itemView);
      ButterKnife.bind(this, itemView);
      this.twitterProfileInteractor = twitterProfileInteractor;
    }

    public void onBind(StatusesItem statusesItem) {
      screenNameTextView.setText(statusesItem.getUser().getName());
      createdTimeTextView.setText(statusesItem.getCreatedAt());
      statusTextView.setText(statusesItem.getText());
      Log.d(StatusesAdapter.class.getName(),
          "onBind: " + statusesItem.getUser().getProfileImageUrlHttps());
      Picasso.get().load(statusesItem.getUser().getProfileImageUrlHttps())
          .into(profilePhotoImageView);
      if (twitterProfileInteractor != null) {
        profilePhotoImageView.setOnClickListener(
            v -> this.twitterProfileInteractor.goToProfileFragment(statusesItem.getUser()));
      }
    }
  }
}
