package idusw.springboot.boradthymleaf.controller;

import idusw.springboot.boradthymleaf.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    MemoService memoService;  // MemoService 인터페이스의 구현체를 필드 주입

    @GetMapping("")
    public String goHome() { return "/main/index"; }
    @GetMapping("/buttons")
    public String goButtons() { return "/main/buttons"; }
    @GetMapping("/cards")
    public String gocards() { return "/main/cards"; }
    @GetMapping("/colors")
    public String goColors() { return "/main/utilities-color"; }
    @GetMapping("/borders")
    public String goBorders() { return "/main/utilities-border"; }
    @GetMapping("/animations")
    public String goAnimations() { return "/main/utilities-animation"; }
    @GetMapping("/others")
    public String goOthers() { return "/main/utilities-other"; }
    @GetMapping("/login")
    public String goLogin() { return "/members/login"; }
}
