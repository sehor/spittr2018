package spittr.web;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spittr.config.DataConfig;
import spittr.data.SpitterRepository;
import spittr.data.SpittleRepository;
import spittr.data.jopo.Spittle;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DataConfig.class})
public class DataTest {

	@Autowired
	private SpittleRepository spittleRepository;
	@Autowired
	private SpitterRepository spitterRepository;
	
	@Test
	public void test()throws Exception{
		
		System.out.println(spitterRepository.findSpitterByUsername("pzr").getEmail());
		spittleRepository.save(new Spittle("this is the first message!", new Date()));
		for(Spittle spittle:spittleRepository.findSpittles(Long.MAX_VALUE, 20)){
			
			System.out.println(spittle.getMessage());
		}
			
	}
	
	
}
