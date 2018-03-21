package spittr.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.UnsupportedEncodingException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import application.servlet.EncodingRequest;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import spittr.data.SpitterRepository;
import spittr.data.jopo.Spitter;

@Controller
@RequestMapping(value = "/spitter")
public class SpitterController {

	private SpitterRepository repository;

	@Autowired
	public SpitterController(SpitterRepository repository) {

		this.repository = repository;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterForm() {

		return "registerForm";
	}

	@RequestMapping(value = "/register", method = POST)
	public String processRegistion(@Valid Spitter spitter, Errors errors) {

		 System.out.println("从客户端来： "+ spitter.getFirstName());
		 
		if (errors.hasErrors()) {
			return "registerForm";
		}

		repository.save(spitter);
		String encodeUserName=spitter.getUsername();
		
		try {
			encodeUserName =URLEncoder.encode(encodeUserName, "UTF-8");
		    
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return "redirect:/spitter/"+encodeUserName;
	}

	
	@RequestMapping(value = "/{username}", method = GET)
	public String showProfile(@PathVariable String username, Model model) {
		
        String decodeUserName=username;
        try {
        	decodeUserName=java.net.URLDecoder.decode(username,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		System.out.println("准备从数据库取出：   "+ decodeUserName);
		Spitter spitter = repository.findSpitterByUsername(decodeUserName);
		model.addAttribute(spitter);
		
		
		
		return "profile";
	}

}
