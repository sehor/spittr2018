package spittr.web;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spittr.config.DataConfig;
import spittr.config.WebConfig;
import spittr.data.JdbcSpittleRepository;
import spittr.data.jopo.Spittle;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DataConfig.class,WebConfig.class})
public class SpittleControllerTest {
	
	@Autowired
	private JdbcSpittleRepository spittleRepository;
	
	
	@Test
	public  void test()throws Exception{
		
		for(Spittle spittle:this.spittleRepository.findSpittles(Long.MAX_VALUE, 20)){
			System.out.println(spittle.getMessage());
		}
		
		System.out.println("ffff");
	}
}
