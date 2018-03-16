package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import spittr.web.HomeController;

@Controller
@RequestMapping({"/","/homepage"})
public class HomeController {
 
	 @RequestMapping(value="/",method=GET)
	 public String home(){
		 
		 return "home";
	 }
}
