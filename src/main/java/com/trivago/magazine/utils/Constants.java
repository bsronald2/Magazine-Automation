package com.trivago.magazine.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public final class Constants {

    /**
     * This Constructor to default.
     */
    private Constants() {
    }

    // Absolute Paths
    public static Path dir = Paths.get("src");
    public static final String UTILS_PATH = dir.toAbsolutePath().toString();

    // Paths
    public static final String ENV_INFO_PATH = UTILS_PATH.concat("/main/resources/envInfo.yaml");

}
