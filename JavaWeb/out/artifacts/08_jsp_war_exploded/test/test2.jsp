<%@ page import="java.util.List" %>
<%@ page import="com.shi.pojo.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 千文sea
  Date: 2020/4/21
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border: 1px blue solid;
            width: 600px;
            border-collapse: collapse;
        }
        td,th{
            border: 1px blue solid;
        }
    </style>
</head>
<body>
<%--练习二：jsp 输出一个表格，里面有 10 个学生信息。--%>
    <%
        List<Student> list = (List<Student>) request.getAttribute("stuList");
    %>
    <table>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>电话</td>
            <td>操作</td>
        </tr>
        <% for (Student s :list) { %>
              <tr>
                  <td><%=s.getId()%></td>
                  <td><%=s.getName()%></td>
                  <td><%=s.getAge()%></td>
                  <td><%=s.getPhone()%></td>
                  <td>删除,修改</td>
              </tr>
           <% } %>
    </table>
</body>
</html>
