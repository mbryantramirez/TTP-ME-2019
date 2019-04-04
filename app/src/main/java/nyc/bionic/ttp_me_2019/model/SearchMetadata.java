package nyc.bionic.ttp_me_2019.model;

import com.squareup.moshi.Json;

public class SearchMetadata {

  @Json(name = "max_id_str")
  private String maxIdStr;

  @Json(name = "next_results")
  private String nextResults;

  @Json(name = "since_id_str")
  private String sinceIdStr;

  @Json(name = "query")
  private String query;

  @Json(name = "count")
  private Integer count;

  @Json(name = "max_id")
  private Long maxId;

  @Json(name = "since_id")
  private Integer sinceId;

  @Json(name = "completed_in")
  private Double completedIn;

  public String getMaxIdStr() {
    return maxIdStr;
  }

  public String getNextResults() {
    return nextResults;
  }

  public String getSinceIdStr() {
    return sinceIdStr;
  }

  public String getQuery() {
    return query;
  }

  public Integer getCount() {
    return count;
  }

  public Long getMaxId() {
    return maxId;
  }

  public Integer getSinceId() {
    return sinceId;
  }

  public Double getCompletedIn() {
    return completedIn;
  }
}