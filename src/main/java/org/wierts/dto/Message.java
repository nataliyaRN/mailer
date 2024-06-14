package org.wierts.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Message {

    private String email;
    private String message;
}
