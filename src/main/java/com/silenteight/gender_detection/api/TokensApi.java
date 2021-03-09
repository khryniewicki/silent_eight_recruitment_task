package com.silenteight.gender_detection.api;

import com.silenteight.gender_detection.api.request.TokensRequest;
import com.silenteight.gender_detection.api.response.AvailableTokensResponse;
import com.silenteight.gender_detection.services.TokensService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class TokensApi {

    private final TokensService tokensService;

    @GetMapping("/api/available-tokens")
    public ResponseEntity<AvailableTokensResponse> get_available_tokens() {
        return ResponseEntity.ok(tokensService.prepare_set_with_tokens());
    }

    @PostMapping(value = "/api/gender-detection")
    public ResponseEntity<?> detect_gender(@RequestBody @Valid TokensRequest tokenRequests) {
        return ResponseEntity.ok(tokensService.detect_gender(tokenRequests));
    }

}
