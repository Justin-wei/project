<%--
  admin.User: Justin
  Date: 14-3-24
  Time: 下午2:39
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head></head>
<body>
<h1>ProjectTest</h1>
.
<s:form action="login" namespace="/project" method="POST">
    <s:textfield name="projectManager.userName" label="Username"/>
    <s:password name="projectManager.passWard" label="Password"/>
    <s:submit/>
</s:form>

</body>
</html>