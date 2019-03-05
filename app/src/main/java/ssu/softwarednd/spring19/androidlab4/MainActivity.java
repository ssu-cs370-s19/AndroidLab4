package ssu.softwarednd.spring19.androidlab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ssu.softwarednd.spring19.androidlab4.model.RecipeModel;
import ssu.softwarednd.spring19.androidlab4.network.RecipeSearchAsyncTask;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText searchEditText;
    private Button searchButton;

    private TextView recipeName;
    private TextView recipeRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchEditText = findViewById(R.id.search_edit_text);
        searchButton = findViewById(R.id.recipe_search_button);
        recipeName = findViewById(R.id.textViewName);
        recipeRating = findViewById(R.id.textViewRating);

        searchButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create a new task
                RecipeSearchAsyncTask task = new RecipeSearchAsyncTask();

                // create a Listener and add it to the task
                // (this is based on the Listener contract you defined in AsyncTask)
                task.setRecipeListener(new RecipeSearchAsyncTask.RecipeListener() {
                    @Override
                    public void Callback(List<RecipeModel> recipes) {
                        //Show the first response on the screen
                        RecipeModel first = recipes.get(0);

                        recipeName.setText(first.getRecipeName());
                        recipeRating.setText("Rating: " + first.getRecipeRating());
                    }
                });

                // start the task
                String searchTerm = searchEditText.getText().toString();
                task.execute(searchTerm);

            }
        });
    }


}



