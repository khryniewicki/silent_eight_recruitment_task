package com.silenteight.gender_detection.api;

import com.silenteight.gender_detection.api.error_handling.Error;
import com.silenteight.gender_detection.api.request.TokensRequest;
import com.silenteight.gender_detection.api.response.AvailableTokensResponse;
import com.silenteight.gender_detection.api.response.Gender;
import com.silenteight.gender_detection.api.response.GenderDetectionResponse;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TokensApiTest extends TokensApiTestSetup {

    public static final String URI_AVAILABLE_TOKENS = "/api/available-tokens";
    public static final String URI_GENDER_DETECTION = "/api/gender-detection";

    @LocalServerPort
    int port;

    @BeforeEach
    void setUp() {
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.port = port;
    }

    @Test
    public void should_return_available_tokens_response_when_get_available_tokens() {
        Awaitility.await().atMost(5, TimeUnit.SECONDS).until(() -> status(URI_AVAILABLE_TOKENS) == 200);

        AvailableTokensResponse availableTokensResponse = response_get(URI_AVAILABLE_TOKENS, HttpStatus.OK).as(AvailableTokensResponse.class);
        Set<String> females = availableTokensResponse.getFemales();
        Set<String> males = availableTokensResponse.getMales();

        Assertions.assertEquals(621, females.size());
        Assertions.assertEquals(575, males.size());
    }

    @Test
    public void should_return_gender_detection_response_when_detect_gender() {
        tokensRequest = jan_kornel_waclaw();

        Awaitility.await().atMost(5, TimeUnit.SECONDS).until(() -> status_post(tokensRequest, URI_GENDER_DETECTION) == 200);
        GenderDetectionResponse genderDetectionResponse = response_post(tokensRequest, URI_GENDER_DETECTION, HttpStatus.OK).as(GenderDetectionResponse.class);

        Assertions.assertEquals(genderDetectionResponse.getFirstToken(), Gender.MALE.getName());
        Assertions.assertEquals(genderDetectionResponse.getAllTokens(), Gender.MALE.getName());
    }

    @Test
    public void should_return_error_when_detect_gender_with_empty_body() {
        tokensRequest = new TokensRequest();

        Awaitility.await().atMost(5, TimeUnit.SECONDS).until(() -> status_post(tokensRequest, URI_GENDER_DETECTION) == 400);
        Error error = response_post(tokensRequest, URI_GENDER_DETECTION, HttpStatus.BAD_REQUEST).as(Error.class);

        Assertions.assertEquals(error.getStatus(), 400);
        Assertions.assertEquals(error.getMessage().get(0), "Name must not be empty");
    }
}
