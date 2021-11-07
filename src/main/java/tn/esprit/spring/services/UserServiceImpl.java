package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;
	
	private static Logger l=LogManager.getLogger(UserServiceImpl.class);

	// TODO Logger à ajouter  
	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
	
			l.info("retrieveAllUsers() Start");// TODO Log à ajouter en début de la méthode 
			users = (List<User>) userRepository.findAll();  
			for (User user : users) {
				l.info("users:"+users+"\n");// TODO Log à ajouter pour affiher chaque user dans les logs   
			} 
			l.info("Out retrieveAllUsers() without errors.");
// TODO Log à ajouter à la fin de la méthode 
		}catch (Exception e) {
			l.error("Erreur dans retrieveAllUsers() : " + e);// TODO Log à ajouter pour gérer les erreurs 
		}

		return users;
	}


	@Override
	public User addUser(User u) {
		l.info("addUser Start");// TODO Log à ajouter en début de la méthode 
		User u_saved = userRepository.save(u); 
		l.info("addUser done");// TODO Log à ajouter à la fin de la méthode 
		return u_saved; 
	}

	@Override 
	public User updateUser(User u) { 
		l.info("updateUser Start");// TODO Log à ajouter en début de la méthode 
		User u_saved = userRepository.save(u); 
		l.info("updateUser done");// TODO Log à ajouter à la fin de la méthode 
		return u_saved; 
	}

	@Override
	public void deleteUser(String id) {
		l.info("deleteUser Start");// TODO Log à ajouter en début de la méthode 
		userRepository.deleteById(Long.parseLong(id)); 
		l.info("deleteUser done");// TODO Log à ajouter à la fin de la méthode 
	}

	@Override
	public User retrieveUser(String id) {
		l.info("retrieveUser Start");// TODO Log à ajouter en début de la méthode 
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		User u =  userRepository.findById(Long.parseLong(id)).get(); 
		l.info("retrieveUser done");// TODO Log à ajouter à la fin de la méthode 
		return u; 
	}

}
