package com.example.new_9vs.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateContactResponse {
    private boolean successful;
    private String id;
}
