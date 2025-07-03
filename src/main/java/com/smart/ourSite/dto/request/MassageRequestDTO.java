package com.smart.ourSite.dto.request;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MassageRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String organizationName;
    private String orgnizationType;  // matching your DB spelling
    private String content;
}
