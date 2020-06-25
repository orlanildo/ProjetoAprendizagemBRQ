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

import com.brq.EMotos.models.Address;
import com.brq.EMotos.models.User;
import com.brq.EMotos.services.UserService;


@SuppressWarnings("deprecation")
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class UserTest {
	
	@Autowired
    private UserService userService;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	
	@Test
	void testFindByIdUser() {
        User userFinded = userService.findUserById(3);
        
        Assertions.assertThat(userFinded.getId()).isEqualTo(3);
		Assertions.assertThat(userFinded.getName()).isEqualTo("user");
		Assertions.assertThat(userFinded.getEmail()).isEqualTo("user@brq.com");
	}
	
	@Test
	void testFindAllUser() {
		List<User> listUser = (List<User>) userService.findAllUser();
		
		Assertions.assertThat(listUser.size() > 0);
		Assertions.assertThat(listUser.contains(new User()));
	}
	
	@Test
	void testCreateUser() {
		Address addressUser = new Address("testZipCode", "testNeighborhood", 111, "testCity",
				"testState", "testStreet", "testComplement"); 
		
		User userPrenchido = new User(100, "userTestTest", "userTestTest@gmail.com", 
				"12345678", "12345678", "1234", "123456789", "admin", "notRented", addressUser, null);
		
        User userCreated = userService.createUser(userPrenchido);
		
		Assertions.assertThat(userCreated.getId()).isNotNull();
		Assertions.assertThat(userCreated.getName()).isEqualTo("userTestTest");
		Assertions.assertThat(userCreated.getEmail()).isEqualTo("userTestTest@gmail.com");
	}
	
	@Test
    public void testUpdateUser() {
		Address addressUser = new Address("testZipCode", "testNeighborhood", 111, "testCity",
			"testState", "testStreet", "testComplement"); 
		
        User userPrenchido = new User(41 ,"User Updated", "userUpdated@gmail.com", "12345678", "12345678",
        	"1234", "123456789", "admin", "notRented", addressUser, null);
        
        User userUpdated = userService.updateUser(43, userPrenchido);
       
        Assertions.assertThat(userUpdated.getId()).isEqualTo(43);
		Assertions.assertThat(userUpdated.getName()).isEqualTo("User Updated");
		Assertions.assertThat(userUpdated.getEmail()).isEqualTo("userUpdated@gmail.com");
    }
	
	@Test
    public void testDeleteUser() {
        String userDeleted =  userService.deleteUser(78+3);
       
        Assertions.assertThat(userDeleted.equals("deleted"));
    }

}

/*
	@Tested
	private UserController userController;
	
	//@Injectable 
	//private UserController userController;
	
	@Mocked
	private User c;

    @Before
    public void setUp() { setUpMocks(LowerClassMock.class); }

    @After
    public void tearDown() { tearDownMocks(); }
	 
    @Test
    public void testJMockit() {
		
		new Expectations() {{
		}};
		
		new Verifications() {{
		}};
    }
}
*/

/*
package com.brq.EMotos;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import com.brq.EMotos.controllers.UserController;
import com.brq.EMotos.models.User;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Tested;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;


@SpringBootTest
@RunWith(JMockit.class)
public class UserTest {

	@Tested
	private UserController userController;
	
	//@Injectable 
	//private UserController userController;
	
	//@Mocked
	//private UserController c;
	
	
	@Test
	public void createUserTest(@Mocked User user) {
		
		User userPrenchido = new User("userTestTest", "userTestTest@gmail.com", "11/06/2020", 
				"12345678", "12345678", "1234", "123456789", "admin", "notRented");
		
		System.out.println(userPrenchido);
		
		new Expectations() {{
			userController.createUser(userPrenchido);
			result = userPrenchido;
		}};
		
		new Verifications() {{
			userController.showUser(1);
		}};
	}
}
*/