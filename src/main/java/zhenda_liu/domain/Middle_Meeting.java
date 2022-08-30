package zhenda_liu.domain;

import java.util.Date;

public class Middle_Meeting {
    private Integer mrid;

    private Integer mid;

    private String ouname;

    private String startt;

    private String ftime;

    private int state;

    public Middle_Meeting() {
    }

    public Middle_Meeting(Integer mrid, String ouname, String startt, String ftime) {
        this.mrid = mrid;
        this.ouname = ouname;
        this.startt = startt;
        this.ftime = ftime;
    }

    public Integer getMrid() {
        return mrid;
    }

    public void setMrid(Integer mrid) {
        this.mrid = mrid;
    }

    public String getOuname() {
        return ouname;
    }

    public void setOuname(String ouname) {
        this.ouname = ouname;
    }

    public String getStartt() {
        return startt;
    }

    public void setStartt(String startt) {
        this.startt = startt;
    }

    public String getFtime() {
        return ftime;
    }

    public void setFtime(String ftime) {
        this.ftime = ftime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }
}
