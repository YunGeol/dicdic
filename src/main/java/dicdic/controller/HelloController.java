package dicdic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Map;

@Controller
public class HelloController {

    Logger log = LoggerFactory.getLogger(this.getClass());
    
    
    @RequestMapping("/")
    public String hello (
            Map<String, Object> model
    )
    {
        model.put("message", "Hello World");
        model.put("title", "Hello Home");
        model.put("date", new Date());
        return "home";
    }
    
    
    @RequestMapping("/hello")
    public String hello2 (
            @RequestParam(value="name", required=false, defaultValue="World") String name
            , Model model
    )
    {
        model.addAttribute("name", name);
        log.info("in hello2!!");
        
        return "hellopage";
    }
}