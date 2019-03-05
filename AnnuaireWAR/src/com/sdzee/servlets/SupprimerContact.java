package com.sdzee.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.xml.XMLBuilder;

/**
 * Servlet implementation class SupprimerContact
 */
@WebServlet( "/supprimerContact" )
public class SupprimerContact extends HttpServlet {
    private static final long  serialVersionUID = 1L;

    public static final String ATT_ERROR        = "errorMessage";
    public static final String ATT_SUCCES       = "succes";
    public static final String VUE_ERROR        = "/WEB-INF/errorMessage.jsp";
    public static final String VUE_POST         = "/afficherContacts";

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        request.setAttribute( ATT_ERROR, "Veuillez passer par l'interface de recherche pour supprimer un contact." );
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
            Integer index = Integer.parseInt( request.getParameter( "delete" ) );
            ServletContext context = getServletContext();
            XMLBuilder annuaire = (XMLBuilder) context.getAttribute( "annuaire" );
            annuaire.supprContact( index );

            request.setAttribute( ATT_SUCCES, "Contact supprimé avec succès!" );
            request.getServletContext().getRequestDispatcher( VUE_POST ).forward( request, response );
        } catch ( Exception e ) {
            request.setAttribute( ATT_ERROR, e.getMessage() );
            request.getRequestDispatcher( VUE_ERROR ).forward( request, response );
        }
    }

}
