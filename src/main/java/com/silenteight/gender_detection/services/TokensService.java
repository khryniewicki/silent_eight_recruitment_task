package com.silenteight.gender_detection.services;

import com.silenteight.gender_detection.api.request.TokensRequest;
import com.silenteight.gender_detection.api.response.AvailableTokensResponse;
import com.silenteight.gender_detection.api.response.GenderDetectionResponse;

public interface TokensService {
    AvailableTokensResponse prepare_set_with_tokens();
    GenderDetectionResponse detect_gender(TokensRequest tokensRequest);
}
