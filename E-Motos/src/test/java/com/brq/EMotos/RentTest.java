package com.brq.EMotos;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.brq.EMotos.models.CreditCard;
import com.brq.EMotos.models.Rent;
import com.brq.EMotos.services.MotoService;
import com.brq.EMotos.services.RentService;
import com.brq.EMotos.services.UserService;


@SuppressWarnings("deprecation")
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class RentTest {

	@Autowired
	//@InjectMocks
    private RentService rentService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MotoService motoService;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	
	@Test
	void testListRent() {
		Iterable<Rent> rentList = rentService.findAllRent();
		List<Rent> rentListConverted = (List<Rent>) rentList;
		
		Assertions.assertThat(rentListConverted.size() > 0);
		Assertions.assertThat(rentListConverted.contains(new Rent()));
	}
	
	@Test
	void testCreateRent() {
		CreditCard creditCardFinded = new CreditCard("testCpfHolder", "testCardHolder",
			"testCardNumber", "testFlag", 321, "testDueDate");
		
		 Rent rentFilled = new Rent(true, 800, 0, true, true, 
			userService.findUserById(3), motoService.findMotoById(1), 
			creditCardFinded, null, null);
		
		 System.out.println("\n==============");
		 System.out.println("rentFilled.getProtocol(): " + rentFilled.getProtocol() + "\n");
		 
		 Rent rentCreated = rentService.createRent(rentFilled);
		 System.out.println("\n==============");
		 System.out.println("rentCreated.getProtocol(): " + rentCreated.getProtocol() + "\n");
		
		//Assertions.assertThat(rentCreated.getId()).isNotNull();
		//Assertions.assertThat(rentCreated.getProtocol()).isEqualTo("1324-sp1235648");
	}

}
