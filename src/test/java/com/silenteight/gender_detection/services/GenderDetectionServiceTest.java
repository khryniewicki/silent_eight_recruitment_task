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
    public void should_return_male_when_verify_first_token_with_male_name() {
        name = jan();
        gender = genderDetectionService.verify_token(name);
        Assertions.assertEquals(Gender.MALE.getName(), gender);
    }

    @Test
    public void should_return_male_when_verify_first_token_with_female_name() {
        name = anna();
        gender = genderDetectionService.verify_token(name);
        Assertions.assertEquals(Gender.FEMALE.getName(), gender);
    }

    @Test
    public void should_return_male_when_verify_first_token_with_wrong_name() {
        name = nemo();
        gender = genderDetectionService.verify_token(name);
        Assertions.assertEquals(Gender.INCONCLUSIVE.getName(), gender);
    }
}
