<%--
  Created by IntelliJ IDEA.
  User: qianwensea
  Date: 2020/9/24
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>

    <script>
        //页面加载,绑定单击事件
        $(function (){
            $("#btn").click(function (){
                alert("hello btn");

                //发送ajax请求
                $.ajax({
                    //编写json格式,设置属性和值
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    method:"POST",
                    data:'{"username":"小张","password":"www123","age":99}',
                    dataType:"json",
                    success:function (data){
                        //此data就是服务器响应的json数据,进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                });
            });
        });
    </script>
</head>
<body>
    <a href="user/testString">testString</a>
    <br/>

    <a href="user/testVoid">testVoid</a>
    <br/>

    <a href="user/testModelAndView">testModelAndView</a>
    <br/>

    <a href="user/testForwardOrRedirect">testForwardOrRedirect</a>
    <br/>

    <button id="btn">异步请求</button>

</body>
</html>
