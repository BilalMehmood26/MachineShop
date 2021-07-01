package com.example.machineshop;

public class SignupModelClass {

    String mEmail, mPassword, mBusinessName, mbusinessAddress, mPhoneNo;

    public SignupModelClass(){}

    public SignupModelClass(String mEmail, String mPassword, String mBusinessName, String mbusinessAddress, String mPhoneNo) {
        this.mEmail = mEmail;
        this.mPassword = mPassword;
        this.mBusinessName = mBusinessName;
        this.mbusinessAddress = mbusinessAddress;
        this.mPhoneNo = mPhoneNo;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getmBusinessName() {
        return mBusinessName;
    }

    public void setmBusinessName(String mBusinessName) {
        this.mBusinessName = mBusinessName;
    }

    public String getMbusinessAddress() {
        return mbusinessAddress;
    }

    public void setMbusinessAddress(String mbusinessAddress) {
        this.mbusinessAddress = mbusinessAddress;
    }

    public String getmPhoneNo() {
        return mPhoneNo;
    }

    public void setmPhoneNo(String mPhoneNo) {
        this.mPhoneNo = mPhoneNo;
    }
}
