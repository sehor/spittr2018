package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spittr.data.JdbcSpittleRepository;
import spittr.data.SpittleForm;
import spittr.data.SpittleRepository;
import spittr.data.jopo.Spittle;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Controller
@RequestMapping(value={"/spittles"})
public class SpittleController {
	
	private SpittleRepository spitterRepository;
	@Autowired
	public  SpittleController(SpittleRepository spittleRepository) {
		
		this.spitterRepository=spittleRepository;
		
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String showSpittles(Model model){
		
		model.addAttribute("spittleList", 
				this.spitterRepository.findSpittles(Long.MAX_VALUE, 20));
		return "spittles";
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String saveSpittle(SpittleForm spittleForm,Model model){
		
		
		this.spitterRepository.save(new Spittle(null,
				spittleForm.getMessage(),
				new Date(),
				spittleForm.getLatitude(),
				spittleForm.getLongitude()));
		return "redirect:/spittles";
		
		
	}

}
