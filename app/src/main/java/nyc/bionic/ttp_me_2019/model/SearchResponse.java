package nyc.bionic.ttp_me_2019.model;

import java.util.List;
import com.squareup.moshi.Json;

public class SearchResponse{

	@Json(name = "statuses")
	private List<StatusesItem> statuses;

	@Json(name = "search_metadata")
	private SearchMetadata searchMetadata;

	public List<StatusesItem> getStatuses(){
		return statuses;
	}

	public SearchMetadata getSearchMetadata(){
		return searchMetadata;
	}
}