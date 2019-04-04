package nyc.bionic.ttp_me_2019;

import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.textfield.TextInputLayout;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;
import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;
import nyc.bionic.ttp_me_2019.db.Group;
import nyc.bionic.ttp_me_2019.db.GroupDatabase;

public class CreateGroupActivity extends AppCompatActivity {


  @BindView(R.id.groupname_text_input)
  TextInputLayout groupenameTextInput;

  @BindView(R.id.save_group_button)
  Button saveGroupButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_create_group);
    ButterKnife.bind(this);
    saveGroupButton.setOnClickListener(v -> addGroup());
  }

  private void addGroup() {
    Completable.fromAction(() -> GroupDatabase.getInstance(this).groupStore()
        .insert(new Group(groupenameTextInput.getEditText().getText().toString()))).subscribeOn(
        Schedulers.io()).as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(this)))
        .subscribe();
    finish();
  }
}
