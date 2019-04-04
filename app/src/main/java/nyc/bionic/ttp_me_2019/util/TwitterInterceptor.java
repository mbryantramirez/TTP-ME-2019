package nyc.bionic.ttp_me_2019.util;

import android.util.Base64;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class TwitterInterceptor implements Interceptor {

  private String token = null;

  @NotNull
  @Override
  public Response intercept(@NotNull Chain chain) throws IOException {
    Request request = chain.request();

    if (token == null) {
      ResponseBody body = chain.proceed(getToken()).body();
      try {
        JSONObject jsonObject = new JSONObject(body.string());
        token = "Bearer " + jsonObject.optString("access_token");
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }
    request = request.newBuilder().addHeader("Authorization", token).build();
    return chain.proceed(request);
  }

  private Request getToken() {

    String bearerToken =
        "gb3Zgm3uiGh0jX7xtPsCv3p1x" + ":" + "8g7D3hsmTIPouMUQOIhLzSy2cPUXd20cX3D6SqMIBAL6TYbY1p";

    String base64BearerToken =
        "Basic " + Base64.encodeToString(bearerToken.getBytes(), Base64.NO_WRAP);
    RequestBody requestBody = RequestBody
        .create(MediaType.parse("application/x-www-form-urlencoded;charset=UTF-8"),
            "grant_type=client_credentials");

    return new Request.Builder().url("https://api.twitter.com/oauth2/token").post(requestBody)
        .header("Authorization", base64BearerToken)
        .header("User-Agent", "TTPBuild")
        .header("Content-type", "application/x-www-form-urlencoded;charset=UTF-8").build();
  }


}
