package su.boot.suweb.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import su.boot.suweb.member.dto.MemberDTO;
import su.boot.suweb.member.service.MemberService;

@Controller
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	// Request to display registration form
	@GetMapping("/member/save")
	public String saveForm() {
		return "save"; // Assuming "save.html" is your registration form template
	}

	// Handling form submission
	@PostMapping("/member/save")
	public String save(@ModelAttribute MemberDTO memberDTO, RedirectAttributes redirectAttributes) {
		// Logging - replace with proper logging framework
		System.out.println("MemberController.save");
		System.out.println("memberDTO = " + memberDTO);

		// Call service to save member
		String saveResult = memberService.save(memberDTO);

		// Add success or error message to redirect attributes
		redirectAttributes.addFlashAttribute("message", saveResult);

		// Redirect to index page
		return "redirect:/index"; // Redirect to your index page after successful save
	}
}