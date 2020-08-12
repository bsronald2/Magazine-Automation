package com.trivago.magazine.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class YamlReader {


    private final static Logger LOGGER = LogManager.getLogger(YamlReader.class);

    /**
     * This method load an YAML file as Java Object.
     *
     * @param aClass type of Class
     * @param path of the YAML file
     * @return an Object
     * @throw IllegalArgumentException if the path String is NULL or Empty
     * @throw FileNotFoundException
     */
    public static Object loadYamlFileAsObject(Class<?> aClass, String path) throws FileNotFoundException {

        if (path == null || path.isEmpty()) {
            throw new IllegalArgumentException("File path must not be NULL or empty: ".concat(path));
        }
        // Map Yaml file to Java Object
        Yaml yaml = new Yaml(new Constructor(aClass));
        InputStream inputStream = new FileInputStream(new File(path));
        Object object =  yaml.loadAs(inputStream, aClass);
        LOGGER.info("Class Loaded: {}", aClass.toString());

        return object;
    }
}
