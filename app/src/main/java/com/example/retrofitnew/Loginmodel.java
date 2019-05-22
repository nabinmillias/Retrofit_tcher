
package com.example.retrofitnew;


import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Loginmodel {

    @SerializedName("RegNo")
    private String mRegNo;
    @SerializedName("Status")
    private String mStatus;

    public String getRegNo() {
        return mRegNo;
    }

    public void setRegNo(String regNo) {
        mRegNo = regNo;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
