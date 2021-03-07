package com.silenteight.gender_detection.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class FileManager {
    private static final String path = "classpath*:/**/static/names/**/";
    private static final String female_file = "female.txt";
    private static final String male_file = "male.txt";

    public static boolean detect_token_from_file_with_female_names(String token) {
        return detect_token(female_file, token);
    }

    public static boolean detect_token_from_file_with_male_names(String token) {
        return detect_token(male_file, token);
    }

    public static boolean detect_token(String fileName, String token) {
        boolean isFound = false;
        try (InputStream input = resource_finder(fileName);
             BufferedReader br = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null && !isFound) {
                if (token.toLowerCase().equals(line.toLowerCase())) {
                    isFound = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isFound;
    }
    public static Set<String> get_set_with_tokens_from_file_with_male_names() {
        return get_set_with_tokens(male_file);
    }
    public static Set<String> get_set_with_tokens_from_file_with_female_names() {
        return get_set_with_tokens(female_file);
    }
    public static Set<String> get_set_with_tokens(String fileName) {
        Set<String> tokens = new HashSet<>();
        try (InputStream input = resource_finder(fileName);
             BufferedReader br = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null ) {
               tokens.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tokens;
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
