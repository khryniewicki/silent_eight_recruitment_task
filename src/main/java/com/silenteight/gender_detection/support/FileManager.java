package com.silenteight.gender_detection.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Slf4j
public class FileManager {
    private static final String path = "classpath*:/**/static/names/**/";

    public static String read_file(String fileName) {
        StringBuilder result = new StringBuilder();

        try (InputStream is = resource_finder(fileName);
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
             String line;
            while ((line = br.readLine()) != null) {
                log.info(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }


    public static InputStream resource_finder(String fileName) throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = new Resource[0];
        try {
            resources = resolver.getResources(path + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resources[0].getInputStream();
    }
}
