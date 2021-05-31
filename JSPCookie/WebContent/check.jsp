<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check_Cookie</title>
</head>
<body>
<%
	Cookie ck[] = request.getCookies();
	int flag=0;
	for(int i=0;i<ck.length;i++)
	{
		if(ck[i].getName().equals("jsp_cookie"))
		{
			out.println("Cookie jsp_cokkie checked");
			out.println(ck[i].getName()+" : "+
						ck[i].getValue()+"\n");
			flag=1;
		}
	}
		if(flag==0)
		{
			out.println("jsp_cookie Not Found");
		}	
%>
</body>
</html>