package com.brq.EMotos;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.brq.EMotos.models.CreditCard;
import com.brq.EMotos.models.Rent;
import com.brq.EMotos.services.MotoService;
import com.brq.EMotos.services.RentService;
import com.brq.EMotos.services.UserService;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SuppressWarnings("deprecation")
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class RentTest {

	public static Rent rentCreated;

	@Autowired
	// @InjectMocks
	private RentService rentService;

	@Autowired
	private UserService userService;

	@Autowired
	private MotoService motoService;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	
	@Test //CreateRent
	public void test01() {
		CreditCard creditCardFinded = new CreditCard("testCpfHolder", "testCardHolder", 
			"testCardNumber", "testFlag", 321, "testDueDate");

		Rent rentFilled = new Rent(true, 800, 0, true, true, userService.findUserById(8),
			motoService.findMotoById(3), creditCardFinded);

		rentCreated = rentService.createRent(rentFilled);

		Assertions.assertThat(rentCreated.getId()).isNotNull();
		Assertions.assertThat(rentCreated.getUserRentId().getId()).isEqualTo(8);
		Assertions.assertThat(rentCreated.getMotoRentId().getId()).isEqualTo(3);
		Assertions.assertThat(rentCreated.getCreditCardRentId()
			.getCardNumber()).isEqualTo("testCardNumber");
	}

	@Test //ListRent
	public void test02() {
		Iterable<Rent> rentList = rentService.findAllRent();
		List<Rent> rentListConverted = (List<Rent>) rentList;

		Assertions.assertThat(rentListConverted.size() > 0);
		Assertions.assertThat(rentListConverted.contains(new Rent()));
	}

	@Test //ShowRent
	public void test03() {
		Rent rentFinded = rentService.findRent(rentCreated.getUserRentId().getId());

		Assertions.assertThat(rentFinded.getId()).isEqualTo(rentCreated.getId());
		Assertions.assertThat(rentFinded.getUserRentId().getId())
			.isEqualTo(rentCreated.getUserRentId().getId());
		Assertions.assertThat(rentFinded.getMotoRentId().getId())
			.isEqualTo(rentCreated.getMotoRentId().getId());
		Assertions.assertThat(rentFinded.getProtocol())
			.isEqualTo(rentCreated.getProtocol());
	}

	@Test //ReleaseRent
	public void test04() {
		Rent rentReleased = rentService.releaseRent(rentCreated.getId());

		Assertions.assertThat(rentReleased.isActiveContract()).isEqualTo(false);
	}

	@Test //DeleteRent
	public void test05() {
		String rentDeleted = rentService.deleteRent(rentCreated.getId());

		Assertions.assertThat(rentDeleted.equals("deleted!"));
	}

}
