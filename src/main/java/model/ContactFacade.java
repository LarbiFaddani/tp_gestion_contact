package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactFacade {
    private final String url = "jdbc:postgresql://localhost:5432/Projet_Contact";
    private final String user = "postgres";
    private final String password = "Isl@m[is#1";

    // Connexion à la base de données avec chargement explicite du driver
    private Connection connect() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver"); // Chargement du driver
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur : le driver PostgreSQL JDBC est introuvable !");
            e.printStackTrace();
        }
        return DriverManager.getConnection(url, user, password);
    }

    // Récupérer tous les contacts
    public List<Contact> findAll() {
        List<Contact> contacts = new ArrayList<>();
        String sql = "SELECT * FROM Contact";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Contact c = new Contact(
                    rs.getInt("ID_CONTACT"),
                    rs.getString("FIRSTNAME"),
                    rs.getString("LASTNAME"),
                    rs.getString("EMAIL"),
                    rs.getString("PHONE"),
                    rs.getString("ADDRESS")
                );
                contacts.add(c);
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des contacts :");
            e.printStackTrace();
        }
        return contacts;
    }

    // Ajouter un nouveau contact
    public void createContact(String firstname, String lastname, String email, String phone, String address) {
        String sql = "INSERT INTO contact (firstname, lastname, email, phone, address) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, firstname);
            stmt.setString(2, lastname);
            stmt.setString(3, email);
            stmt.setString(4, phone);
            stmt.setString(5, address);
            int rows = stmt.executeUpdate();
            System.out.println("Nombre de lignes insérées : " + rows);

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du contact :");
            e.printStackTrace();
        }
    }

    public Contact findById(int contactId) {
        String query = "SELECT * FROM Contact WHERE ID_CONTACT = ?";
        
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            
            preparedStatement.setInt(1, contactId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Contact(
                        resultSet.getInt("ID_CONTACT"),
                        resultSet.getString("FIRSTNAME"),
                        resultSet.getString("LASTNAME"),
                        resultSet.getString("EMAIL"),
                        resultSet.getString("PHONE"),
                        resultSet.getString("ADDRESS")
                    );
                } else {
                    System.out.println("Aucun contact trouvé avec l'ID : " + contactId);
                }
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche du contact avec ID : " + contactId);
            e.printStackTrace();
        }

        return null;
    }


    public void updateContact(Contact contact) {
        String sql = "UPDATE Contact SET firstname=?, lastname=?, email=?, phone=?, address=? WHERE ID_CONTACT=?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, contact.getFirstname());
            stmt.setString(2, contact.getLastname());
            stmt.setString(3, contact.getEmail());
            stmt.setString(4, contact.getPhone());
            stmt.setString(5, contact.getAddress());
            stmt.setInt(6, contact.getIdContact());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Supprimer un contact par son ID
    public void deleteContact(String id) {
        String sql = "DELETE FROM Contact WHERE ID_CONTACT = ?";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, Integer.parseInt(id));
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression du contact :");
            e.printStackTrace();
        }
    }
}
