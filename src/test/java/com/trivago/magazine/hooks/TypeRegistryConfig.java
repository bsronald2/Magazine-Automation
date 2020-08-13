package com.trivago.magazine.hooks;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.trivago.magazine.entities.ContactForm;
import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;

import java.util.Locale;

import static java.util.Locale.ENGLISH;


/**
 * To configure all the class for which Cucumber can convert DataTable to Java objects.
 */
public class TypeRegistryConfig implements TypeRegistryConfigurer {

    private static ObjectMapper mapper;

    static {
        TypeRegistryConfig.mapper = new ObjectMapper();
    }

    @Override
    public Locale locale() {
        return ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(DataTableType.entry(ContactForm.class));
        // add another ...
    }
}
