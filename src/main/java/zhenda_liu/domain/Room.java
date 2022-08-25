package zhenda_liu.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Room implements Serializable {
    private Integer rid;

    private String config;

    private Integer rdid;

    private Date rupdatetime;

    //会议和会议室的多对一关系
    private List<Meeting> meetings;


    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }

    public Room() {
    }



    @Override
    public String toString() {
        return "Room{" +
                "rid=" + rid +
                ", config='" + config + '\'' +
                ", rdid=" + rdid +
                ", rupdatetime=" + rupdatetime +
                ", meetings=" + meetings +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public Integer getRdid() {
        return rdid;
    }

    public void setRdid(Integer rdid) {
        this.rdid = rdid;
    }

    public Date getRupdatetime() {
        return rupdatetime;
    }

    public void setRupdatetime(Date rupdatetime) {
        this.rupdatetime = rupdatetime;
    }
}