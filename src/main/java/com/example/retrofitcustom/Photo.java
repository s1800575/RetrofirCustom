package com.example.retrofitcustom;

import com.google.gson.annotations.SerializedName;

public class Photo {

    private int albumId;
    private int id;
    private String title;
    private String url;

    // annotaatio, käytöämme muuttujaa smallUrl -ohjelmassa, mutta thumbnailUrl JSONissa
    @SerializedName("thumbnailUrl")
    private String smallUrl;

    public int getAlbumId() {
        return albumId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getSmallUrl() {
        return smallUrl;
    }


}


