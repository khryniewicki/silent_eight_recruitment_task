package com.silenteight.gender_detection.support;

import com.silenteight.gender_detection.GenderDetectionApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {GenderDetectionApplication.class})
public class FileManagerTest {

    private static final String female_file = "test_female.txt";
    private static final String male_file = "test_male.txt";


    @Test
    public void should_return_true_when_detect_token_and_token_is_included_in_female_set() {
        String token = "Ada";
        boolean isFound = FileManager.detect_token(female_file, token);
        assertTrue(isFound);
    }

    @Test
    public void should_return_false_when_detect_token_and_token_is_not_included_in_the_female_set() {
        String token = "Barbara";
        boolean isFound = FileManager.detect_token(female_file, token);
        assertFalse(isFound);
    }

    @Test
    public void should_return_true_when_detect_token_and_token_is_included_in_male_set() {
        String token = "Adam";
        boolean isFound = FileManager.detect_token(male_file, token);
        assertTrue(isFound);
    }

    @Test
    public void should_return_false_when_detect_token_and_token_is_not_included_in_the_male_set() {
        String token = "Jerzy";
        boolean isFound = FileManager.detect_token(male_file, token);
        assertFalse(isFound);
    }

    @Test
    public void should_return_set_with_male_tokens_when_get_set_with_tokens() {
        Set<String> set_with_tokens = FileManager.get_set_with_tokens(male_file);
        assertEquals(set_with_tokens.size(), 10);
    }

    @Test
    public void should_return_set_with_female_tokens_when_get_set_with_tokens() {
        Set<String> set_with_tokens = FileManager.get_set_with_tokens(female_file);
        assertEquals(set_with_tokens.size(), 10);
    }
}
