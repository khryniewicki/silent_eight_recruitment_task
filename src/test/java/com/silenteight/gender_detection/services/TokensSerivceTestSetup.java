package com.silenteight.gender_detection.services;

import com.silenteight.gender_detection.api.request.TokensRequest;
import com.silenteight.gender_detection.api.response.AvailableTokensResponse;
import com.silenteight.gender_detection.api.response.Gender;
import com.silenteight.gender_detection.api.response.GenderDetectionResponse;

import java.util.Set;

public class TokensSerivceTestSetup {
    protected String name;
    protected String[] tokens;
    protected Gender gender;
    protected AvailableTokensResponse availableTokensResponse;
    protected GenderDetectionResponse genderDetectionResponse;
    protected TokensRequest tokensRequest;
    protected Set<String> females;
    protected Set<String> males;

    protected String jan() {
        return "jan";
    }
    protected String anna() {
        return "anna";
    }
    protected String maria() {
        return "Maria";
    }
    protected String nemo() {
        return "nemo";
    }

    protected String anna_zbigniew_gertuda() {
        return "Anna Zbigniew Gertruda";
    }
    protected String jan_marek_rokita() {
        return "Jan Marek Rokita";
    }
    protected String jan_maria_rokita() { return "Jan Maria Rokita"; }
    protected String bozymir_miroslaw_swietomir() {
        return "Bożimir Miłosław Świętomir";
    }
    protected String jan_maria_krzysztof() {
        return "Jan Maria Krzysztof";
    }
    protected String aneta_grazyna_kamila() {
        return "Aneta Grażyna Kamila";
    }
    protected String konrad_robert_janusz() {
        return "Konrad Robert Janusz";
    }

    protected TokensRequest create_token_request(String name) {
        return new TokensRequest(name);
    }
    protected String[] prepare_tokens(String name) {
        return name.split(" ");
    }

}
