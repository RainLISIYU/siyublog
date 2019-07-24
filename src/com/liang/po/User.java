package com.liang.po;

import java.sql.Date;

/**
 * @author 梁思禹
 */
public class User {

    private String uName;
    private String uPassword;
    private String uPhoneNumber;
    private String uEmail;
    private Date uDate;
    private int uGender;
    private String uHobby;
    private String uMessage;

    public int getuGender() {
        return uGender;
    }

    public void setuGender(int uGender) {
        this.uGender = uGender;
    }

    public String getuHobby() {
        return uHobby;
    }

    public void setuHobby(String uHobby) {
        this.uHobby = uHobby;
    }

    public String getuMessage() {
        return uMessage;
    }

    public void setuMessage(String uMessage) {
        this.uMessage = uMessage;
    }

    public String getuName() {
        return uName;
    }

    public Date getuDate() {
        return uDate;
    }

    public void setuDate(Date uDate) {
        this.uDate = uDate;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuPhoneNumber() {
        return uPhoneNumber;
    }

    public void setuPhoneNumber(String uPhoneNumber) {
        this.uPhoneNumber = uPhoneNumber;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String email) {
        this.uEmail = email;
    }

    @Override
    public String toString(){
        return uName+" "+uPassword+" "+uPhoneNumber+" "+uEmail+" "+uGender+" "
                +uHobby;
    }

}
