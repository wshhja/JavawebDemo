<%@ page import="VO.Blog" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="VO.Coment" %>
<%@ page import="java.util.List" %>
<%@ page import="Factory.DAOFactory" %>
<%@ page import="VO.User" %><%--
  Created by IntelliJ IDEA.
  User: 32842
  Date: 2018/5/4
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        Blog blog=(Blog)session.getAttribute("blog_info");
        List<Coment> coments=(List<Coment>)session.getAttribute("coments");
        session.removeAttribute("coments");
    %>
    <script src="./lib/jquery-3.3.1.min.js"></script>
    <script src="./lib/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <link href="./lib/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <title><%%></title>
</head>
<body style="background-color: #F0FFFF">
<h3 align="center">Blog详情</h3>
<div class="container">
    <div class="row">
        <div class="col-xs-6 col-lg-offset-3" style="background-color:#E0EEE0">
            <br>
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title"><%=DAOFactory.getImplUserDAOInstance().getById(blog.getUserid()).getName()%>&nbsp;<%=blog.getTitle()%></h3>
                </div>
                <div class="panel-body">
                    <h5><%=blog.getBlogdate()%></h5>
                    <p><%=blog.getContent()%></p>
                </div>
            </div><hr>
            <%
                User user=(User)session.getAttribute("user");
                for(Coment coment:coments){
                    out.println("<div class=\"panel panel-default\">");
                    out.println("<div class=\"panel-body\">");
                    out.print("<p>"+DAOFactory.getImplUserDAOInstance().getById(coment.getUserid()).getName());
                    out.println(":&nbsp;"+coment.getComentdate()+"&nbsp;&nbsp;&nbsp;"+coment.getComent()+"</p>");
                    if(coment.getUserid()==user.getUserid()){
                        out.println("<a href=\"coment?action=delete&comentid="+coment.getComentid()+"\">删除</a>");
                    }
                    out.println("</div></div><hr>");
                }
            %>
            <br>

            <form role="form" action="./coment?action=new" method="post">
                <div class="form-group">
                    <label for="newComent">请输入内容：</label>
                    <textarea class="form-control" id="newComent" name="newComent" placeholder="请输入您的评论" rows="5"></textarea>
                </div>
                <button type="submit" class="btn btn-default">提交</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
