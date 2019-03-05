package com.sdzee.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.sdzee.beans.Contact;
import com.sdzee.xml.XMLBuilder;

public final class InscriptionForm {
    public static final String  CHAMP_NOM     = "nomContact";
    public static final String  CHAMP_PRENOM  = "prenomContact";
    public static final String  CHAMP_ADRESSE = "adresseContact";
    public static final String  CHAMP_TEL     = "telephoneContact";
    public static final String  CHAMP_MAIL    = "emailContact";

    private String              resultat;
    private Map<String, String> erreurs       = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    private void validationNom( String nom ) throws Exception {
        if ( nom == null ) {
            throw new Exception( "Le nom du contact doit être renseigné" );
        } else if ( nom.length() < 3 ) {
            throw new Exception( "Le nom du contact doit contenir au moins 3 caractères." );
        }
    }

    private void validationAdresse( String adresse ) throws Exception {
        if ( adresse == null ) {
            throw new Exception( "L'adresse du contact doit être renseignée" );
        } else if ( adresse.length() < 3 ) {
            throw new Exception( "L'adresse du contact doit contenir au moins 3 caractères." );
        }
    }

    private void validationEmail( String email ) throws Exception {
        if ( email != null ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }

    private void validationTel( String tel ) throws Exception {
        if ( tel != null && !tel.matches( "^[0-9]{10}$" ) ) {
            throw new Exception( "Merci de saisir une numero de telephone a 10 chiffres." );
        }
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }

    private Contact validationChamps( HttpServletRequest request ) {

        String email = getValeurChamp( request, CHAMP_MAIL );
        String nom = getValeurChamp( request, CHAMP_NOM );
        String prenom = getValeurChamp( request, CHAMP_PRENOM );
        String tel = getValeurChamp( request, CHAMP_TEL );
        String adresse = getValeurChamp( request, CHAMP_ADRESSE );

        Contact contact = new Contact();

        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_MAIL, e.getMessage() );
        }
        contact.setMail( email );

        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        contact.setNom( nom );

        try {
            validationAdresse( adresse );
        } catch ( Exception e ) {
            setErreur( CHAMP_ADRESSE, e.getMessage() );
        }
        try {
            validationTel( tel );
        } catch ( Exception e ) {
            setErreur( CHAMP_TEL, e.getMessage() );
        }
        contact.setTel( tel );
        contact.setAdresse( adresse );
        contact.setPrenom( prenom );

        return contact;

    }

    public Contact inscrireContact( HttpServletRequest request ) {

        Contact contact = validationChamps( request );

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription.";
            ServletContext context = request.getServletContext();
            XMLBuilder annuaire = (XMLBuilder) context.getAttribute( "annuaire" );
            annuaire.addContact( contact );
        } else {
            resultat = "Échec de l'inscription.";
        }

        return contact;
    }

    public Contact modifierContact( HttpServletRequest request, int index ) {

        Contact contact = validationChamps( request );

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la modification.";
            ServletContext context = request.getServletContext();
            XMLBuilder annuaire = (XMLBuilder) context.getAttribute( "annuaire" );
            annuaire.modifierContact( contact, index );
        } else {
            resultat = "Échec de la modification.";
        }

        return contact;
    }

}