package zhenda_liu.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//该文件注意第24行
public class Meeting implements Serializable {
    private Integer mid;

    private Integer mrid;

    private Integer ouid;

    private Date startt;

    private Date ftime;

    private Integer state;

    //8.26经过对数据库插入数据后了解到用户和会议并不存在多对多的关系，这里存在问题，但是实际使用下来可能没有影响，故对其进行保留
    //8.25用户和会议的多对多关系，相对应的用户那边也有一个类似的
    private List<Users> users;

    private Date mupdatetime;

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public Meeting() {
    }

    public Meeting(Integer ouid, Date startt, Date ftime, Integer state) {
        this.ouid = ouid;
        this.startt = startt;
        this.ftime = ftime;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "mid=" + mid +
                ", mrid=" + mrid +
                ", ouid=" + ouid +
                ", startt=" + startt +
                ", ftime=" + ftime +
                ", state=" + state +
                ", users=" + users +
                ", mupdatetime=" + mupdatetime +
                '}';
    }

    public String TimeToString(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "该会议的开始时间:"+simpleDateFormat.format(startt)+"结束时间:"+simpleDateFormat.format(ftime);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
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

    public Integer getOuid() {
        return ouid;
    }

    public void setOuid(Integer ouid) {
        this.ouid = ouid;
    }

    public Date getStartt() {
        return startt;
    }

    public void setStartt(Date startt) {
        this.startt = startt;
    }

    public Date getFtime() {
        return ftime;
    }

    public void setFtime(Date ftime) {
        this.ftime = ftime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getMupdatetime() {
        return mupdatetime;
    }

    public void setMupdatetime(Date mupdatetime) {
        this.mupdatetime = mupdatetime;
    }
}