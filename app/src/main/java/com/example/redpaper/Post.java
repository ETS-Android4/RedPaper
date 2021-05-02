package com.example.redpaper;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Post")
public class Post extends ParseObject {

    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_TITLE = "Title";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_USER = "user";
    public static final String KEY_CREATED_KEY = "createdAt";
    public static final String KEY_DOWNVOTES = "downvotes";
    public static final String KEY_UPVOTES = "upvotes";


    public int getDownvotes(){
        return getInt(KEY_DOWNVOTES);
    }

    public void setDownvotes(int Downvotes){
        put(KEY_DOWNVOTES,  Downvotes);
    }

    public int getUpvotes(){
        return getInt(KEY_UPVOTES);
    }

    public void setUpvotes(int Upvotes){
        put(KEY_UPVOTES, Upvotes);
    }

    public String getDescription() {
        return getString(KEY_DESCRIPTION);
    }

    public String getTitle(){
        return getString(KEY_TITLE);
    }

    public void setTitle(String Title){
        put(KEY_TITLE, Title);
    }

    public void setDescription(String description){
        put(KEY_DESCRIPTION, description);
    }

    public ParseFile getImage() {
        return getParseFile(KEY_IMAGE);
    }

    public void setImage(ParseFile parseFile) {
        put(KEY_IMAGE, parseFile);
    }

    public ParseUser getUser() {
        return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser user) {
        put(KEY_USER, user);
    }
}

