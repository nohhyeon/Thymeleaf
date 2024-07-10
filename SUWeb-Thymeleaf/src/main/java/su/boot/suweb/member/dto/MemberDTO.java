package su.boot.suweb.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import su.boot.suweb.member.entity.MemberEntity;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberDTO {
	private Long id;
	private String memberEmail;
	private String memberPassword;
	private String memberName;

	// Static method to convert Entity to DTO
	public static MemberDTO toMemberDTO(MemberEntity memberEntity) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(memberEntity.getId());
		memberDTO.setMemberEmail(memberEntity.getMemberEmail());
		memberDTO.setMemberName(memberEntity.getMemberName());
		memberDTO.setMemberPassword(memberEntity.getMemberPassword());
		return memberDTO;
	}
}