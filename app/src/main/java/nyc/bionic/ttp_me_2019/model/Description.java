package nyc.bionic.ttp_me_2019.model;

import java.util.List;
import com.squareup.moshi.Json;

public class Description{

	@Json(name = "urls")
	private List<Object> urls;

	public List<Object> getUrls(){
		return urls;
	}
}