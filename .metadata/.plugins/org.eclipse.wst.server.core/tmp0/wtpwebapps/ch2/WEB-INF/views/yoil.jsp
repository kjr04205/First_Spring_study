<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head></head>
<body>
<h1>year=<%= request.getParameter("year") %></h1>
<h1>month=<%= request.getParameter("month") %></h1>
<h1>day=<%= request.getParameter("day") %></h1>
<h1>${myDate.year}년 ${myDate.month}월 ${myDate.day}일은 ${yoil}요일입니다.</h1>
</body>
</html>