package su.boot.suweb.member.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import su.boot.suweb.member.dto.MemberDTO;
import su.boot.suweb.member.entity.MemberEntity;
import su.boot.suweb.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

	private final MemberRepository memberRepository;

	@Transactional
	public String save(MemberDTO memberDTO) {
		log.info("Attempting to save member: {}", memberDTO.getMemberEmail());

		if (memberRepository.existsByMemberEmail(memberDTO.getMemberEmail())) {
			log.error("Member with email {} already exists", memberDTO.getMemberEmail());
			return "Member with email " + memberDTO.getMemberEmail() + " already exists";
		}

		MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
		memberRepository.save(memberEntity);
		log.info("Member saved successfully: {}", memberDTO.getMemberEmail());
		return "Member saved successfully";
	}
}