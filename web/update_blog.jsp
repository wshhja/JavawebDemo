<%@ page import="VO.User" %>
<%@ page import="VO.Blog" %><%--
  Created by IntelliJ IDEA.
  User: 32842
  Date: 2018/4/26
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        Blog blog=(Blog)session.getAttribute("blog_update");
        String title=blog.getTitle();
        String content=blog.getContent();
    %>
    <script src="./lib/jquery-3.3.1.min.js"></script>
    <script src="./lib/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <link href="./lib/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <title>
        update
    </title>
</head>
<body>
<script>
    $(document).ready(function () {
        $("#title").val("<%=title%>");
        $("#content").val("<%=content%>")
    });
</script>
<form  action="./blog?action=update_submit" method="post">
    <div class="container">
        <div class="form row">
            <div class="form-horizontal col-md-offset-3" id="login_form">
                <h3 class="form-title">Update Blog</h3>
                <div class="col-md-9">
                    <div class="form-group">
                        <label for="title">标题</label>
                        <input class="form-control required" type="text" placeholder="Title" id="title" name="title" autofocus="autofocus" maxlength="20"/>
                    </div>
                    <div class="form-group">
                        <label for="content">内容</label>
                        <textarea name="content" id="content" class="form-control" rows="15" placeholder="content"></textarea>
                    </div>
                    <div class="form-group col-md-offset-9">
                        <input type="submit" class="btn btn-success pull-left" value="更新"/>
                        <input type="reset" class="btn btn-success pull-right" value="重置"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
