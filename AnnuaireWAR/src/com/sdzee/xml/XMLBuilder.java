package com.sdzee.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.sdzee.beans.Contact;

public class XMLBuilder {

    static Element  racine;
    static Document document;
    private String  xmlPath;

    public XMLBuilder( String xmlPath ) {

        try {
            this.xmlPath = xmlPath;
            lireFichier();
        } catch ( Exception e ) {
            creerFichier();
            System.out.println( "Lecture IMPOSSIBLE" );
            System.out.println( e.getMessage() );
        }
    }

    // main( String[] args )
    public void creerFichier() {
        racine = new Element( "annuaire" );
        document = new org.jdom2.Document( racine );

        Contact sample = new Contact();
        sample.setNom( "White" );
        sample.setPrenom( "Walter" );
        sample.setAdresse( "36 quai des orfevres" );
        sample.setMail( "ww@gmail.com" );
        sample.setTel( "0606060606" );

        addContact( sample );
    }

    public void addContact( Contact c ) {

        Element contact = new Element( "contact" );
        racine.addContent( contact );

        Element nom = new Element( "nom" );
        nom.setText( c.getNom() );
        contact.addContent( nom );

        Element prenom = new Element( "prenom" );
        prenom.setText( c.getPrenom() );
        contact.addContent( prenom );

        Element tel = new Element( "tel" );
        tel.setText( c.getTel() );
        contact.addContent( tel );

        Element adresse = new Element( "adresse" );
        adresse.setText( c.getAdresse() );
        contact.addContent( adresse );

        Element mail = new Element( "mail" );
        mail.setText( c.getMail() );
        contact.addContent( mail );

    }

    public void affiche() {
        try {
            // On utilise ici un affichage classique avec getPrettyFormat()
            XMLOutputter sortie = new XMLOutputter( Format.getPrettyFormat() );
            sortie.output( document, System.out );
        } catch ( java.io.IOException e ) {
        }
    }

    public void enregistreFichier() {

        try {
            // On utilise ici un affichage classique avec getPrettyFormat()
            XMLOutputter sortie = new XMLOutputter( Format.getPrettyFormat() );
            OutputStreamWriter out = new OutputStreamWriter( new FileOutputStream( this.xmlPath ), "UTF-8" );
            sortie.output( document, out );
            out.close();
        } catch ( java.io.IOException e ) {
        }
    }

    // On parse le fichier et on initialise la racine de
    // notre arborescence
    private void lireFichier() throws Exception {
        SAXBuilder sxb = new SAXBuilder();
        document = sxb.build( new File( this.xmlPath ) );
        racine = document.getRootElement();
    }

    public List<Contact> tousLesContact() {
        List<Element> listXML = racine.getChildren( "contact" );
        List<Contact> listContacts = new ArrayList<Contact>();
        Iterator<Element> i = listXML.iterator();
        while ( i.hasNext() ) {
            Element courant = (Element) i.next();

            Contact contact = new Contact();
            contact.setNom( courant.getChild( "nom" ).getText() );
            contact.setPrenom( courant.getChild( "prenom" ).getText() );
            contact.setTel( courant.getChild( "tel" ).getText() );
            contact.setAdresse( courant.getChild( "adresse" ).getText() );
            contact.setMail( courant.getChild( "mail" ).getText() );

            listContacts.add( contact );
        }
        return listContacts;
    }

    public List<Contact> chercherContact( String search, Map<String, Boolean> options ) {
        List<Element> listXML = racine.getChildren( "contact" );
        List<Contact> listContacts = new ArrayList<Contact>();
        Boolean test;
        Iterator<Element> i = listXML.iterator();

        while ( i.hasNext() ) {
            Element courant = (Element) i.next();

            test = options.get( "nom" ) && subStr( champXML( courant, "nom" ), search );
            test = test || ( options.get( "prenom" ) && subStr( champXML( courant, "prenom" ), search ) );
            test = test || ( options.get( "mail" ) && subStr( champXML( courant, "mail" ), search ) );
            test = test || ( options.get( "adresse" ) && subStr( champXML( courant, "adresse" ), search ) );
            test = test || ( options.get( "tel" ) && subStr( champXML( courant, "tel" ), search ) );

            if ( test ) {

                Contact contact = new Contact();
                contact.setNom( champXML( courant, "nom" ) );
                contact.setPrenom( champXML( courant, "prenom" ) );
                contact.setTel( champXML( courant, "tel" ) );
                contact.setAdresse( champXML( courant, "adresse" ) );
                contact.setMail( champXML( courant, "mail" ) );

                listContacts.add( contact );
            }
        }
        return listContacts;
    }

    private String champXML( Element contact, String champ ) {
        return contact.getChild( champ ).getText();
    }

    public void supprContact( int index ) {

        List<Element> listXML = racine.getChildren( "contact" );
        Element contactXML = listXML.get( index );
        racine.removeContent( contactXML );
    }

    public Contact getContact( int index ) {

        List<Element> listXML = racine.getChildren( "contact" );
        Element contactXML = listXML.get( index );

        Contact contact = new Contact();
        contact.setNom( contactXML.getChild( "nom" ).getText() );
        contact.setPrenom( contactXML.getChild( "prenom" ).getText() );
        contact.setTel( contactXML.getChild( "tel" ).getText() );
        contact.setAdresse( contactXML.getChild( "adresse" ).getText() );
        contact.setMail( contactXML.getChild( "mail" ).getText() );

        return contact;
    }

    public void modifierContact( Contact c, int index ) {

        List<Element> listXML = racine.getChildren( "contact" );
        Element contactXML = listXML.get( index );

        contactXML.getChild( "nom" ).setText( c.getNom() );
        contactXML.getChild( "prenom" ).setText( c.getPrenom() );
        contactXML.getChild( "tel" ).setText( c.getTel() );
        contactXML.getChild( "mail" ).setText( c.getMail() );
        contactXML.getChild( "adresse" ).setText( c.getAdresse() );
    }

    public int chercherIndex( Contact c ) {

        List<Element> listXML = racine.getChildren( "contact" );
        String nom, prenom, tel, mail, adresse;

        for ( int i = 0; i < listXML.size(); i++ ) {
            Element courant = (Element) listXML.get( i );

            nom = courant.getChild( "nom" ).getText();
            prenom = courant.getChild( "prenom" ).getText();
            tel = courant.getChild( "tel" ).getText();
            adresse = courant.getChild( "adresse" ).getText();
            mail = courant.getChild( "mail" ).getText();

            if ( c.getNom().equals( nom ) && c.getPrenom().equals( prenom ) && c.getTel().equals( tel )
                    && c.getMail().equals( mail ) && c.getAdresse().equals( adresse ) ) {
                return i;
            }
        }
        return -1;
    }

    // Methode vérifiant si une chaine de caractères est incluse dans une autre
    private static boolean subStr( String str1, String str2 ) {
        return str1.toLowerCase().contains( str2.toLowerCase() );
    }
}