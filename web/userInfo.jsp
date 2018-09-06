<%@ page import="VO.User" %>
<%@ page import="java.util.List" %>
<%@ page import="VO.Blog" %>
<%@ page import="Factory.DAOFactory" %>
<%@ page import="VO.Coment" %><%--
  Created by IntelliJ IDEA.
  User: 32842
  Date: 2018/5/6
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    User user_info=(User)session.getAttribute("user_info");//用户信息
    List<Blog> list=DAOFactory.getImplBlogDAOInstance().getByUserId(user_info.getUserid());//用户博客
    List<Coment> coments=DAOFactory.getImplComentDAOInstance().getByUserId(user_info.getUserid());//用户评论
    for(int i=1,j=0;i<coments.size();i++){//去重
        for(j=0;j<i;j++){
            if(coments.get(i).getBlogid()==coments.get(j).getBlogid()){
                coments.remove(i);
                break;
            }
        }
        if(j<i)i--;
    }

    StringBuilder sb_info=new StringBuilder();//用户资料
    sb_info.append("<h4>姓名：</h4><small>"+user_info.getName()+"</small>");
    sb_info.append("<h4>性别：</h4><small>"+user_info.getSex()+"</small>");
    sb_info.append("<h4>年龄：</h4><small>"+user_info.getAge()+"</small>");
    sb_info.append("<h4>手机：</h4><small>"+user_info.getTel()+"</small>");
    sb_info.append("<h4>博客数：</h4><small>"+list.size()+"</small><br><hr>");

    StringBuilder sb_myblog =new StringBuilder();//用户博客
    for(Blog blog:list){
        sb_myblog.append("<div class=\\\"panel panel-default\\\"><div class=\\\"panel-body col-xs-offset-1\\\">");
        sb_myblog.append("<h4>"+user_info.getName()+"&nbsp;&nbsp;&nbsp;"+"<small>"+blog.getBlogdate()+"</small></h4>");
        sb_myblog.append("<a href=\\\"blog?action=info&&blogid="+blog.getBlogid()+"\\\"><h5>"+blog.getTitle()+"</h5></a>");
        sb_myblog.append("<p style=\\\"width: 100%;height: auto;word-wrap:break-word;word-break:break-all;overflow: hidden; \\\">"+blog.getContent()+"</p>");
        sb_myblog.append("</div><br></div>");
        sb_myblog.append("<hr>");
    }
    StringBuilder sb_coment =new StringBuilder();//用户评论
    for(Coment coment:coments){
        Blog blog=DAOFactory.getImplBlogDAOInstance().getByBlogId(coment.getBlogid());
        User author=DAOFactory.getImplUserDAOInstance().getById(blog.getUserid());
        sb_coment.append("<div class=\\\"panel panel-default\\\"><div class=\\\"panel-body col-xs-offset-1\\\">");
        sb_coment.append("<h4>"+author.getName()+"&nbsp;&nbsp;&nbsp;"+"<small>"+blog.getBlogdate()+"</small></h4>");
        sb_coment.append("<a href=\\\"blog?action=info&&blogid="+blog.getBlogid()+"\\\"><h5>"+blog.getTitle()+"</h5></a>");
        sb_coment.append("<p style=\\\"width: 100%;height: auto;word-wrap:break-word;word-break:break-all;overflow: hidden; \\\">"+blog.getContent()+"</p>");
        sb_coment.append("</div><br></div>");
        sb_coment.append("<hr>");
    }
%>
<head>
    <script src="./lib/jquery-3.3.1.min.js"></script>
    <script src="./lib/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <link href="./lib/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <title><%=user_info.getName()%>的信息</title>
</head>
<script>
    $(document).ready(function () {
        $("#show").html("<%=sb_myblog%>");
        $("#info").click(function () {
            $("#show").html("<%=sb_info%>");
        });

        $("#blog").click(function () {
            $("#show").html("<%=sb_myblog%>");
        });

        $("#coment").click(function () {
            $("#show").html("<%=sb_coment%>");
        });

    });
</script>
<body>
<!--导航栏-->
<nav class="navbar navbar-vertical-left" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#example-navbar-collapse">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand">web作业啊。。。</a>
        </div>
        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a id="info">他的信息</a> </li>
                <li><a id="blog">他的博客</a> </li>
                <li><a id="coment">他参与的评论</a> </li>
                <li><a id="logout" href="./login?action=out" class="navbar-right">注销</a> </li>
            </ul>
        </div>
    </div>
</nav>
<br>
<!--展示-->
<div class="container">
    <div class="row">
        <div class="col-xs-6 col-xs-offset-3" id="show">

        </div>
    </div>
</div>
</body>
</html>
