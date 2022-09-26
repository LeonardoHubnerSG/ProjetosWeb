
<!-- //isso abaixo é um scriptlet -->
<%
	String nomeEmpresa = (String) request.getAttribute("empresa");
	System.out.println("cheguei");
%>

<html>
<body>
<%-- Nova empresa <% out.println(nomeEmpresa); %> cadastrada com sucesso! --%>
Nova empresa <%= nomeEmpresa %> cadastrada com sucesso!
</body>
</html>