<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/novoMedico" var="linkServletNovoMedico" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrando Novo Médico</title>

<style type="text/css">

</style>

</head>
<body>
	<form action="${linkServletNovoMedico}" method='post'>
		<p><label>Nome:</label> <input type='text' name='nomeMedico' size='26' maxlength='40'/></p>
		<p><label>CRM:</label> <input type='text' name='crm' size='27' maxlength='15'/></p>
		<p>
			Data Nascimento: <input type='text' name='dataNascMedico' size='5' maxlength='10'/>
			<input type='submit' value='Cadastrar'/>
		</p>
	</form>
</body>
</html>