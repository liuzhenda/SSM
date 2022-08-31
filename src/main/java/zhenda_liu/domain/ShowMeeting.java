package zhenda_liu.domain;


//前端和meeting之间的中间实体类 方向由meeting到前端
public class ShowMeeting {

    private Integer mid;

    private Integer mrid;

    private String startt;

    private String ftime;

    private String state;

    public ShowMeeting() {
    }

    public ShowMeeting(Integer mid, Integer mrid, String startt, String ftime, String state) {
        this.mid = mid;
        this.mrid = mrid;
        this.startt = startt;
        this.ftime = ftime;
        this.state = state;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getMrid() {
        return mrid;
    }

    public void setMrid(Integer mrid) {
        this.mrid = mrid;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
