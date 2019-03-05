package com.resources;

import java.util.ListResourceBundle;

public class Example_fr extends ListResourceBundle {
    public Object[][] getContents() {
        return contents;
    }

    static final Object[][] contents = {
            { "nombre.premier", "nombre premier" },
            { "page.bienvenue", "Bienvenue" },
            { "page.titre", "Exemple d'internationalisation avec JSTL" },
    };
}