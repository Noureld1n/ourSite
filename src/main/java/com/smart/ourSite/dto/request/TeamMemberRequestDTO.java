package com.smart.ourSite.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamMemberRequestDTO {
    private String memberName;
    private String memberRole;
    private String image;
}
