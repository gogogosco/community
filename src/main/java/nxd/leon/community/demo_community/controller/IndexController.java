package nxd.leon.community.demo_community.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Leon
 * @date
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
