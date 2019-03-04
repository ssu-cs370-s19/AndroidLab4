package ssu.softwarednd.spring19.androidlab4.network;

import android.util.Log;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RecipeSearchHelper {
    private static final String TAG = "RecipeSearchHelper";

    private static final String baseApiUrl = "http://api.yummly.com/v1/api/recipes";
    private static final String apiKey = "ec3e34e0bb6801670dbd3dbd02ce7608";
    private static final String appId = "4911b643";


    /**
     * Searches the YummlyApi recipe database.
     * @param input the ingredient to search in recipes
     * @return string: JSON response with matching recipes
     */
    public static String searchRecipes(String input) {
        OkHttpClient client = new OkHttpClient();

        // piece together a valid url, starting with the base
        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseApiUrl).newBuilder();
        // and adding on a few more parts
        urlBuilder.addQueryParameter("_app_key", apiKey);
        urlBuilder.addQueryParameter("_app_id", appId);
        urlBuilder.addQueryParameter("q", input);
        // until it's ready to assemble
        String url = urlBuilder.build().toString();

        // form the Request with the newly built url
        Request request = new Request.Builder().url(url).build();

        try {
            // ask the server for a response
            Response response = client.newCall(request).execute();
            if (response != null) {
                // response also contains metadata: success vs fail, travel time, etc.
                // only need the search result here
                return response.body().string();
            }
        } catch (IOException e) {
            // log the error to the console window (logcat)
            Log.e(TAG, "searchRecipes: ", e);
        }
        return null;
    }

}
