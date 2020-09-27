<%--
  Created by IntelliJ IDEA.
  User: qianwensea
  Date: 2020/9/24
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <h3>传统文件上传方式</h3>
    <form action="user/testFileupload1" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="upload"/><br/>
        <input type="submit" value="上传"/>
    </form>
    <br/>
    <h3>springMVC文件上传方式</h3>
    <form action="user/testFileupload2" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="upload"/><br/>
        <input type="submit" value="上传"/>
    </form>
    <br/>
    <h3>跨服务器文件上传方式</h3>
    <form action="user/testFileupload3" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="upload"/><br/>
        <input type="submit" value="上传"/>
    </form>
</body>
</html>
