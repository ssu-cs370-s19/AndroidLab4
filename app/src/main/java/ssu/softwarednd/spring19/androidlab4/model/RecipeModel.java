package ssu.softwarednd.spring19.androidlab4.model;

public class RecipeModel {

    private String recipeName;
    private int rating;


    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

// sample JSON object
/*

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
}

 */