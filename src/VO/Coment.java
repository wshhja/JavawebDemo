package VO;

import java.sql.Date;

public class Coment {
    private int comentid;
    private int blogid;
    private int userid;
    private Date comentdate;
    private String coment;

    public int getComentid() {
        return comentid;
    }

    public void setComentid(int comentid) {
        this.comentid = comentid;
    }

    public int getBlogid() {
        return blogid;
    }

    public void setBlogid(int blogid) {
        this.blogid = blogid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getComentdate() {
        return comentdate;
    }

    public void setComentdate(Date comentdate) {
        this.comentdate = comentdate;
    }

    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }
}
