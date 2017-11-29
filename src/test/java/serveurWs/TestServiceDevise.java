package serveurWs;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.afcepf.al30.data.Devise;
import fr.afcepf.al30.ws.service.IServiceDevise;

@RunWith(SpringJUnit4ClassRunner.class)
//ApplicationContext will be loaded from "/jpaSpringConf.xml" in the root of the classpath
@ContextConfiguration(locations={"/jpaSpringConf.xml"})
public class TestServiceDevise {
	
	@Autowired
	IServiceDevise serviceDevise; //à tester
	
	@Test
	public void testAllDevises(){
		List<Devise> devises = serviceDevise.rechercherToutesDevises();
		Assert.assertTrue(devises != null);
		for(Devise d: devises)
			System.out.println(d);
	}

}
