package com.sdzee.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.xml.XMLBuilder;

/**
 * Servlet implementation class Accueil
 */

public class Accueil extends HttpServlet {
    private static final long  serialVersionUID = 1L;

    public static final String ATT_ANNUAIRE     = "annuaire";
    public static final String VUE              = "/index.jsp";

    public void init() {

        ServletContext context = getServletContext();
        String xmlPath = context.getRealPath( "WEB-INF/Annuaire.xml" );
        // System.out.println( xmlPath );
        XMLBuilder annuaire = new XMLBuilder( xmlPath );
        context.setAttribute( ATT_ANNUAIRE, annuaire );
    }

    public void destroy() {

        ServletContext context = getServletContext();
        XMLBuilder annuaire = (XMLBuilder) context.getAttribute( "annuaire" );
        annuaire.enregistreFichier();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        request.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}
