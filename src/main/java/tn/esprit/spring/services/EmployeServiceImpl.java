package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeRepository;
@Service
public class EmployeServiceImpl implements IEmployeService{

	@Autowired
	EmployeRepository employeRepository;
	
	private static Logger l=LogManager.getLogger(EmployeServiceImpl.class);
	@Override
	public Employe addEmploye(Employe u) {
		l.info("addEmploye Start");
		Employe u_saved = employeRepository.save(u); 
		l.info("addEmploye done");
		return u_saved; 
	}

	@Override
	public void deleteEmploye(String id) {
		l.info("deleteEmploye Start");
		employeRepository.deleteById(Long.parseLong(id)); 
		l.info("deleteEmploye done");
		
	}

	@Override
	public Employe updateEmploye(Employe u) {
		l.info("updateEmploye Start");
		Employe u_saved = employeRepository.save(u); 
		l.info("updateEmploye done");// TODO Log à ajouter à la fin de la méthode 
		return u_saved; 
	}

	@Override
	public Employe retrieveEmploye(String id) {
		l.info("retrieveEmploye Start");// TODO Log à ajouter en début de la méthode 
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		Employe u =  employeRepository.findById(Long.parseLong(id)).get(); 
		l.info("retrieveEmploye done");// TODO Log à ajouter à la fin de la méthode 
		return u; 
	}

	@Override
	public List<Employe> retrieveAllEmployes() {
		List<Employe> employes = null; 
		try {
	
			l.info("retrieveAllemployes() Start"); 
			employes = (List<Employe>) employeRepository.findAll();  
			for (Employe employe : employes) {
				l.info("employes:"+employes+"\n"); 
			} 
			l.info("Out retrieveAllemployes() without errors.");
		}catch (Exception e) {
			l.error("Erreur dans retrieveAllemployes() : " + e);// TODO Log à ajouter pour gérer les erreurs 
		}

		return employes;
	}

}
