package nyc.bionic.ttp_me_2019.model;

import com.squareup.moshi.Json;

public class StatusesItem {

  @Json(name = "metadata")
  private Metadata metadata;

  @Json(name = "in_reply_to_status_id_str")
  private Object inReplyToStatusIdStr;

  @Json(name = "in_reply_to_status_id")
  private Object inReplyToStatusId;

  @Json(name = "created_at")
  private String createdAt;

  @Json(name = "in_reply_to_user_id_str")
  private Object inReplyToUserIdStr;

  @Json(name = "source")
  private String source;

  @Json(name = "retweet_count")
  private int retweetCount;

  @Json(name = "retweeted")
  private boolean retweeted;

  @Json(name = "geo")
  private Object geo;

  @Json(name = "in_reply_to_screen_name")
  private Object inReplyToScreenName;

  @Json(name = "is_quote_status")
  private boolean isQuoteStatus;

  @Json(name = "id_str")
  private String idStr;

  @Json(name = "in_reply_to_user_id")
  private Object inReplyToUserId;

  @Json(name = "favorite_count")
  private int favoriteCount;

  @Json(name = "id")
  private long id;

  @Json(name = "text")
  private String text;

  @Json(name = "place")
  private Object place;

  @Json(name = "lang")
  private String lang;

  @Json(name = "favorited")
  private boolean favorited;

  @Json(name = "possibly_sensitive")
  private boolean possiblySensitive;

  @Json(name = "coordinates")
  private Object coordinates;

  @Json(name = "truncated")
  private boolean truncated;

  @Json(name = "entities")
  private Entities entities;

  @Json(name = "contributors")
  private Object contributors;

  @Json(name = "user")
  private User user;


  public Metadata getMetadata() {
    return metadata;
  }


  public Object getInReplyToStatusId() {
    return inReplyToStatusId;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public Object getInReplyToUserIdStr() {
    return inReplyToUserIdStr;
  }

  public String getSource() {
    return source;
  }

  public int getRetweetCount() {
    return retweetCount;
  }

  public boolean isRetweeted() {
    return retweeted;
  }

  public Object getGeo() {
    return geo;
  }

  public Object getInReplyToScreenName() {
    return inReplyToScreenName;
  }

  public boolean isIsQuoteStatus() {
    return isQuoteStatus;
  }

  public String getIdStr() {
    return idStr;
  }

  public Object getInReplyToUserId() {
    return inReplyToUserId;
  }

  public int getFavoriteCount() {
    return favoriteCount;
  }

  public long getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  public Object getPlace() {
    return place;
  }

  public String getLang() {
    return lang;
  }

  public boolean isFavorited() {
    return favorited;
  }

  public boolean isPossiblySensitive() {
    return possiblySensitive;
  }

  public Object getCoordinates() {
    return coordinates;
  }

  public boolean isTruncated() {
    return truncated;
  }

  public Entities getEntities() {
    return entities;
  }

  public Object getContributors() {
    return contributors;
  }

  public User getUser() {
    return user;
  }

  public Object getInReplyToStatusIdStr() {
    return inReplyToStatusIdStr;
  }
}