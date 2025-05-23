<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Rechercher un contact</title>
</head>
<body>
    <h1>Rechercher un contact</h1>
    <form action="ControllerServlet" method="GET">
        <input type="hidden" name="do_this" value="search" />
        <label>Mot-clé (nom ou email) :</label>
        <input type="text" name="keyword" required />
        <input type="submit" value="Rechercher" />
    </form>
    <a href="ControllerServlet">Retour à l'accueil</a>
</body>
</html>
