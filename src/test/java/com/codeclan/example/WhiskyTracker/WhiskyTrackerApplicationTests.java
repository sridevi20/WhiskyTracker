package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	WhiskyRepository whiskyRepository ;

	@Autowired
	DistilleryRepository distilleryRepository;

    @Test
	public void findWhiskyByYear(){
		List<Whisky> foundWhisky = whiskyRepository.findWhiskyByYear(2018);
		assertEquals(2018, foundWhisky.get(0).getYear());
	}
	@Test
	public void findDistilleryByRegion(){
    	List<Distillery> foundDistillery = distilleryRepository.findDistilleryByRegion("Lowland");
    	assertEquals("Lowland",foundDistillery.get(0).getRegion() );
	}
	@Test public void findWhiskiesInDistilleryThatHaveSpecificAge(){
    	List<Whisky> result = whiskyRepository.findWhiskiesInDistilleryThatHaveSpecificAge(12);
    	assertEquals(12, result.get(0).getAge());
	}



}
