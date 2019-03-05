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

        searchEditText = (EditText)findViewById(R.id.search_edit_text);
        searchButton = (Button)findViewById(R.id.recipe_search_button);

        recipeName = (TextView)findViewById(R.id.recipe_name_label);
        recipeRating = (TextView)findViewById(R.id.recipe_rating_label);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RecipeSearchAsyncTask task = new RecipeSearchAsyncTask();
                task.setRecipeListener(new RecipeSearchAsyncTask.RecipeListener() {
                    @Override
                    public void onClick(List<RecipeModel> recipeModels) {
                        RecipeModel first = models.get(0);
                    }
                });
                String searchTerm = searchEditText.getText().toString();
                task.execute(searchTerm);
            }
        });

    }




}
