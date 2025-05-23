<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Modifier un contact</title>
</head>
<body>
<h2>Modifier le contact</h2>

<form action="ControllerServlet" method="post">
    <input type="hidden" name="idContact" value="${contact.idContact}" />

    <label>Prénom :</label>
    <input type="text" name="firstName" value="${contact.firstName}" />

    <label>Nom :</label>
    <input type="text" name="lastName" value="${contact.lastName}" />

    <label>Email :</label>
    <input type="email" name="email" value="${contact.email}" />

    <label>Téléphone :</label>
    <input type="text" name="phone" value="${contact.phone}" />

    <label>Adresse :</label>
    <input type="text" name="address" value="${contact.address}" />

    <button type="submit" name="action" value="update">Mettre à jour</button>
</form>


<br/>
<a href="ControllerServlet">Retour à la liste des contacts</a>
</body>
</html>
