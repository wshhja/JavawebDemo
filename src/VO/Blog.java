package VO;

import java.sql.Date;

public class Blog {
    private String title;
    private int blogid;
    private int userid;
    private Date blogdate;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Date getBlogdate() {
        return blogdate;
    }

    public void setBlogdate(Date blogdate) {
        this.blogdate = blogdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
