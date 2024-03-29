package com.stradtman.flickerbrowser;

import java.io.Serializable;

class Photo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String mTitle;
    private String mAuthor;
    private String mAuthorId;
    private String mLink;
    private String mTags;
    private String mImage;

    public Photo(String title, String author, String authorId, String link, String tags, String image) {
        mTitle = title;
        mAuthor = author;
        mAuthorId = authorId;
        mLink = link;
        mTags = tags;
        mImage = image;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getAuthorId() {
        return mAuthorId;
    }

    public String getLink() {
        return mLink;
    }

    public String getTags() {
        return mTags;
    }

    public String getImage() {
        return mImage;
    }
    @Override
    public String toString() {
        return "Photo{" +
                "mTitle='"+mTitle+'\''+
                ", mAuthor='"+mAuthor+'\''+
                ", mAuthorId='"+mAuthorId+'\''+
                ", mLink='"+mLink+'\''+
                ", mTags='"+mTags+'\''+
                ", mImage='"+mImage+'\''+
                '}';
    }
}
