package com.tanmay.lucy;

public class Model {

    private String username;
    private String caption;
    private String description;
    private int profImage;
    private int postImage;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProfImage() {
        return profImage;
    }

    public void setProfImage(int profImage) {
        this.profImage = profImage;
    }

    public int getPostImage() {
        return postImage;
    }

    public void setPostImage(int postImage) {
        this.postImage = postImage;
    }
}
