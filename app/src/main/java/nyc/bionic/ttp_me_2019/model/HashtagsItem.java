package nyc.bionic.ttp_me_2019.model;

import java.util.List;
import com.squareup.moshi.Json;

public class HashtagsItem{

	@Json(name = "indices")
	private List<Integer> indices;

	@Json(name = "text")
	private String text;

	public List<Integer> getIndices(){
		return indices;
	}

	public String getText(){
		return text;
	}
}