package nyc.bionic.ttp_me_2019.group;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import java.util.ArrayList;
import java.util.List;
import nyc.bionic.ttp_me_2019.R;
import nyc.bionic.ttp_me_2019.controller.GroupsAdapter;
import nyc.bionic.ttp_me_2019.db.Group;

public class GroupsFragment extends Fragment implements GroupsPresentation {

  @BindView(R.id.groups_rv)
  RecyclerView groupsRecyclerView;

  private List<Group> groups = new ArrayList<>();

  private GroupsPresenter groupsPresenter;
  private GroupsAdapter groupsAdapter;
  private GroupFragmentInteractor groupFragmentInteractor;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_groups, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    ButterKnife.bind(this, view);
    groupsPresenter = new GroupsPresenter(getActivity());
    initRecyclerView(groups);
  }

  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    if (context instanceof GroupFragmentInteractor) {
      groupFragmentInteractor = (GroupFragmentInteractor) context;
    }
  }

  @Override
  public void onStart() {
    super.onStart();
    groupsPresenter.attach(this);

    groupsPresenter.getGroups(this);
  }

  @Override
  public void onStop() {
    super.onStop();
    groupsPresenter.detach();
  }

  @Override
  public void showGroups(List<Group> groups) {
    this.groups = groups;
    groupsAdapter.setData(groups);
  }

  private void initRecyclerView(List<Group> groups) {
    groupsRecyclerView
        .setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
    groupsAdapter = new GroupsAdapter(groups, groupFragmentInteractor);
    groupsRecyclerView.setAdapter(groupsAdapter);
  }

}
