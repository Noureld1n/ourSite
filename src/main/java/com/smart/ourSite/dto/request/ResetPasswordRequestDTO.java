package com.smart.ourSite.dto.request;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResetPasswordRequestDTO {
    private String token;
    private String newPassword;
    private String confirmPassword;
}
