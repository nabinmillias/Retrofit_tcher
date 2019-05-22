
package com.example.retrofitnew;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Regmodel {

    @SerializedName("Status")
    private String mStatus;

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
