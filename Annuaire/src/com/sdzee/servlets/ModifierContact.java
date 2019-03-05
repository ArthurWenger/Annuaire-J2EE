package com.sdzee.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.beans.Contact;
import com.sdzee.forms.InscriptionForm;

/**
 * Servlet implementation class SupprimerContact
 */
@WebServlet( "/modifierContact" )
public class ModifierContact extends HttpServlet {
    private static final long  serialVersionUID = 1L;

    public static final String ATT_CONTACT      = "contact";
    public static final String ATT_FORM         = "form";
    public static final String VUE_POST         = "/WEB-INF/choisirModification.jsp";
    public static final String VUE_ERROR        = "/WEB-INF/errorMessage.jsp";
    public static final String ATT_ERROR        = "errorMessage";

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
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

        /* Préparation de l'objet formulaire */
        InscriptionForm form = new InscriptionForm();
        /*
         * Appel au traitement et à la validation de la requête, et récupération
         * du bean en résultant
         */
        HttpSession session = request.getSession();
        int index = (int) session.getAttribute( "indexModify" );

        Contact contact = form.modifierContact( request, index );

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_CONTACT, contact );

        request.getServletContext().getRequestDispatcher( VUE_POST ).forward( request, response );
    }

}