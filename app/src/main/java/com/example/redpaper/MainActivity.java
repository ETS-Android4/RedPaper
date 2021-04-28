package com.example.redpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    private Button btnLogOut;
    private Button btnSubmit;
    private EditText etPostTitle;
    private EditText etPostBody;
    private ImageView ivPostImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogOut = findViewById(R.id.btn_logout);
        etPostTitle = findViewById(R.id.etPostTitle);
        etPostBody = findViewById(R.id.etPostBody);
        btnSubmit = findViewById(R.id.btnSubmit);
        ivPostImage = findViewById(R.id.ivPostImage);

        queryPosts();
        btnLogOut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.e(TAG, "Button Pressed for LogOut");
                ParseUser.logOutInBackground();
                goLoginActivity();
            }
        });
    }

    private void queryPosts() {
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.include(Post.KEY_USER);
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if (e != null){
                    Log.e(TAG, "Issue with getting posts!", e);
                    return;
                }
                for (Post post : posts) {
                    Log.i(TAG, "Post: " + post.getTitle() + " " + post.getDescription() + " Username: " + post.getUser().getUsername());
                }
            }
        });
    }

    private void goLoginActivity(){
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
            finish();
        }
    }




