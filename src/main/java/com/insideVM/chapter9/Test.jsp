<%@ page import="java.lang.*" %>
<%@ page import="java.io.*" %>
<%@ page import="com.insideVM.chapter9.*" %>
<%
    InputStream inputStream=new FileInputStream("/opt/TestClass.class");
    byte[] b=new byte[inputStream.available()];
    inputStream.read(b);
    inputStream.close();
    System.out.println(JavaClassExecuter.execute(b));
%>