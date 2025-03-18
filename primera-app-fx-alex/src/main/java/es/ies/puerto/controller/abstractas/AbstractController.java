package es.ies.puerto.controller.abstractas;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class AbstractController {

        public Properties loadIdioma(String nombreFichero, String idioma) {
        Properties properties = new Properties();
        if(nombreFichero == null || idioma.isEmpty()) return properties;
        String path = nombreFichero + "-" + idioma + ".propertires";
        File file = new File(path);
        if(!file.exists() || !file.isFile()) return properties;
        try (FileInputStream input = new FileInputStream(path)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}