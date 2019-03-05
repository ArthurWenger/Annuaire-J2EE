package com.sdzee.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public final class SearchForm {

    public static final String   CHAMP_CHECKBOX_LIST = "check_list[]";
    private Map<String, Boolean> options;

    public void setOptions( HttpServletRequest request ) {

        String[] checkbox_list = request.getParameterValues( CHAMP_CHECKBOX_LIST );

        options = new HashMap<String, Boolean>();

        if ( checkbox_list != null && checkbox_list.length != 0 ) {

            options.put( "nom", false );
            options.put( "prenom", false );
            options.put( "adresse", false );
            options.put( "mail", false );
            options.put( "tel", false );

            for ( String checkbox : checkbox_list ) {

                switch ( checkbox ) {
                case "nom":
                    options.put( "nom", true );
                    break;
                case "prenom":
                    options.put( "prenom", true );
                    break;
                case "adresse":
                    options.put( "adresse", true );
                    break;
                case "mail":
                    options.put( "mail", true );
                    break;
                case "tel":
                    options.put( "tel", true );
                    break;
                default:
                    break;
                }

            }
        } else {
            options.put( "nom", true );
            options.put( "prenom", true );
            options.put( "adresse", true );
            options.put( "mail", true );
            options.put( "tel", true );
        }
    }

    public Map<String, Boolean> getOptions() {
        return this.options;
    }

}