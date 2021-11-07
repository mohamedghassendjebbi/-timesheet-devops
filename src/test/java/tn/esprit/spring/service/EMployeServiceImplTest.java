package tn.esprit.spring.service;

import java.text.ParseException;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.IEmployeService;

@SpringBootTest
public class EMployeServiceImplTest {
	@Autowired
	IEmployeService es;
	private static Logger l=LogManager.getLogger(EmployeServiceImpl.class);

	@Test
	public void testAddEmploye() throws ParseException
	{
		Employe u=new Employe("test1","test1","test@test.com",true,Role.TECHNICIEN);
		Employe useradd=es.addEmploye(u);
		Assertions.assertEquals(u.getPrenom(),useradd.getNom());
	}
	@Test
	public void testModifyEmploye() throws ParseException
	{
		
		Employe u=new Employe(2L,"test1","test1","test@test.com","",true,Role.TECHNICIEN);

		Employe useradd=es.addEmploye(u);
		Assertions.assertEquals(u.getPrenom(),useradd.getNom());
	}
	@Test
	public void testRetriveAll()
	{
		List<Employe> liseEmployer=es.retrieveAllEmployes();
		l.info("users:"+liseEmployer+"\n");
		Assertions.assertEquals(1,liseEmployer.size());
	}
	@Test
	public void testDelete()
	{
		es.deleteEmploye("1");
		
	}
	@Test
	public void testRetriveUser()
	{
		Employe e =es.retrieveEmploye("2");
		l.info("Employe:"+e+"\n");
		
	}
}
