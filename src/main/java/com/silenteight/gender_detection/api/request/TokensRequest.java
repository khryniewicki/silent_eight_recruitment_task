package com.silenteight.gender_detection.api.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TokensRequest {
    @NotEmpty(message = "Name must not be empty")
    private String name;

    public TokensRequest(@NotEmpty String name) {
        this.name = name;
    }
}
