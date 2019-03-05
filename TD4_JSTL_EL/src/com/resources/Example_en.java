package com.resources;

import java.util.ListResourceBundle;

public class Example_en extends ListResourceBundle {
    public Object[][] getContents() {
        return contents;
    }

    static final Object[][] contents = {
            { "nombre.premier", "prime number" },
            { "page.bienvenue", "Welcome" },
            { "page.titre", "JSTL Internationalisation example" },
    };
}