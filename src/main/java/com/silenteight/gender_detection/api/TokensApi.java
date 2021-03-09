package com.silenteight.gender_detection.api;

import com.silenteight.gender_detection.api.request.TokensRequest;
import com.silenteight.gender_detection.api.response.AvailableTokensResponse;
import com.silenteight.gender_detection.api.response.GenderDetectionResponse;
import com.silenteight.gender_detection.services.TokensService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TokensApi {

    private final TokensService tokensService;

    @GetMapping("/api/available-tokens")
    public ResponseEntity<AvailableTokensResponse> get_available_tokens() {
        return ResponseEntity.ok(tokensService.prepare_set_with_tokens());
    }

    @PostMapping("/api/gender-detection")
    public ResponseEntity<?> detect_gender(@RequestBody @Valid TokensRequest tokenRequests) {
        return ResponseEntity.ok(tokensService.detect_gender(tokenRequests));
    }



}
