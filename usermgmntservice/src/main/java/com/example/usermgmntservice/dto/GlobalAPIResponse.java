package com.example.usermgmntservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class GlobalAPIResponse {

    @NotNull
    private Boolean status;

    @NotNull
    private String message;

    private Object data;

}
