<%--
  Created by IntelliJ IDEA.
  User: 32842
  Date: 2018/5/6
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="./lib/jquery-3.3.1.min.js"></script>
    <script src="./lib/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <link href="./lib/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <title>找回密码</title>
</head>
<body>
<script>
    $(document).ready(function () {
        $("#find").click(function () {
            var na=document.getElementById("name").value;
            var te=document.getElementById("tel").value;
            $("#ps").load("personInfo?action=findPs",{name:na,tel:te},function (response,status,xhr) {


            });
        });
    });
</script>
    <div class="container">
        <div class="row">
            <div class="col-md-offset-3">
                <h3 class="form-title">找回密码</h3>
                <div class="col-md-9">
                    <div class="group">
                        <span class="glyphicon glyphicon-user"></span>
                        <input class="form-control required" type="text" placeholder="Username" id="name" name="name" autofocus="autofocus" maxlength="20"/>
                    </div>
                    <div class="group">
                        <span class="glyphicon glyphicon-phone"></span>
                        <input class="form-control required" type="tel" placeholder="tel" id="tel" name="tel" maxlength="11"/>
                    </div>
                    <div class="group">
                        <p id="ps"></p>
                    </div>
                    <div class="group col-md-offset-9">
                        <button class="btn btn-success pull-left" id="find">找回</button>
                        <button class="btn btn-success pull-right">重置</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
