package com.sdzee.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.beans.Contact;
import com.sdzee.forms.SearchForm;
import com.sdzee.xml.XMLBuilder;

/**
 * Servlet implementation class ChercherContact
 */
@WebServlet( "/chercherContact" )
public class ChercherContact extends HttpServlet {
    private static final long  serialVersionUID     = 1L;

    public static final String ATT_ERROR            = "errorMessage";
    public static final String ATT_LISTCONTACTS     = "listeContacts";
    public static final String ATT_SESSION_CHECKBOX = "search_options";
    public static final String VUE_ERROR            = "/WEB-INF/errorMessage.jsp";
    public static final String VUE_POST             = "/WEB-INF/afficherContacts.jsp";

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        request.setAttribute( ATT_ERROR, "Veuillez cliquer sur le boutton de recherche pour effectuer une recherche." );
        request.getServletContext().getRequestDispatcher( VUE_ERROR ).forward( request,
                response );
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        String query = request.getParameter( "search" );

        HttpSession session = request.getSession();
        SearchForm searchForm = (SearchForm) session.getAttribute( "searchOptions" );
        if ( searchForm == null ) {
            searchForm = new SearchForm();
            searchForm.setOptions( request );
            session.setAttribute( ATT_SESSION_CHECKBOX, searchForm );
        }

        ServletContext context = getServletContext();
        XMLBuilder annuaire = (XMLBuilder) context.getAttribute( "annuaire" );
        try {
            List<Contact> listeContacts = annuaire.chercherContact( query, searchForm.getOptions() );

            request.setAttribute( ATT_LISTCONTACTS, listeContacts );
            request.getServletContext().getRequestDispatcher( VUE_POST ).forward( request,
                    response );
        } catch ( Exception e ) {
            System.out.println( e.getMessage() );
        }
    }

}
