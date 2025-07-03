package com.smart.ourSite.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseDTO {
    private Long adminId;
    private String adminName;
    private String email;
    private String phone;
    private String profilePicture;


}
