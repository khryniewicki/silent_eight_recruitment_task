package com.silenteight.gender_detection.services;

import com.silenteight.gender_detection.api.response.Gender;
import com.silenteight.gender_detection.api.response.TokenResponse;
import com.silenteight.gender_detection.support.FileManager;
import org.springframework.stereotype.Service;

@Service
public class GenderDetectionService {

    public TokenResponse detect_gender(String name) {
        return new TokenResponse(verify_token(name));
    }

    public String verify_token(String name) {
        boolean isFemale = FileManager.detect_token_from_file_with_female_names(name);
        boolean isMale = FileManager.detect_token_from_file_with_male_names(name);

        if (isFemale && isMale) {
            return Gender.INCONCLUSIVE.getName();
        } else if (isFemale) {
            return Gender.FEMALE.getName();
        } else if (isMale) {
            return Gender.MALE.getName();
        } else {
            return Gender.INCONCLUSIVE.getName();
        }
    }
}
