<%--
  Created by IntelliJ IDEA.
  User: 32842
  Date: 2018/5/3
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
    <script src="./lib/jquery-3.3.1.min.js"></script>
    <script src="./lib/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <link href="./lib/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">

  <title>登陆</title>

  <link rel="stylesheet" href="./css/style.css">

</head>
<body>
<form role="form" action="./login?action=in" method="post">
    <div class="container">
        <div class="form row">
            <div class="form-horizontal col-md-offset-3" id="login_form">
                <h3 class="form-title">LOGIN</h3>
                <div class="col-md-9">
                    <div class="form-group">
                        <span class="glyphicon glyphicon-user"></span>
                        <input class="form-control required" type="text" placeholder="Username" id="name" name="name" autofocus="autofocus" maxlength="20"/>
                    </div>
                    <div class="form-group">
                        <span class="glyphicon glyphicon-lock"></span>
                        <input class="form-control required" type="password" placeholder="Password" id="ps" name="ps" maxlength="8"/>
                    </div>
                    <div class="form-group">
                        <label class="checkbox">
                            <input type="checkbox" name="remember" value="1"/>记住我
                        </label>
                    </div>
                    <div class="form-group col-md-offset-9">
                        <button type="submit" class="btn btn-success pull-left">登录</button>
                        <button type="reset" class="btn btn-success pull-right">重置</button>
                        <br><br>
                        <a class="btn btn-success pull-left" href="./findPs.jsp">找回密码</a>
                        <a class="btn btn-success pull-right" href="./register.jsp">注册</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
