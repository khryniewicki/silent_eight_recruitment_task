package com.silenteight.gender_detection.api.response;

import lombok.Getter;

@Getter
public enum Gender {
    MALE("MALE"), FEMALE("FEMALE"), INCONCLUSIVE("INCONCLUSIVE");

    private String name;

    Gender(String name) {
        this.name = name;
    }
}
