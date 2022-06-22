package changhoon.hellospring.controller;

import changhoon.hellospring.domain.Member;
import changhoon.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService)
    {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm()
    {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form)
    {
         Member member = new Member();
         member.setName(form.getName());

         memberService.join(member);
         return "redirect:/";   //회원가입이 끝났으므로 홈화면으로 보낸다
    }
}
