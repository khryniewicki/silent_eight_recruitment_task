package com.silenteight.gender_detection.services;

import com.silenteight.gender_detection.api.response.Gender;

public class GenderDetectionSetup {
    protected String name;
    protected String[] tokens;
    protected Gender gender;

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
    protected String jan_maria_rokita() {
        return "Jan Maria Rokita";
    }
    protected String jan_maria_krzysztof() {
        return "Jan Maria Krzysztof";
    }
    protected String[] prepareTokens(String name) {
        return name.split(" ");
    }

    protected String aneta_grazyna_kamila() {
        return "Aneta Grażyna Kamila";
    }

    protected String konrad_robert_janusz() {
        return "Konrad Robert Janusz";
    }
}
