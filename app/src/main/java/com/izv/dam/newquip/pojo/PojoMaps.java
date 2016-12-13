package com.izv.dam.newquip.pojo;


import android.os.Parcel;
import android.os.Parcelable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by dam on 5/12/16.
 */

@DatabaseTable(tableName = "localizaciones")
public class PojoMaps implements Parcelable {

    @DatabaseField
    long id;

    @DatabaseField
    float latitude;

    @DatabaseField
    float longitude;

    public PojoMaps(long id, float latitude, float longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public PojoMaps() {
        this(0, (float) 0.0, (float) 0.0);
    }

    protected PojoMaps(Parcel in) {
        id = in.readLong();
        latitude = in.readFloat();
        longitude = in.readFloat();
    }

    public static final Creator<PojoMaps> CREATOR = new Creator<PojoMaps>() {
        @Override
        public PojoMaps createFromParcel(Parcel in) {
            return new PojoMaps(in);
        }

        @Override
        public PojoMaps[] newArray(int size) {
            return new PojoMaps[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Localizaciones{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeFloat(latitude);
        dest.writeFloat(longitude);
    }
}