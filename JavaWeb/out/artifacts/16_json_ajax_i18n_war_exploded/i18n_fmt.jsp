<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<%--1 使用标签设置 Locale 信息--%>
<fmt:setLocale value="${param.locale}"/>
<%--2 使用标签设置 baseName--%>
<fmt:setBundle basename="i18n"/>

<a href="i18n.jsp?locale=zh_CN">中文</a>|
<a href="i18n.jsp?locale=en_US">english</a>
<center>
    <h1>><fmt:message key="regist" />
    </h1>
    <table>
        <form>
            <tr>
                <td>><fmt:message key="username" />
                </td>
                <td><input name="username" type="text"/></td>
            </tr>
            <tr>
                <td>><fmt:message key="password" />
                </td>
                <td><input type="password"/></td>
            </tr>
            <tr>
                <td>><fmt:message key="sex" />
                </td>
                <td>
                    <input type="radio"/>><fmt:message key="boy" />
                    <input type="radio"/>><fmt:message key="girl" />
                </td>
            </tr>
            <tr>
                <td>><fmt:message key="email" />
                </td>
                <td><input type="text"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="reset" value="><fmt:message key="reset" />"/>&nbsp;&nbsp;
                    <input type="submit" value="><fmt:message key="submit" />"/></td>
            </tr>
        </form>
    </table>
    <br/> <br/> <br/> <br/>
</center>
国际化测试：
<br/> 1、访问页面，通过浏览器设置，请求头信息确定国际化语言。
<br/> 2、通过左上角，手动切换语言
</body>
</html>