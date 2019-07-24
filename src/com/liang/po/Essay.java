package com.liang.po;

import java.sql.Date;
import java.util.List;

/**
 * @author 梁思禹
 */
public class Essay {
    private int eId;
    private String uName;
    private String essay;
    private Date eDate;
    private int ePower;
    private List<Reply> replies;

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public String getEssay() {
        return essay;
    }

    public void setEssay(String essay) {
        this.essay = essay;
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String eName) {
        this.uName = eName;
    }

    public Date geteDate() {
        return eDate;
    }

    public void seteDate(Date eDate) {
        this.eDate = eDate;
    }

    public int getePower() {
        return ePower;
    }

    public void setePower(int ePower) {
        this.ePower = ePower;
    }

    @Override
    public String toString(){
        return eId+" "+uName+" "+essay;
    }
}
