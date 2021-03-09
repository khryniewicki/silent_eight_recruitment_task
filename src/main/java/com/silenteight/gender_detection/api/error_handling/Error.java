package com.silenteight.gender_detection.api.error_handling;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Error {
    private LocalDateTime timeStamp;
    private List<String> message;
    private int status;
}
