<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="com.shi.pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 千文sea
  Date: 2020/4/22
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            width: 500px;
            border: 1px solid blue;
            border-collapse: collapse;
        }
        th,td{
            border: 1px solid blue;
        }
    </style>
</head>
<body>
<%--1.遍历 1 到 10，输出
    begin 属性设置开始的索引
    end 属性设置结束的索引
    var 属性表示循环的变量(也是当前正在遍历到的数据)
    for (int i = 1; i < 10; i++)
--%>
<table border="1">
    <c:forEach begin="1" end="10" var="i">
    <tr>
        <td> ${i}</td>
    </tr>
    </c:forEach>
    <table/>
    <hr/>
    <%-- 2.遍历 Object 数组
        for (Object item: arr)
            items 表示遍历的数据源（遍历的集合）
            var 表示当前遍历到的数据
    --%>
        <%
         request.setAttribute("arr",new String[]{"123213","453432","08978"});
    %>
    <c:forEach items="${requestScope.arr}" var="a">
        ${a}<br/>
    </c:forEach>
    <hr/>

          <%
                Map<String,Object> map = new HashMap<String, Object>();
                map.put("key1", "value1");
                map.put("key2", "value2");
                map.put("key3", "value3");
//                for ( Map.Entry<String,Object> entry : map.entrySet()) {
//                }
                request.setAttribute("map", map);
        %>
        <c:forEach items="${ requestScope.map }" var="entry">
            <h1>${entry.key} = ${entry.value}</h1>
        </c:forEach>
    <hr/>

        <%--4.遍历 List 集合---list 中存放 Student 类，有属性：编号，用户名，密码，年龄，电话信息--%>
    <%
            List<Student> stu = new ArrayList<>();
            for(int i = 1; i <= 10; i++) {
              stu.add(new Student(i,"username" + i,"password" + i,18 + i,"phone" + i));
            }
            request.setAttribute("stu",stu);
    %>
    <table>
        <tr>
            <th>编号</th>
            <th>用户名</th>
            <th>密码</th>
            <th>年龄</th>
            <th>电话</th>
            <th>步长</th>
        </tr>
        <%--
        items 表示遍历的集合
        var 表示遍历到的数据
        begin 表示遍历的开始索引值
        end 表示结束的索引值
        step 属性表示遍历的步长值
        varStatus 属性表示当前遍历到的数据的状态
        for（int i = 1; i < 10; i+=2）
        --%>
        <c:forEach begin="2" step="2" end="8" varStatus="status" items="${requestScope.stu}" var="stu">
            <tr>
                <td>${stu.id}</td>
                <td>${stu.username}</td>
                <td>${stu.password}</td>
                <td>${stu.age}</td>
                <td>${stu.phone}</td>
                <td>${status.step}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
