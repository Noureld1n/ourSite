package com.smart.ourSite.dto.response;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamMemberResponseDTO {
    private Long memberId;
    private String memberName;
    private String memberRole;
    private String image;
}
