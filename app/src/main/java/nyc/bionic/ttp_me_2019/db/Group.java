package nyc.bionic.ttp_me_2019.db;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "groups")
public class Group {

  @PrimaryKey(autoGenerate = true)
  public int id;

  public final String name;

  public Group(String name) {
    this.name = name;
  }

}
