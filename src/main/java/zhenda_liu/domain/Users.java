package zhenda_liu.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Users implements Serializable {
    private Integer uid;

    private String uname;

    private String upsd;

    private Integer udid;

    private Date uupdatetime;

    //用户和会议的多对多关系，相对应的 会议那边也有一个类似的
    private List<Meeting> meetings;

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }

    public Users() {
    }

    public Users(String uname, String upsd) {
        this.uname = uname;
        this.upsd = upsd;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upsd='" + upsd + '\'' +
                ", udid=" + udid +
                ", uupdatetime=" + uupdatetime +
                ", meetings=" + meetings +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpsd() {
        return upsd;
    }

    public void setUpsd(String upsd) {
        this.upsd = upsd;
    }

    public Integer getUdid() {
        return udid;
    }

    public void setUdid(Integer udid) {
        this.udid = udid;
    }

    public Date getUupdatetime() {
        return uupdatetime;
    }

    public void setUupdatetime(Date uupdatetime) {
        this.uupdatetime = uupdatetime;
    }
}