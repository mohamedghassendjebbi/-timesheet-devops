package tn.esprit.spring.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;
import tn.esprit.spring.services.UserServiceImpl;


@SpringBootTest
public class USerServiceImplTest {
	@Autowired
	IUserService us;
	private static Logger l=LogManager.getLogger(UserServiceImpl.class);
	@Test
	public void testAddUser() throws ParseException
	{
		SimpleDateFormat dateform= new SimpleDateFormat("yyyy-MM-dd");
		Date d=dateform.parse("2015-03-23");
		User u=new User("test1","test1",d,Role.TECHNICIEN);
		User useradd=us.addUser(u);
		Assertions.assertEquals(u.getLastName(),useradd.getLastName());
	}
	@Test
	public void testModifyUser() throws ParseException
	{
		SimpleDateFormat dateform= new SimpleDateFormat("yyyy-MM-dd");
		Date d=dateform.parse("2015-03-23");
		User u=new User(2L,"hunter","master",d,Role.TECHNICIEN);
		User useradd=us.addUser(u);
		Assertions.assertEquals(u.getLastName(),useradd.getLastName());
	}
	@Test
	public void testRetriveAll()
	{
		List<User> listuser=us.retrieveAllUsers();
		l.info("users:"+listuser+"\n");
		Assertions.assertEquals(1,listuser.size());
	}
	@Test
	public void testDelete()
	{
		us.deleteUser("1");
		
	}
	@Test
	public void testRetriveUser()
	{
		User user=us.retrieveUser("2");
		l.info("user:"+user+"\n");
		
	}
	
}
