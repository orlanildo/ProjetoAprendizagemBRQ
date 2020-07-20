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

import com.brq.EMotos.models.Address;
import com.brq.EMotos.models.User;
import com.brq.EMotos.services.UserService;


@FixMethodOrder(MethodSorters.DEFAULT)
@SuppressWarnings("deprecation")
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class UserTest {
	
	public static User userCreated;
	
	@Autowired
    private UserService userService;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	
	@Test //CreateUser
	public void test01() {
		Address addressUser = new Address("testZipCode", "testNeighborhood", 111, "testCity",
				"testState", "testStreet", "testComplement"); 
		
		User userPrenchido = new User("User Test Test", "userTestTest@gmail.com", 
				"12345678", "12345678", "1234", "123456789", "admin", addressUser);
		
        userCreated = userService.createUser(userPrenchido);
        
		Assertions.assertThat(userCreated.getId()).isNotNull();
		Assertions.assertThat(userCreated.getName()).isEqualTo("User Test Test");
		Assertions.assertThat(userCreated.getEmail()).isEqualTo("userTestTest@gmail.com");
	}
		
	@Test //FindAllUser
	public void test02() {
		List<User> listUser = (List<User>) userService.findAllUser();
		
		Assertions.assertThat(listUser.size() > 0);
		Assertions.assertThat(listUser.contains(new User()));
	}
		
	@Test() //FindByIdUser
	public void test03() {
        User userFinded = userService.findUserById(userCreated.getId());
        
        Assertions.assertThat(userFinded.getId()).isEqualTo(userCreated.getId());
		Assertions.assertThat(userFinded.getName()).isEqualTo("User Test Test");
		Assertions.assertThat(userFinded.getEmail()).isEqualTo("userTestTest@gmail.com");
	}
	
	@Test //UpdateUser
    public void test04() {
		User userFinded = userService.findUserById(userCreated.getId());
				
        userFinded.setName("User Test");
        userFinded.setEmail("userTest@gmail.com");
        
        User userUpdated = userService.updateUser(userCreated.getId(), userFinded);
       
        Assertions.assertThat(userUpdated.getId()).isEqualTo(userCreated.getId());
		Assertions.assertThat(userUpdated.getName()).isEqualTo("User Test");
		Assertions.assertThat(userUpdated.getEmail()).isEqualTo("userTest@gmail.com");
    }
	
	
	@Test //DeleteUser
    public void test05() {
        String userDeleted =  userService.deleteUser(userCreated.getId());
       
        Assertions.assertThat(userDeleted.equals("Usuario ID: " + userCreated.getId() + " successfully deleted!"));
    }
    
}
