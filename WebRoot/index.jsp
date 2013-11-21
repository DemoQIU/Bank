<%@ page import="itstudio.bank.bean.Appointment"%>
<%@ page import="itstudio.bank.dao.AppointmentDAO"%>
<%@ page import="itstudio.bank.daoimp.AppointmentDAOImp"%>
<%
AppointmentDAOImp appointmentDAOImp= new AppointmentDAOImp();
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
for ( Appointment  appointment:appointmentDAOImp.findAppointmentList(1, 0))
{
	System.out.println( appointment.getId());
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is my JSP page. <br>
    <form action="sample01.jsp" method="post" ENCTYPE="multipart/form-data">
选择要上传的图片：
<input type="file" name="pic">
<input type="submit" value="上传">
</form>
  </body>
</html>
