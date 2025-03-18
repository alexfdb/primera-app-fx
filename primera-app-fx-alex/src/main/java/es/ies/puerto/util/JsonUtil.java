package es.ies.puerto.util;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.ies.puerto.model.Usuario;
/**
 * @author alexfdb
 * @version 1.0.0
 */
public class JsonUtil {
    
    private String path;
    private File file;
    private ObjectMapper objectMapper;

    /**
     * Constructor general.
     */
    public JsonUtil() {
        this.path = "src/main/resources/usuarios.json";
        this.file = new File(path);
        this.objectMapper = new ObjectMapper();
        try {
            if(!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Deserializa un json en un Set.
     * @return retorna el Set resultante.
     */
    public Set<Usuario> jsonToSet() {
        try {
            return objectMapper.readValue(file, new TypeReference<Set<Usuario>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            return new HashSet<>();
        }
    }

    /**
     * Serializa un Set en un json.
     * @param set set a serializar.
     * @return retorna true si se serializo.
     */
    public boolean setToJson(Set<Usuario> set) {
        try {
            objectMapper.writeValue(file, set);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}