<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Supprimer un contact</title>
</head>
<body>
    <h1>Supprimer un contact</h1>
    <form action="ControllerServlet" method="POST">
        <input type="hidden" name="do_this" value="delete" />
        <label for="email">Email du contact à supprimer :</label>
        <input type="email" name="email" required />
        <input type="submit" value="Supprimer" />
    </form>
    <a href="ControllerServlet">Retour à l'accueil</a>
</body>
</html>
