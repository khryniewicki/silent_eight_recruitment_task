package com.silenteight.gender_detection.api.response;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AvailableTokensResponse {
    private Set<String> males;
    private Set<String> females;
}
