<%@ page isErrorPage="true" %>
<html>
<head>
<title>Page g�rant une erreur</title>
</head>
<body bgcolor="white">
La page a retournee une erreur du type:<br/> <%= exception.getMessage() %>
</body>
</html>