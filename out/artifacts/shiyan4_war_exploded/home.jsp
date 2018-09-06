<%@ page import="VO.User" %>
<%@ page import="VO.Blog" %>
<%@ page import="java.util.List" %>
<%@ page import="Factory.DAOFactory" %><%--
  Created by IntelliJ IDEA.
  User: 32842
  Date: 2018/5/3
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    User user=(User)session.getAttribute("user");
    List<Blog> blog_user=(List<Blog>) session.getAttribute("blogs");
    List<Blog> blog_around=(List<Blog>) session.getAttribute("blog_around");

    StringBuilder sb_myblog =new StringBuilder();//用户博客
    for(Blog blog:blog_user){
        sb_myblog.append("<div class=\\\"panel panel-default\\\"><div class=\\\"panel-body col-xs-offset-1\\\">");
        sb_myblog.append("<h4>"+user.getName()+"&nbsp;&nbsp;&nbsp;"+"<small>"+blog.getBlogdate()+"</small></h4>");
        sb_myblog.append("<a href=\\\"blog?action=info&&blogid="+blog.getBlogid()+"\\\"><h5>"+blog.getTitle()+"</h5></a>");
        sb_myblog.append("<p style=\\\"width: 100%;height: auto;word-wrap:break-word;word-break:break-all;overflow: hidden; \\\">"+blog.getContent()+"</p>");
        sb_myblog.append("<p><a class=\\\"btn btn-default\\\" href=\\\"blog?action=delete&&blogid="+blog.getBlogid()+"\\\"><span class=\\\"glyphicon glyphicon-remove\\\"></span>&nbsp;删除</a>&nbsp;&nbsp;&nbsp;");
        sb_myblog.append("<a class=\\\"btn btn-default\\\" href=\\\"blog?action=update&&blogid="+blog.getBlogid()+"\\\"><span class=\\\"glyphicon glyphicon-edit\\\"></span>&nbsp;编辑</a></p></div><br></div>");
        sb_myblog.append("<hr>");
    }

    StringBuilder sb_blog_around =new StringBuilder();//广场博客
    for(Blog blog:blog_around){
        String name=DAOFactory.getImplUserDAOInstance().getById(blog.getUserid()).getName();
        sb_blog_around.append("<div class=\\\"panel panel-default\\\"><div class=\\\"panel-body col-xs-offset-1\\\">");
        sb_blog_around.append("<a href=\\\"personInfo?action=info&&userid="+blog.getUserid()+"\\\">");
        sb_blog_around.append("<h4>"+name+"&nbsp;&nbsp;&nbsp;"+"<small>"+blog.getBlogdate()+"</small></h4></a>");
        sb_blog_around.append("<a href=\\\"blog?action=info&&blogid="+blog.getBlogid()+"\\\"><h5>"+blog.getTitle()+"</h5></a>");
        sb_blog_around.append("<p style=\\\"width: 100%;height: auto;word-wrap:break-word;word-break:break-all;overflow: hidden; \\\" >"+blog.getContent()+"</p><br></div></div>");
        sb_blog_around.append("<hr>");
    }

    StringBuilder sb_info=new StringBuilder();//用户资料
    sb_info.append("<h4>姓名：</h4><small>"+user.getName()+"</small>");
    sb_info.append("<h4>性别：</h4><small>"+user.getSex()+"</small>");
    sb_info.append("<h4>年龄：</h4><small>"+user.getAge()+"</small>");
    sb_info.append("<h4>手机：</h4><small>"+user.getTel()+"</small><br><hr>");

    String update_info="<a class=\\\"btn btn-default\\\" href=\\\"personInfoUpdate.jsp\\\" float:right>修改资料</button>";

    String newBlog="<a class=\\\"btn btn-default\\\" href=\\\"newBlog.jsp\\\" float:right>发表博客</a><br><br><br><br>";
%>
<head>
    <script src="./lib/jquery-3.3.1.min.js"></script>
    <script src="./lib/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <link href="./lib/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <title><%=user.getName()%></title>
</head>
<script>
    $(document).ready(function () {
        $("#operate").show();
        $("#operate").html("<%=newBlog%>");
        $("#content").html("<%=sb_myblog%>");
        $("#my_blog").click(function () {
            $("#operate").show();
            $("#operate").html("<%=newBlog%>");
            $("#content").html("<%=sb_myblog%>");
        });

        $("#around").click(function () {
            $("#operate").hide();
            $("#content").html("<%=sb_blog_around%>");
        });

        $("#my_info").click(function () {
            $("#operate").show();
            $("#operate").html("<%=update_info%>");
            $("#content").html("<%=sb_info%>");
        });

    });
</script>
<body>
<!--导航栏-->
<nav class="navbar navbar-default" role="navigation">
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
                <li><a id="around">广场</a> </li>
                <li><a id="my_blog">我的博客</a> </li>
                <li><a id="my_info">我的资料</a> </li>
                <li><a id="logout" href="./login?action=out" class="navbar-right">注销</a> </li>
            </ul>
        </div>
    </div>
</nav>
<hr class="panel-collapse">
<!--展示部分-->
<div class="container">
    <div class="row">
        <div class="col-xs-3" style="background-color: #FFEFDB;height:500%" >
            <img src="./img/4.jpg" class="img-rounded" width="260" height="300" style="position:fixed;"><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
            <img src="./img/4.jpg" class="img-rounded" width="260" height="300" style="position:fixed;">
        </div>
        <div class="col-xs-6" style="background-color: #E0EEE0">
            <br>
            <div id="content"></div>
            <div id="operate"></div>
        </div>
        <div class="col-xs-3" style="background-color: #FFEFDB;height:500%" >
            <img src="./img/4.jpg" class="img-rounded" width="260" height="300" style="position:fixed;"><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
            <img src="./img/4.jpg" class="img-rounded" width="260" height="300" style="position:fixed;">
        </div>
    </div>
</div>
</body>
</html>
