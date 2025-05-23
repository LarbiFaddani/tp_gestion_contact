package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.ContactFacade;
import model.Contact;

import java.io.IOException;
import java.util.List;

public class ControllerServlet extends HttpServlet {
    private ContactFacade contactFacade;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        contactFacade = new ContactFacade(); // Instanciation du modèle
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("do_this");

        if (action == null || action.equals("contacts")) {
            List<Contact> contacts = contactFacade.findAll();
            request.setAttribute("contacts", contacts);
            request.getRequestDispatcher("/accueil.jsp").forward(request, response);
        } 
        else if ("updateForm".equals(action)) {
            String idStr = request.getParameter("idContact");
            if (idStr != null && !idStr.isEmpty()) {
                try {
                    int id = Integer.parseInt(idStr);
                    Contact contact = contactFacade.findById(id);
                    if (contact != null) {
                        request.setAttribute("contact", contact);
                        request.getRequestDispatcher("/updateContact.jsp").forward(request, response);
                    } else {
                        request.setAttribute("errorMessage", "Le contact demandé est introuvable.");
                        request.getRequestDispatcher("/accueil.jsp").forward(request, response);
                    }
                } catch (NumberFormatException e) {
                    request.setAttribute("errorMessage", "Identifiant invalide.");
                    request.getRequestDispatcher("/accueil.jsp").forward(request, response);
                }
            }
        } 
        /*else if ("delete".equals(action)) {
            // Suppression d'un contact
            String idStr = request.getParameter("idContact");
            if (idStr != null && !idStr.isEmpty()) {
                try {
                    int id = Integer.parseInt(idStr);
                    contactFacade.deleteContact(id);
                    response.sendRedirect("ControllerServlet"); // rediriger vers la liste
                } catch (NumberFormatException e) {
                    request.setAttribute("errorMessage", "Identifiant invalide.");
                    request.getRequestDispatcher("/accueil.jsp").forward(request, response);
                }
            }
        } */else {
            // Autres cas
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("do_this");

        if ("create".equals(action)) {
            String firstname = request.getParameter("firstName");
            String lastname = request.getParameter("lastName");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");

            if (firstname != null && lastname != null) {
                contactFacade.createContact(firstname, lastname, email, phone, address);
            }
            response.sendRedirect("ControllerServlet"); // après création, on revient à la liste
        }
            else if ("updateForm".equals(action)) {
                String idStr = request.getParameter("idContact");
                if (idStr != null && !idStr.isEmpty()) {
                    try {
                        int id = Integer.parseInt(idStr);
                        Contact contact = contactFacade.findById(id);
                        if (contact != null) {
                            request.setAttribute("contact", contact);
                            request.getRequestDispatcher("/updateContact.jsp").forward(request, response);
                        } else {
                            request.setAttribute("errorMessage", "Le contact demandé est introuvable.");
                            request.getRequestDispatcher("/accueil.jsp").forward(request, response);
                        }
                    } catch (NumberFormatException e) {
                        request.setAttribute("errorMessage", "Identifiant invalide.");
                        request.getRequestDispatcher("/accueil.jsp").forward(request, response);
                    }
                }
            

                else if ("update".equals(action)) {
                int id = Integer.parseInt(request.getParameter("idContact"));
                String firstname1 = request.getParameter("firstName");
                String lastname1 = request.getParameter("lastName");
                String email1 = request.getParameter("email");
                String phone1 = request.getParameter("phone");
                String address1 = request.getParameter("address");

                contactFacade.updateContact(new Contact(id, firstname1, lastname1, email1, phone1, address1));
                response.sendRedirect("ControllerServlet");
            }


            response.sendRedirect("ControllerServlet");

        } 
    }
}

