package com.silenteight.gender_detection.services;

import com.silenteight.gender_detection.api.response.AvailableTokensResponse;
import com.silenteight.gender_detection.api.response.Gender;
import com.silenteight.gender_detection.api.response.GenderDetectionResponse;
import com.silenteight.gender_detection.support.FileManager;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TokensService implements ITokensService {

    @Override
    public AvailableTokensResponse prepare_set_with_tokens() {
        Set<String> females = FileManager.get_set_with_tokens_from_file_with_female_names();
        Set<String> males = FileManager.get_set_with_tokens_from_file_with_male_names();
        return new AvailableTokensResponse(males, females);
    }

    @Override
    public GenderDetectionResponse detect_gender(String name) {
        String[] tokens = name.split(" ");
        return new GenderDetectionResponse(first_token(tokens[0]), all_tokens(tokens));
    }

    protected String first_token(String name) {
        return verify_token(name).getName();
    }

    protected String all_tokens(String[] tokens) {
        return verify_tokens(tokens).getName();
    }

    protected Gender verify_tokens(String[] tokens) {
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


    protected Gender verify_token(String name) {
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
