<%--
  Created by IntelliJ IDEA.
  User: 32842
  Date: 2018/4/26
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>error</title>
    <script type="text/javascript">
        var time = 4;

        function returnUrlByTime() {

            window.setTimeout('returnUrlByTime()', 1000);

            time = time - 1;

            document.getElementById("layer").innerHTML = time;
        }
    </script>

</head>
<body  onload="returnUrlByTime()">

<h3>请先登陆在进行浏览</h3>
<b><span id="layer">3</span>秒后，转入输入界面。</b>

<%
    //转向语句
    response.setHeader("Refresh", "3;URL=index.jsp");
%>

</body>
</html>