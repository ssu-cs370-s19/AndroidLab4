package ssu.softwarednd.spring19.androidlab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import ssu.softwarednd.spring19.androidlab4.model.RecipeModel;
import ssu.softwarednd.spring19.androidlab4.network.RecipeSearchAsyncTask;

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

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //create a new task
                RecipeSearchAsyncTask task = new RecipeSearchAsyncTask();
                //create a Listener and add it to the task
                task.setRecipeListener(


                        new RecipeSearchAsyncTask.RecipeListener() {
                            @Override
                            public void onRecipeCallback(List<RecipeModel> recipeModels) {

                                RecipeModel first = recipeModels.get(0);

                                recipeName.setText(first.getRecipeName());
                                recipeRating.setText("Rating: " + first.getRecipeRating());

                            }
                        }


                );

                //start the task
                String searchTerm = searchEditText.getText().toString();
                task.execute(searchTerm);
            }
        });



    }


}
