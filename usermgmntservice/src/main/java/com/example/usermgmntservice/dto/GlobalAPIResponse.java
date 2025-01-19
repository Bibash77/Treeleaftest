package com.example.usermgmntservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;


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
