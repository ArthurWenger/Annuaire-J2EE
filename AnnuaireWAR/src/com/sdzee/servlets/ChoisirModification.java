package com.sdzee.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.beans.Contact;
import com.sdzee.xml.XMLBuilder;

/**
 * Servlet implementation class SupprimerContact
 */
@WebServlet( "/choisirModification" )
public class ChoisirModification extends HttpServlet {
    private static final long  serialVersionUID  = 1L;

    public static final String ATT_ERROR         = "errorMessage";
    public static final String ATT_SESSION_INDEX = "indexModify";
    public static final String ATT_OLDCONTACT    = "oldContact";
    public static final String VUE_ERROR         = "/WEB-INF/errorMessage.jsp";
    public static final String VUE_POST          = "/WEB-INF/choisirModification.jsp";

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        request.setAttribute( ATT_ERROR, "Veuillez passer par l'interface de recherche pour modifier un contact." );
        request.getRequestDispatcher( VUE_ERROR ).forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        // on vérifie que la méthode post retourne bien un parametre entier

        try {
            Integer index = Integer.parseInt( request.getParameter( "modify" ) );

            HttpSession session = request.getSession();
            session.setAttribute( ATT_SESSION_INDEX, index );

            ServletContext context = getServletContext();
            XMLBuilder annuaire = (XMLBuilder) context.getAttribute( "annuaire" );
            Contact oldContact = annuaire.getContact( index );
            request.setAttribute( ATT_OLDCONTACT, oldContact );
            request.getRequestDispatcher( VUE_POST ).forward( request, response );
        } catch ( Exception e ) {
            request.setAttribute( ATT_ERROR, e.getMessage() );
            request.getRequestDispatcher( VUE_ERROR ).forward( request, response );
        }
    }

}
