package org.example;

import freemarker.template.TemplateException;

import java.io.IOException;


public class App 
{
    public static void main( String[] args ) throws TemplateException, IncorrectCatWeightException, IOException {
        DynamicPage dynamicPage = new DynamicPage();
        dynamicPage.createPage("templates");

    }
}
