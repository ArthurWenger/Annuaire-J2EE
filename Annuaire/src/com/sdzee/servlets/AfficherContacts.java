package com.sdzee.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.beans.Contact;
import com.sdzee.xml.XMLBuilder;

/**
 * Servlet implementation class AfficherContacts
 */
public class AfficherContacts extends HttpServlet {
    private static final long  serialVersionUID = 1L;

    public static final String ATT_LISTCONTACTS = "listeContacts";
    public static final String VUE_GET          = "/WEB-INF/afficherContacts.jsp";

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        ServletContext context = getServletContext();
        XMLBuilder annuaire = (XMLBuilder) context.getAttribute( "annuaire" );
        List<Contact> listeContacts = annuaire.tousLesContact();
        request.setAttribute( ATT_LISTCONTACTS, listeContacts );
        request.getServletContext().getRequestDispatcher( VUE_GET ).forward( request,
                response );
    }

    // Après la suppression d'un contact on utilise la methode post de cette
    // servlet pour rafraichir la page
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        doGet( request, response );
    }

}
