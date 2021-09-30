package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Controller - 정적페이지 - 템플릿 순의 우선순위기 때문에 index.html이 무시됨
    @GetMapping("/")
    public String home() {
        return "home";
    }


}
