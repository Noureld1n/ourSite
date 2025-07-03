package com.smart.ourSite.dto.request;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForgotPasswordRequestDTO {
    private String email;
}
