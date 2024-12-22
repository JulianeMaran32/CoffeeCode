package br.com.juhmaran.cleancode.formatting;

import org.springframework.core.convert.Property;

import java.util.ArrayList;
import java.util.List;

public class ReporterConfig {

    private String m_className;

    private List<Property> m_properties = new ArrayList<Property>();

    public void addProperty(Property property) {
        m_properties.add(property);
    }

}