<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
This is a JSP page.
<%Map<String, Object> data = (Map<String, Object>) request.getAttribute("model"); 
//此处注意通过new Viewable("..",object);request只能通过指定'model'属性获取值
%>

<%out.print(data.get("name"));%>
<%=request.getAttribute("directAttr")%>
</body>
</html>