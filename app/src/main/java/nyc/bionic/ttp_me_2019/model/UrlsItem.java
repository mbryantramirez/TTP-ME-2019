package nyc.bionic.ttp_me_2019.model;

import java.util.List;
import com.squareup.moshi.Json;

public class UrlsItem{

	@Json(name = "display_url")
	private String displayUrl;

	@Json(name = "indices")
	private List<Integer> indices;

	@Json(name = "expanded_url")
	private String expandedUrl;

	@Json(name = "url")
	private String url;

	public String getDisplayUrl(){
		return displayUrl;
	}

	public List<Integer> getIndices(){
		return indices;
	}

	public String getExpandedUrl(){
		return expandedUrl;
	}

	public String getUrl(){
		return url;
	}
}