<%--
  Created by IntelliJ IDEA.
  User: 32842
  Date: 2018/5/6
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        #low_right
        {
            position: fixed;
            width: 90px;
            height: 90px;
            background: #eee;
            bottom: 40px;
            right: 20px;
            background-color: #DCFCE9;
            border: 8px double #06F867;
            text-align: center;
            padding: 10px;
            margin: 10px;
        }
    </style>
</head>
<body>
<script type="text/javascript">
    for (var i = 0; i < 100; i++) {
        document.write((i + 1) + "<br />");
    }
</script>
<div id="low_right">
    右下角
</div>
</body>
</html>
