package idusw.springboot.boradthymleaf.controller;

import idusw.springboot.boradthymleaf.domain.Member;
import idusw.springboot.boradthymleaf.service.MemberService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/members")
public class MemberController {
    // Constructor DI(Dependency Injection)
    // DI - IoC (Inversion of Control : 제어의 역전) 방법 중 하나, DI, DL, ...
    MemberService memberService;
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @GetMapping("/login")
    public String getLoginform() {
        return "/members/login";
    }
    @PostMapping("/login")
    public String postLogin() { // 로그인 처리 -> service -> repository -> service -> controller
        return "redirect:/";
    }
    @GetMapping("/register")
    public String getRegisterform(Model model) { // form 요청 -> view (template engine)
        model.addAttribute("member", Member.builder().build());
        return "/members/register";
    }
    @PostMapping("/register")
    public String postRegister(@ModelAttribute("member") Member member, Model model) { // 등록 처리 -> service -> repository -> service -> controller
        System.out.println("this");
        member.setSeq(1L);
        if(memberService.create(member) > 0)
            return "redirect:/";
        else
            return "/main/error";
    }
    @GetMapping("update")
    public String getUpdateForm() {
        return "/members/update";
    }
    @PutMapping("update")
    public String updateMember() {
        return "redirect:/";
    }
    @DeleteMapping("/delete")
    public String deleteMember() {
        return "redirect:/";
    }
    @GetMapping("/forgot")
    public String getForgotform() { // 분실 비밀번호 처리 요청
        return "/members/forgot-password";
    }
    @PostMapping("/forgot") // create vs update -> @PutMapping, delete -> DeleteMapping
    public String forgotMemberPassword() { // 비밀번호(갱신) -> service -> repository -> service -> controller
        return "redirect:/";
    }
}
