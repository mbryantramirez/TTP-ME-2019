package nyc.bionic.ttp_me_2019.model;

import java.util.List;
import com.squareup.moshi.Json;

public class Url{

	@Json(name = "urls")
	private List<UrlsItem> urls;

	public List<UrlsItem> getUrls(){
		return urls;
	}
}