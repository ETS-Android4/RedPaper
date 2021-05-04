package com.example.redpaper.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.redpaper.MainActivity;
import com.example.redpaper.Post;
import com.example.redpaper.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.List;


public class ComposeFragment extends Fragment {

    public static final String TAG = "ComposeFragment";
    private Button btnSubmit;
    private EditText etPostTitle;
    private EditText etPostBody;
    private ImageView ivPostImage;

    public ComposeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_compose, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etPostTitle = view.findViewById(R.id.etPostTitle);
        etPostBody = view.findViewById(R.id.etPostBody);
        btnSubmit = view.findViewById(R.id.btnSubmit);
        ivPostImage = view.findViewById(R.id.ivPostImage);
        Spinner spinner = view.findViewById(R.id.sp_subreddit);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.subreddit_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etPostTitle.getText().toString();
                String body = etPostBody.getText().toString();
                if (body.isEmpty()) {
                    Toast.makeText(getContext(), "Body cannot be empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (title.isEmpty()) {
                    Toast.makeText(getContext(), "Title cannot be empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                ParseUser currentUser = ParseUser.getCurrentUser();
                savePost(title, body, currentUser);
            }
        });
    }
        private void queryPosts(){
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

        private void savePost(String title, String body, ParseUser currentUser) {
            Post post = new Post();
            post.setTitle(title);
            post.setDescription(body);
            post.setUser(currentUser);
            post.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e != null){
                        Log.e(TAG, "Error while saving Post", e);
                        Toast.makeText(getContext(), "Error While Posting!", Toast.LENGTH_SHORT).show();
                    }
                    Log.i(TAG, "Post successfully saved!");
                    etPostBody.setText("");
                    etPostTitle.setText("");
                }
            });
        }
    }
