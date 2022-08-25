package zhenda_liu.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Department implements Serializable {
    private Integer did;

    private String dname;

    //一对多的表现形式
    private List<Users> users;
    private List<Room> rooms;

    private Date dupdatetime;

    public Department() {
    }

    public Department(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Department{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", users=" + users +
                ", rooms=" + rooms +
                ", dupdatetime=" + dupdatetime +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Date getDupdatetime() {
        return dupdatetime;
    }

    public void setDupdatetime(Date dupdatetime) {
        this.dupdatetime = dupdatetime;
    }
}