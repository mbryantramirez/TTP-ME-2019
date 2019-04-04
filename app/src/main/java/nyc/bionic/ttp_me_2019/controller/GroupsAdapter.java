package nyc.bionic.ttp_me_2019.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.List;
import nyc.bionic.ttp_me_2019.R;
import nyc.bionic.ttp_me_2019.db.Group;
import nyc.bionic.ttp_me_2019.group.GroupFragmentInteractor;

public class GroupsAdapter extends RecyclerView.Adapter<GroupsAdapter.GroupsViewHolder> {

  private List<Group> groups;
  private GroupFragmentInteractor groupFragmentInteractor;

  public GroupsAdapter(List<Group> groups,
      GroupFragmentInteractor groupFragmentInteractor) {
    this.groups = groups;
    this.groupFragmentInteractor = groupFragmentInteractor;
  }

  @NonNull
  @Override
  public GroupsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new GroupsViewHolder(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.group_item, parent, false),
        groupFragmentInteractor);
  }

  @Override
  public void onBindViewHolder(@NonNull GroupsViewHolder holder, int position) {
    holder.onBind(groups.get(position));
  }

  @Override
  public int getItemCount() {
    return groups.size();
  }

  public void setData(List<Group> groups) {
    this.groups = groups;
    notifyDataSetChanged();
  }

  public class GroupsViewHolder extends ViewHolder {

    @BindView(R.id.group_name_tv)
    TextView groupTextView;

    private GroupFragmentInteractor groupFragmentInteractor;

    public GroupsViewHolder(@NonNull View itemView,
        GroupFragmentInteractor groupFragmentInteractor) {
      super(itemView);
      ButterKnife.bind(this, itemView);
      this.groupFragmentInteractor = groupFragmentInteractor;
      itemView.setOnClickListener(v -> groupFragmentInteractor.goToGroup(groupTextView.getText().toString()));
    }

    public void onBind(Group group) {
      groupTextView.setText(group.name);
    }
  }
}
