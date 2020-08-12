package com.trivago.magazine.utils;


import java.io.FileNotFoundException;

public class EnvironmentManager {

    private static EnvironmentManager environmentManager = null;
    private String pathEnv;
    private Object envInfo;
    private Class<?> aClass;

    public EnvironmentManager(String path, Class<?> aClass) {
        this.pathEnv = path;
        this.aClass = aClass;
        loadObject();
    }

    private void loadObject() {

        try {
            envInfo =  YamlReader.loadYamlFileAsObject(this.aClass, this.pathEnv);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Object getEnvInfo() {
        return envInfo;
    }
}
