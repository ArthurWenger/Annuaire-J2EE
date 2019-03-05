package com.resources;

import java.util.ListResourceBundle;

public class Example extends ListResourceBundle {
    public Object[][] getContents() {
        return contents;
    }

    static final Object[][] contents = {
            { "count.one", "Uno" },
            { "count.two", "Dos" },
            { "count.three", "Tres" },
    };
}