package com.smart.ourSite.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MassageResponseDTO {
    private Long massageId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String organizationName;
    private String orgnizationType;
    private String content;
    private LocalDateTime dateTime;
}
