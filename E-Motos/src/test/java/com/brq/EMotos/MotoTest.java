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

import com.brq.EMotos.models.Moto;
import com.brq.EMotos.services.MotoService;


@SuppressWarnings("deprecation")
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class MotoTest {

	@Autowired
	//@InjectMocks
    private MotoService motoService;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	
	@Test
	void testFindByIdMoto() throws Exception {
        Moto motoFinded = motoService.findMotoById(1);
        
        Assertions.assertThat(motoFinded.getId()).isEqualTo(1);
		Assertions.assertThat(motoFinded.getName()).isEqualTo("biz");
		Assertions.assertThat(motoFinded.getLicensePlate()).isEqualTo("4321sp");
	}

	@Test
	void testFindAllUser() throws Exception {
		List<Moto> listMoto =  (List<Moto>) motoService.findAllMoto();
		
		Assertions.assertThat(listMoto != null);
	}
	
	@Test
	void testCreateUser() throws Exception {
		Moto motoPrenchido = new Moto(100, "Moto Test Name", "testBrand", "testModel",
			"testVersion", 20, "testYears", 1234, "testDescription", 50, "testPhotoMoto", false);
		
		Moto motoCreated = motoService.createMoto(motoPrenchido);
		
		Assertions.assertThat(motoCreated.getId()).isNotNull();
		Assertions.assertThat(motoCreated.getName()).isEqualTo("Moto Test Name");
		Assertions.assertThat(motoCreated.getBrand()).isEqualTo("testBrand");
	}
	
	@Test
    public void testUpdateUser() throws Exception {
		Moto motoPrenchido = new Moto(32, "Moto Test Name", "testBrand", "testModel",
			"testVersion", 20, "testYears", 1234, "testDescription", 50, "testPhotoMoto", false);
        
        Moto motoUpdeted = motoService.updateMoto(32, motoPrenchido);
       
		Assertions.assertThat(motoUpdeted.getId()).isEqualTo(32);
		Assertions.assertThat(motoUpdeted.getName()).isEqualTo("Moto Test Name");
		Assertions.assertThat(motoUpdeted.getBrand()).isEqualTo("testBrand");
    }
	
	@Test
    public void testDeleteMoto() throws Exception {
        String motoDeleted = motoService.deleteMoto(132);
       
        Assertions.assertThat(motoDeleted.equals("deleted"));
    }

}
