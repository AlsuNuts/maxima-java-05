package org.example;
/*
Создать шаблон страницы с использованием тегов div, p, a, img
Использовать на странице не менее трех классов, подключенных к типу элемента, к id элемента и через явное указание класса
Описать класс DynamicPage с методом createPage(String filename), который будет создавать html-файл по шаблону Freemarker, используя данные из вспомогательного класса.
В качестве такого класса данных использовать класс Cat из модуля 3.

 */

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DynamicPage {
    public void createPage(String filename) throws IOException, TemplateException, IncorrectCatWeightException {
        FileWriter writer = new FileWriter("result.html");
        String resourcesPath = DynamicPage.class.getClassLoader().getResource(filename).getPath();

        Configuration config = new Configuration(Configuration.VERSION_2_3_31);
        config.setDirectoryForTemplateLoading( new File(resourcesPath));
        config.setDefaultEncoding("UTF-8");

        Map root = new HashMap<>();
        root.put("title", "Данные кота");

        Cat cat1 = new Cat("Пушок", 10, true);
        Cat cat2 = new Cat("Кусец", 5, false);
        Cat cat3 = new Cat("Черныщ", 7, true);

        root.put("cat1",  cat1);
        root.put("cat2", cat2);
        root.put("cat3", cat3);

        Template template = config.getTemplate("index.html");
        template.process(root, writer);

        writer.flush();
        writer.close();
    }
}
