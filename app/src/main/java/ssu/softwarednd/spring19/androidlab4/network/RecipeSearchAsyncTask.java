package ssu.softwarednd.spring19.androidlab4.network;

import android.os.AsyncTask;

import java.util.List;

import ssu.softwarednd.spring19.androidlab4.model.RecipeModel;
import ssu.softwarednd.spring19.androidlab4.utility.RecipeParser;

public class RecipeSearchAsyncTask extends AsyncTask<String, Void, List<RecipeModel>> {
/*
AsyncTask is a templated class: AsyncTask<PARAMS, PROGRESS, RESULT>

PARAMS is the datatype that we pass to execute()
    - a String we get from the users input (in MainActivity)
PROGRESS is the datatype we use to report updates
    - not used -> Void (aka null)
RESULT is the datatype that we send back on completion of this task
    - a List containing the recipes that matched the user input

List is a templated class too.
A List that contains RecipeModels -> List<RecipeModel>
*/


    private RecipeListener listener;

    public interface RecipeListener {
        // todo: define listener "contract" (function prototype)
        void onClick (List<RecipeModel> recipeModels);
    }

    @Override
    protected List<RecipeModel> doInBackground(String... params) {
        // runs on a background thread, not blocking main

        String searchTerm = params[0];  // what we're searching for

        // get the json response from Yummly's Recipe API
        String responseJson = RecipeSearchHelper.searchRecipes(searchTerm);

        // success? :)
        if (responseJson != null) {
            List<RecipeModel> models = RecipeParser.getMatches(responseJson);
            return models;
        }

        // no success :(
        return null;
    }


    @Override
    protected void onPostExecute(List<RecipeModel> recipeModels) {
        // happens after doInBackground, and runs on main thread
        super.onPostExecute(recipeModels);
        listener.onClick(recipeModels);

        // todo: notify listener
    }


    public void setRecipeListener(RecipeListener listener) {
        this.listener = listener;
    }
}
