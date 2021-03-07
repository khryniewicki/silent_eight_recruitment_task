package com.silenteight.gender_detection.services;

import com.silenteight.gender_detection.api.response.Gender;
import com.silenteight.gender_detection.api.response.TokenResponse;
import com.silenteight.gender_detection.support.FileManager;
import org.springframework.stereotype.Service;

@Service
public class GenderDetectionService {

    public TokenResponse detect_gender(String name) {
        String[] tokens = name.split(" ");
        return new TokenResponse(first_token(tokens[0]), all_tokens(tokens));
    }

    public String first_token(String name) {
        return verify_token(name).getName();
    }

    public String all_tokens(String[] tokens) {
        return verify_tokens(tokens).getName();
    }

    public Gender verify_tokens(String[] tokens) {
        int female = 0;
        int male = 0;

        for (String token : tokens) {
            Gender gender = verify_token(token);
            switch (gender) {
                case MALE:
                    male++;
                    break;
                case FEMALE:
                    female++;
                    break;
                default:
                    return Gender.INCONCLUSIVE;
            }
        }

        if (male == female) return Gender.INCONCLUSIVE;
        else return male > female ? Gender.MALE : Gender.FEMALE;
    }


    public Gender verify_token(String name) {
        boolean isFemale = FileManager.detect_token_from_file_with_female_names(name);
        boolean isMale = FileManager.detect_token_from_file_with_male_names(name);

        if (isFemale && isMale) {
            return Gender.INCONCLUSIVE;
        } else if (isFemale) {
            return Gender.FEMALE;
        } else if (isMale) {
            return Gender.MALE;
        } else {
            return Gender.INCONCLUSIVE;
        }
    }
}
