<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Liste des contacts</title>
</head>
<body>
<h2>Liste des contacts</h2>

<c:if test="${empty contacts}">
    <p>Aucun contact trouvé j.</p>
</c:if>

<c:if test="${not empty contacts}">
    <table border="1">
        <tr>
            <th>Prénom</th>
            <th>Nom</th>
            <th>Email</th>
            <th>Téléphone</th>
            <th>Adresse</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="contact" items="${contacts}">
            <tr>
                <td>${contact.getFirstname}</td>
                <td>${contact.lastname}</td>
                <td>${contact.email}</td>
                <td>${contact.phone}</td>
                <td>${contact.address}</td>
                <td>
                    <!-- Lien modifier -->
                    
                    <a href="ControllerServlet?do_this=updateForm&idContact=${contact.idContact}">Modifier</a>
                    
                    |
                    <!-- Lien supprimer -->
                    <a href="ControllerServlet?do_this=delete&idContact=${contact.idContact}" 
                       onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce contact ?');">
                        Supprimer
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<br>
<a href="addContact.jsp">Ajouter un nouveau contact</a>
</body>
</html>
