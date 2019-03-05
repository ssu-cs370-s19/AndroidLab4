package ssu.softwarednd.spring19.androidlab4.utility;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ssu.softwarednd.spring19.androidlab4.model.RecipeModel;

public class RecipeParser {

    // TAG is used in logging, to help trace where output comes from
    private static final String TAG = "RecipeParser";


    /**
     * Returns a list of RecipeModels, representing recipes in the json
     * @param json String json representing the server's response
     * @return List of recipes (as RecipeModels)
     */
    public static List<RecipeModel> getMatches(String json) {


        List<RecipeModel> modelList = new ArrayList<>();


        try {
            JSONObject response = new JSONObject(json);

            // todo: deserialize! json -> Java
            JSONArray matches = response.getJSONArray("matches");
            JSONObject recipe = matches.getJSONObject(0);
            String recipeName = recipe.getString("recipeName");
            String rating = recipe.getString("rating");
            RecipeModel reci = new RecipeModel();
            reci.setRecipeName(recipeName);
            reci.setRecipeRating(rating);
            modelList.add(reci);

        } catch (JSONException e) {
            Log.e(TAG, "getMatches: error parsing JSON", e);
        }


        return modelList;
    }
}


// sample request/response

// http://api.yummly.com/v1/api/recipes?_app_key=ec3e34e0bb6801670dbd3dbd02ce7608&_app_id=4911b643&q=lemon

/* beginning of JSON Object (response from server)

{
  // totalMatchCount is an integer
  "totalMatchCount": 271173,

  // criteria is a (nested) JSON object
  "criteria": {
    // q is a string
    "q": "lemon",
    "allowedIngredient": null,
    "excludedIngredient": null
  },

  // matches is a JSON Array, containing JSON Objects
  "matches": [
    {
      "imageUrlsBySize": {
        "90": "https://lh3.googleusercontent.com/1sRneVeIt7c64tCetDy6xDhrX0rlf1HFstIjOO6MAkMOB_yr9TPzqGNUPKHO2onV9XVGYkN7dDKi3V8qsivzuw=s90-c"
      },
      "sourceDisplayName": "I Save A2Z",
      "ingredients": [
        "white sugar",
        "water",
        "blackberries",
        "cold water",
        "fresh lemon juice",
        "ice cubes"
      ],
      "id": "Homemade-Blue-Lemonade-2536078",
      "smallImageUrls": [
        "https://lh3.googleusercontent.com/XpRHgw4VTJT09upEdPYtfAD1_XzsomTfybaGWseSyxmzBSAYzCEsonJi5Wm6HK_H8cZIJkzjOt0fFdjNyICPbz8=s90"
      ],
      "recipeName": "Homemade Blue Lemonade",
      "totalTimeInSeconds": 300,
      "attributes": {
        "course": [
          "Beverages"
        ],
        "cuisine": [
          "Kid-Friendly"
        ],
        "holiday": [
          "Summer"
        ]
      },
      "flavors": {
        "piquant": 0,
        "meaty": 0,
        "bitter": 0,
        "sweet": 0.3333333333333333,
        "sour": 0.16666666666666666,
        "salty": 0
      },
      "rating": 4
    },

    // more json objects
    { ... },
    { ... },
    { ... },
    { ... },
    { ... },
    { ... },
    { ... },
    { ... },
    { ... }
  ],

  "attribution": {
    "html": "Recipe search powered by <a href='http://www.yummly.co/recipes'><img alt='Yummly' src='https://static.yummly.co/api-logo.png'/></a>",
    "url": "http://www.yummly.co/recipes/",
    "text": "Recipe search powered by Yummly",
    "logo": "https://static.yummly.co/api-logo.png"
  }
}  // end of response object

*/