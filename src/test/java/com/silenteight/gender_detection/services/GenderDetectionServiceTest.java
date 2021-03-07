package com.silenteight.gender_detection.services;

import com.silenteight.gender_detection.GenderDetectionApplication;
import com.silenteight.gender_detection.api.response.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {GenderDetectionApplication.class})
public class GenderDetectionServiceTest extends GenderDetectionSetup {

    @Autowired
    private GenderDetectionService genderDetectionService;

    @Test
    public void should_return_male_when_verify_token_with_male_name() {
        name = jan();
        gender = genderDetectionService.verify_token(name);
        Assertions.assertEquals(Gender.MALE, gender);
    }

    @Test
    public void should_return_male_when_verify_token_with_female_name() {
        name = anna();
        gender = genderDetectionService.verify_token(name);
        Assertions.assertEquals(Gender.FEMALE, gender);
    }

    @Test
    public void should_return_inconclusive_when_verify_token_with_wrong_name() {
        name = nemo();
        gender = genderDetectionService.verify_token(name);
        Assertions.assertEquals(Gender.INCONCLUSIVE, gender);
    }

    @Test
    public void should_return_inconclusive_when_verify_token_with_both_male_and_female_name() {
        name = maria();
        gender = genderDetectionService.verify_token(name);
        Assertions.assertEquals(Gender.INCONCLUSIVE, gender);
    }
    @Test
    public void should_return_female_when_verify_token_with_name_consisted_of_more_than_one_token() {
        tokens = prepareTokens(anna_zbigniew_gertuda());
        gender = genderDetectionService.verify_token(tokens[0]);
        Assertions.assertEquals(Gender.FEMALE, gender);
    }
    @Test
    public void should_return_female_when_verify_tokens_with_most_female_names() {
        tokens = prepareTokens(anna_zbigniew_gertuda());
        gender = genderDetectionService.verify_tokens(tokens);
        Assertions.assertEquals(Gender.FEMALE, gender);
    }

    @Test
    public void should_return_inconclusive_when_verify_tokens_with_not_recognized_token() {
        tokens = prepareTokens(jan_marek_rokita());
        gender = genderDetectionService.verify_tokens(tokens);
        Assertions.assertEquals(Gender.INCONCLUSIVE, gender);
    }

    @Test
    public void should_return_inconclusive_when_verify_tokens_with_no_unambiguous_token() {
        tokens = prepareTokens(jan_maria_krzysztof());
        gender = genderDetectionService.verify_tokens(tokens);
        Assertions.assertEquals(Gender.INCONCLUSIVE, gender);
    }

    @Test
    public void should_return_inconclusive_when_verify_tokens_with_no_unambiguous_and_not_recognized_token() {
        tokens = prepareTokens(jan_maria_rokita());
        gender = genderDetectionService.verify_tokens(tokens);
        Assertions.assertEquals(Gender.INCONCLUSIVE, gender);
    }

    @Test
    public void should_return_inconclusive_when_verify_tokens_with_all_female_tokens() {
        tokens = prepareTokens(aneta_grazyna_kamila());
        gender = genderDetectionService.verify_tokens(tokens);
        Assertions.assertEquals(Gender.FEMALE, gender);
    }
    @Test
    public void should_return_inconclusive_when_verify_tokens_with_all_male_tokens() {
        tokens = prepareTokens(konrad_robert_janusz());
        gender = genderDetectionService.verify_tokens(tokens);
        Assertions.assertEquals(Gender.MALE, gender);
    }

}
