package com.quietsandwich.projectf;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 07/14/17.
 */

public class ListItemObject implements Parcelable {
    private String name;
    private String address;
    private String phone;
    private int price;
    private String locale;
    private float rating;

    public ListItemObject(String name, String address, String phone, int price, String locale, float rating){
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.price = price;
        this.locale = locale;
        this.rating = rating;
    }

    public String getName(){
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress(){
        return address;
    }

    public int getPrice() {
        return price;
    }

    public String getLocale() {
        return locale;
    }

    public float getRating() {
        return rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(address);
        dest.writeString(phone);
        dest.writeInt(price);
        dest.writeString(locale);
        dest.writeFloat(rating);
    }

    private ListItemObject(Parcel in){
        this.name = in.readString();
        this.address = in.readString();
        this.phone = in.readString();
        this.price = in.readInt();
        this.locale = in.readString();
        this.rating = in.readFloat();
    }

    public static final Parcelable.Creator<ListItemObject> CREATOR = new Parcelable.Creator<ListItemObject>() {

        @Override
        public ListItemObject createFromParcel(Parcel source) {
            return new ListItemObject(source);
        }

        @Override
        public ListItemObject[] newArray(int size) {
            return new ListItemObject[size];
        }
    };
}