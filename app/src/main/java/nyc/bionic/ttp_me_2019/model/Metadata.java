package nyc.bionic.ttp_me_2019.model;

import com.squareup.moshi.Json;

public class Metadata{

	@Json(name = "result_type")
	private String resultType;

	@Json(name = "iso_language_code")
	private String isoLanguageCode;

	public String getResultType(){
		return resultType;
	}

	public String getIsoLanguageCode(){
		return isoLanguageCode;
	}
}