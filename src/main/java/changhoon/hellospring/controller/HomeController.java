package changhoon.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home()
    {
        return "home";
    }
}
//localhost:8080으로 들어오면 이 Controller가 호출됨
//그 후 home.html이 호출될 것임
