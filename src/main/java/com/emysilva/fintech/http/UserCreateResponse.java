package com.emysilva.fintech.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserCreateResponse {
    private String email;
    private String name;
    private String phoneNumber;
    private String userName;
}
