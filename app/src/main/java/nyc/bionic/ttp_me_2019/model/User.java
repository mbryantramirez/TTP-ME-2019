package nyc.bionic.ttp_me_2019.model;

import android.content.Intent;
import com.squareup.moshi.Json;

public class User {

  @Json(name = "utc_offset")
  private Integer utcOffset;

  @Json(name = "friends_count")
  private Integer friendsCount;

  @Json(name = "profile_image_url_https")
  private String profileImageUrlHttps;

  @Json(name = "listed_count")
  private Integer listedCount;

  @Json(name = "profile_background_image_url")
  private String profileBackgroundImageUrl;

  @Json(name = "default_profile_image")
  private Boolean defaultProfileImage;

  @Json(name = "favourites_count")
  private Integer favouritesCount;

  @Json(name = "description")
  private String description;

  @Json(name = "created_at")
  private String createdAt;

  @Json(name = "is_translator")
  private Boolean isTranslator;

  @Json(name = "profile_background_image_url_https")
  private String profileBackgroundImageUrlHttps;

  @Json(name = "protected")
  private Boolean jsonMemberProtected;

  @Json(name = "screen_name")
  private String screenName;

  @Json(name = "id_str")
  private String idStr;

  @Json(name = "profile_link_color")
  private String profileLinkColor;

  @Json(name = "is_translation_enabled")
  private Boolean isTranslationEnabled;

  @Json(name = "translator_type")
  private String translatorType;

  @Json(name = "id")
  private Long id;

  @Json(name = "geo_enabled")
  private Boolean geoEnabled;

  @Json(name = "profile_background_color")
  private String profileBackgroundColor;

  @Json(name = "lang")
  private String lang;

  @Json(name = "has_extended_profile")
  private Boolean hasExtendedProfile;

  @Json(name = "profile_sidebar_border_color")
  private String profileSidebarBorderColor;

  @Json(name = "profile_text_color")
  private String profileTextColor;

  @Json(name = "verified")
  private Boolean verified;

  @Json(name = "profile_image_url")
  private String profileImageUrl;

  @Json(name = "time_zone")
  private String timeZone;

  @Json(name = "url")
  private String url;

  @Json(name = "contributors_enabled")
  private Boolean contributorsEnabled;

  @Json(name = "profile_background_tile")
  private Boolean profileBackgroundTile;

  @Json(name = "profile_banner_url")
  private String profileBannerUrl;

  @Json(name = "entities")
  private Entities entities;

  @Json(name = "statuses_count")
  private Integer statusesCount;

  @Json(name = "follow_request_sent")
  private Object followRequestSent;

  @Json(name = "followers_count")
  private Integer followersCount;

  @Json(name = "profile_use_background_image")
  private Boolean profileUseBackgroundImage;

  @Json(name = "default_profile")
  private Boolean defaultProfile;

  @Json(name = "following")
  private Object following;

  @Json(name = "name")
  private String name;

  @Json(name = "location")
  private String location;

  @Json(name = "profile_sidebar_fill_color")
  private String profileSidebarFillColor;

  @Json(name = "notifications")
  private Object notifications;

  public Integer getUtcOffset() {
    return utcOffset;
  }

  public Integer getFriendsCount() {
    return friendsCount;
  }

  public String getProfileImageUrlHttps() {
    return profileImageUrlHttps;
  }

  public Integer getListedCount() {
    return listedCount;
  }

  public String getProfileBackgroundImageUrl() {
    return profileBackgroundImageUrl;
  }

  public Boolean getDefaultProfileImage() {
    return defaultProfileImage;
  }

  public Integer getFavouritesCount() {
    return favouritesCount;
  }

  public String getDescription() {
    return description;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public Boolean getTranslator() {
    return isTranslator;
  }

  public String getProfileBackgroundImageUrlHttps() {
    return profileBackgroundImageUrlHttps;
  }

  public Boolean getJsonMemberProtected() {
    return jsonMemberProtected;
  }

  public String getScreenName() {
    return screenName;
  }

  public String getIdStr() {
    return idStr;
  }

  public String getProfileLinkColor() {
    return profileLinkColor;
  }

  public Boolean getTranslationEnabled() {
    return isTranslationEnabled;
  }

  public String getTranslatorType() {
    return translatorType;
  }

  public Long getId() {
    return id;
  }

  public Boolean getGeoEnabled() {
    return geoEnabled;
  }

  public String getProfileBackgroundColor() {
    return profileBackgroundColor;
  }

  public String getLang() {
    return lang;
  }

  public Boolean getHasExtendedProfile() {
    return hasExtendedProfile;
  }

  public String getProfileSidebarBorderColor() {
    return profileSidebarBorderColor;
  }

  public String getProfileTextColor() {
    return profileTextColor;
  }

  public Boolean getVerified() {
    return verified;
  }

  public String getProfileImageUrl() {
    return profileImageUrl;
  }

  public String getTimeZone() {
    return timeZone;
  }

  public String getUrl() {
    return url;
  }

  public Boolean getContributorsEnabled() {
    return contributorsEnabled;
  }

  public Boolean getProfileBackgroundTile() {
    return profileBackgroundTile;
  }

  public String getProfileBannerUrl() {
    return profileBannerUrl;
  }

  public Entities getEntities() {
    return entities;
  }

  public Integer getStatusesCount() {
    return statusesCount;
  }

  public Object getFollowRequestSent() {
    return followRequestSent;
  }

  public Integer getFollowersCount() {
    return followersCount;
  }

  public Boolean getProfileUseBackgroundImage() {
    return profileUseBackgroundImage;
  }

  public Boolean getDefaultProfile() {
    return defaultProfile;
  }

  public Object getFollowing() {
    return following;
  }

  public String getName() {
    return name;
  }

  public String getLocation() {
    return location;
  }

  public String getProfileSidebarFillColor() {
    return profileSidebarFillColor;
  }

  public Object getNotifications() {
    return notifications;
  }
}