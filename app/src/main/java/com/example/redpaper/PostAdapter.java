package com.example.redpaper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.parse.ParseFile;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private Context context;
    private List<Post> posts;


    public PostAdapter(Context context, List<Post> posts){
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post);

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvUsername;
        private ImageView ivImage;
        private TextView tvDescription;
        private TextView tvTitle;
        private TextView tvUpvotes;
        private TextView tvDownvotes;
        private ImageView btnComments;
        private ImageView ivUpvotes;
        private ImageView ivDownvotes;
        private boolean upvotebool = false;
        private boolean downvotebool = false;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvUpvotes = itemView.findViewById(R.id.tvUpvote);
            tvDownvotes = itemView.findViewById(R.id.tvDownvote);
            btnComments = itemView.findViewById(R.id.ivComments);
            ivUpvotes = itemView.findViewById(R.id.ivUpvote);
            ivDownvotes = itemView.findViewById(R.id.ivDownvote);

        }

        public void bind(Post post) {
            //Bind the post data to the view elements
            tvDescription.setText(post.getDescription());
            tvUsername.setText(post.getUser().getUsername());
            tvTitle.setText(post.getTitle());
            tvUpvotes.setText(String.valueOf(post.getUpvotes()));
            tvDownvotes.setText(String.valueOf(post.getDownvotes()));

            ivUpvotes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (upvotebool == false){
                    post.increment("upvotes");
                    post.increment("downvotes", -1);
                    post.saveInBackground();
                    notifyDataSetChanged();
                    upvotebool = true;
                    }
                    else{
                        post.increment("upvotes", -1);
                        post.increment("downvotes", +1);
                        post.saveInBackground();
                        notifyDataSetChanged();
                        upvotebool = false;
                    }
                }
            });

            ivDownvotes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(downvotebool == false) {
                        post.increment("downvotes");
                        post.increment("upvotes", -1);
                        post.saveInBackground();
                        notifyDataSetChanged();
                        downvotebool = true;
                    }
                    else{
                        post.increment("downvotes", -1);
                        post.increment("upvotes", 1);
                        post.saveInBackground();
                        notifyDataSetChanged();
                        downvotebool = false;
                    }
                }
            });
            }
        }
    }

