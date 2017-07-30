package com.younow.noteworthlunch;

/**
 * Created by user on 07/14/17.
 */

public class ListItemObject {
    private String title;
    private String address;

    public ListItemObject(String title, String address){
        this.title = title;
        this.address = address;
    }

    public String getTitle(){
        return title;
    }

    public String getAddress(){
        return address;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setAddress(String address){
        this.address = address;
    }
}