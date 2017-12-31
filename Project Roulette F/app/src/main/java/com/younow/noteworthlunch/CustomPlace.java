package com.younow.noteworthlunch;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 07/30/17.
 */

public class CustomPlace implements Parcelable {


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
    public static final Parcelable.Creator<CustomPlace> CREATOR = new Parcelable.Creator<CustomPlace>() {

        @Override
        public CustomPlace createFromParcel(Parcel source) {
            return new CustomPlace();
        }

        @Override
        public CustomPlace[] newArray(int size) {
            return new CustomPlace[size];
        }
    };
}
