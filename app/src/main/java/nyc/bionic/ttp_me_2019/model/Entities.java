package nyc.bionic.ttp_me_2019.model;

import java.util.List;
import com.squareup.moshi.Json;

public class Entities{

	@Json(name = "description")
	private Description description;

	@Json(name = "url")
	private Url url;

	@Json(name = "urls")
	private List<UrlsItem> urls;

	@Json(name = "hashtags")
	private List<Object> hashtags;

	@Json(name = "user_mentions")
	private List<Object> userMentions;

	@Json(name = "symbols")
	private List<Object> symbols;

	public Description getDescription(){
		return description;
	}

	public Url getUrl(){
		return url;
	}

	public List<UrlsItem> getUrls(){
		return urls;
	}

	public List<Object> getHashtags(){
		return hashtags;
	}

	public List<Object> getUserMentions(){
		return userMentions;
	}

	public List<Object> getSymbols(){
		return symbols;
	}
}