<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/alteraMedico" var="linkServletNovoMedico" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterando Médico</title>
</head>
<body>
	<form action="${linkServletNovoMedico}" method='post'>
		<p><label>Nome:</label> <input type='text' name='nomeMedico' size='26' maxlength='40' value='${medico.nome }'/></p>
		<p><label>CRM:</label> <input type='text' name='crm' size='27' maxlength='15' value='${medico.crm }'/></p>
		<p>
			Data Nascimento: <input type='text' name='dataNascMedico' size='5' maxlength='10' value='${medico.dataNascimento }'/>
			<input type="hidden" name="id" value="${medico.id }">
			<input type='submit' value='Salvar'/>
		</p>
	</form>
</body>
</html>