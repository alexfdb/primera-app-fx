package es.ies.puerto.model;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author alexfdb
 * @version 1.0.0
 */
public abstract class JsonUtil {

    private String path;
    private File file;
    private ObjectMapper objectMapper;

    /**
     * Constructor general.
     */
    protected JsonUtil() {
        this.path = "src/main/resources/usuarios.json";
        this.file = new File(path);
        this.objectMapper = new ObjectMapper();
        try {
            if (!file.exists()) {
                boolean fileCreated = file.createNewFile();
                if (!fileCreated) {
                    throw new IOException("Error al crear el archivo: " + path);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Deserializa un json en un Set.
     * 
     * @return retorna el Set resultante.
     */
    protected Set<Usuario> jsonToSet() {
        try {
            return objectMapper.readValue(file, new TypeReference<Set<Usuario>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            return new HashSet<>();
        }
    }

    /**
     * Serializa un Set en un json.
     * 
     * @param set set a serializar.
     * @return retorna true si se serializo.
     */
    protected boolean setToJson(Set<Usuario> set) {
        if (set == null) {
            return false;
        }
        try {
            objectMapper.writeValue(file, set);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}