package com.library.libraryServer.resource;

import com.library.libraryServer.domain.enums.*;
import lombok.*;

@Data
public class Errorvm {
    private ApiStatus status;
    private String statusReason;
    private Integer code;//error code

    public Errorvm() {
    }

    public Errorvm(String statusReason, Integer code) {
        this.status=ApiStatus.FAILED;
        this.statusReason = statusReason;
        this.code = code;
    }

    public Errorvm(ApiStatus status, String statusReason, Integer code) {
        this.status = status;
        this.statusReason = statusReason;
        this.code = code;
    }
}
