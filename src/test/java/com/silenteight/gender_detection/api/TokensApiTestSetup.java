package com.silenteight.gender_detection.api;

import com.silenteight.gender_detection.api.request.TokensRequest;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class TokensApiTestSetup {
    protected TokensRequest tokensRequest;

    protected TokensRequest jan_kornel_waclaw(){
        return new TokensRequest("Jan Kornel Wacław");
    }

    protected int status(String s) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(s)
                .then()
                .extract()
                .statusCode();
    }

    protected int status_post(Object object, String uri) {
        return given()
                .contentType(ContentType.JSON)
                .body(object)
                .when()
                .post(uri)
                .then()
                .extract()
                .statusCode();
    }

    protected ResponseBodyExtractionOptions response_get(String s, HttpStatus status) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(s)
                .then()
                .statusCode(status.value())
                .assertThat()
                .extract()
                .body();
    }

    protected ResponseBodyExtractionOptions response_post(Object object, String uri, HttpStatus status) {
        return given()
                .contentType(ContentType.JSON)
                .body(object)
                .when()
                .post(uri)
                .then()
                .statusCode(status.value())
                .assertThat()
                .extract()
                .body();
    }
}
