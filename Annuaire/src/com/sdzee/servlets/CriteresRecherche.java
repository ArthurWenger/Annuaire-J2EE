package com.sdzee.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.forms.SearchForm;

/**
 * Servlet implementation class CriteresRecherche
 */
@WebServlet( "/criteresRecherche" )
public class CriteresRecherche extends HttpServlet {
    private static final long  serialVersionUID     = 1L;

    public static final String VUE_GET              = "/WEB-INF/rechercheAvancee.jsp";
    public static final String VUE_POST             = "/WEB-INF/rechercheAvancee.jsp";
    public static final String ATT_SESSION_CHECKBOX = "searchOptions";

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        request.getServletContext().getRequestDispatcher( VUE_GET ).forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        SearchForm searchForm = new SearchForm();
        searchForm.setOptions( request );
        HttpSession session = request.getSession();
        session.setAttribute( ATT_SESSION_CHECKBOX, searchForm );
        request.getServletContext().getRequestDispatcher( VUE_POST ).forward( request, response );

    }

}
