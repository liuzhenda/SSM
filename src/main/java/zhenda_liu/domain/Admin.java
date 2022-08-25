package zhenda_liu.domain;

import java.io.Serializable;
import java.util.Date;

public class Admin implements Serializable {
    private Integer aid;

    private String aname;

    private String apsd;

    private Date aupdatetime;

    public Admin() {
    }

    public Admin(String aname, String apsd) {
        this.aname = aname;
        this.apsd = apsd;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", apsd='" + apsd + '\'' +
                ", aupdatetime=" + aupdatetime +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApsd() {
        return apsd;
    }

    public void setApsd(String apsd) {
        this.apsd = apsd;
    }

    public Date getAupdatetime() {
        return aupdatetime;
    }

    public void setAupdatetime(Date aupdatetime) {
        this.aupdatetime = aupdatetime;
    }
}