package model;

public class Contact {
    private int idContact;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String address;

    // Constructeur
    public Contact(int idContact, String firstname, String lastname, String email, String phone, String address) {
        this.idContact = idContact;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    // Getters
    public int getIdContact() {
        return idContact;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setters (facultatif, selon tes besoins)
    public void setIdContact(int idContact) {
        this.idContact = idContact;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
