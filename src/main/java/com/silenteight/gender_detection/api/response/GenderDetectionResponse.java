package com.silenteight.gender_detection.api.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GenderDetectionResponse {
    private String firstToken;
    private String allTokens;

}
