package com.silenteight.gender_detection.api.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TokenResponse {
    private String firstToken;
    private String allTokens;

    public TokenResponse(String firstToken) {
        this.firstToken = firstToken;
    }
}
