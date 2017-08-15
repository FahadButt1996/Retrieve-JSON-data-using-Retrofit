package com.example.mfahad.jsondata;

import com.google.gson.annotations.SerializedName;

/**
 * Created by M.FAHAD on 8/14/2017.
 */

public class Data {
    public Data(){}
    @SerializedName("postId")
    private String postId;
    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private String id;
    @SerializedName("email")
    private String email;
    @SerializedName("body")
    private String body;

    public String getName() {
        return name;
    }

    public String getId() { return id; }

    public String getEmail() {
        return email;
    }

    public String getPostId() {
        return postId;
    }

    public String getBody() {
        return body;
    }
}
