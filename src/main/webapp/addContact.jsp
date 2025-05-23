<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Ajouter un contact</title>
</head>
<body>
    <h1>Ajouter un nouveau contact</h1>
    <form action="ControllerServlet" method="POST">
  		<input type="hidden" name="do_this" value="create">
        <table>
            <tr><td>Prénom:</td><td><input type="text" name="firstName" required /></td></tr>
            <tr><td>Nom:</td><td><input type="text" name="lastName" required /></td></tr>
            <tr><td>Email:</td><td><input type="email" name="email" /></td></tr>
            <tr><td>Téléphone:</td><td><input type="text" name="phone" /></td></tr>
            <tr><td>Adresse:</td><td><input type="text" name="address" /></td></tr>
            <tr><td colspan="2"><input type="submit" value="Ajouter" /></td></tr>
        </table>
    </form>
    <a href="ControllerServlet">Retour à l'accueil</a>
</body>
</html>
