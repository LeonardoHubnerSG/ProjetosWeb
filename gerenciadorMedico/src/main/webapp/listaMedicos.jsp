<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, br.com.sgsistemas.gerenciador.servlet.Medico"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/formNovoMedico.jsp" var="linkServletNovoMedico" />
<c:url value="/filtraMedicos" var="linkServletFiltraMedicos" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listagem de Médicos</title>
<style type="text/css">
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
	<c:if test="${not empty medico}">
		Medico ${medico } cadastrado com sucesso!
	</c:if>
	
	<br/>
	
	
	<fieldset>
		<legend>Filtro</legend>
		<p>
			<form action='${linkServletFiltraMedicos}'>
				Nome: <input type='text' name='nomeMedico'/>
				<input type='submit' value='Buscar'>
			</form>
		</p>
	</fieldset>
	
	<table style='margin:1px'>
		<tr>
			<th colspan='5' style='font-size:25px; text-align:center'>LISTA DE MÉDICOS</th>
		</tr>
		<tr>
			<th>Nome</th>
			<th>Dt. Nascimento</th>
			<th>CRM</th>
			<th colspan='2' style='text-align:center'>Gerenciamento</th>
		</tr>
		<c:forEach items="${medicos}" var="medico">
			<tr>
				<td>${medico.nome}</td>
				<td>${medico.dataNascimento}</td>
				<td>${medico.crm }</td>
				<td style='text-align:center'><a href='/gerenciadorMedico/mostraMedico?id=${medico.id }'>Editar</a></td>
				<td style='text-align:center'><a href='/gerenciadorMedico/removeMedico?id=${medico.id }'>Remover</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<form action="${linkServletNovoMedico}" method='post'>
		<input type='submit' value='Novo Médico'/>
	</form>
	
</body>
</html>