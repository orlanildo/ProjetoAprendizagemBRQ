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
	
	public static Moto motoCreated;

	@Autowired
	//@InjectMocks
    private MotoService motoService;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	
	@Test //CreateUser
	void test01() throws Exception {
		
		Moto motoPrenchido = new Moto("Moto Test Name", "testBrand", "testModel",
			"testLicensePlate", 20, "testYears", 1234, "testDescription", 50, "testPhotoMoto");
		
		motoCreated = motoService.createMoto(motoPrenchido);
		
		Assertions.assertThat(motoCreated.getId()).isNotNull();
		Assertions.assertThat(motoCreated.getName()).isEqualTo("Moto Test Name");
		Assertions.assertThat(motoCreated.getBrand()).isEqualTo("testBrand");
	}
	
	@Test //FindAllUser
	void test02() throws Exception {
		List<Moto> listMoto =  (List<Moto>) motoService.findAllMoto();
		
		Assertions.assertThat(listMoto != null);
	}
	
	@Test //FindByIdMoto
	void test03() throws Exception {
        Moto motoFinded = motoService.findMotoById(motoCreated.getId());
        
        Assertions.assertThat(motoFinded.getId()).isEqualTo(motoCreated.getId());
		Assertions.assertThat(motoFinded.getName()).isEqualTo("Moto Test Name");
		Assertions.assertThat(motoFinded.getLicensePlate()).isEqualTo("testLicensePlate");
	}

	@Test //UpdateUser
    public void test04() throws Exception {
		Moto motoFinded = motoService.findMotoById(motoCreated.getId());
		
		motoFinded.setName("Test Moto Name Update");
		motoFinded.setBrand("testBrandUpdate");
        Moto motoUpdeted = motoService.updateMoto(motoFinded.getId(), motoFinded);
       
		Assertions.assertThat(motoUpdeted.getName()).isEqualTo("Test Moto Name Update");
		Assertions.assertThat(motoUpdeted.getBrand()).isEqualTo("testBrandUpdate");
    }
	
	@Test //DeleteMoto
    public void test05() throws Exception {
        String motoDeleted = motoService.deleteMoto(motoCreated.getId());
       
        Assertions.assertThat(motoDeleted.equals("deleted"));
    }

}
