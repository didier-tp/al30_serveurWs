package fr.afcepf.al30.ws.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.afcepf.al30.data.Devise;
import fr.afcepf.al30.ws.service.IServiceDevise;

/*
 * classe java d'un WS REST basée sur l'api spring-mvc
 */

@RestController //de Spring --> id de ce composant : restCtrlDevise
@RequestMapping(value="/rest/devise" , headers="Accept=application/json")
public class RestCtrlDevise {
	
	@Autowired
	private IServiceDevise serviceDevise; //business service en arrière plan
	
	//@RequestMapping(value="" , method=RequestMethod.POST)
	@PostMapping(value="" )
	//URL: http://localhost:8080/serveurWs/mvc/rest/devise
	// avec dans le corps invisible de la requete une jsonString 
	// de type { "codeDevise" : "ms1" , "tauxChange" : 1.123 }
	//@RequestBody pour le param en entrée JSON --> java
	public Devise saveOrUpdateDevise(@RequestBody Devise d){
		Devise existingDevise = serviceDevise.rechercherDeviseParCode(d.getCodeDevise());
		if(existingDevise==null){
			serviceDevise.ajouterDevise(d);
		}else{
			serviceDevise.modifierDevise(d);
		}
		return d;//converti en JSON via @Produces(...)
	}
	
	    //@RequestMapping(value="/{code}" , method=RequestMethod.DELETE)
		@DeleteMapping(value="/{code}" )
		//URL: http://localhost:8080/serveurWs/mvc/rest/devise/ms1
		public ResponseEntity<Devise> deleteByCode(@PathVariable("code")String codeDevise){
			try {
				serviceDevise.supprimerDevise(codeDevise);
				return new ResponseEntity<Devise>(HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<Devise>(HttpStatus.INTERNAL_SERVER_ERROR);//ou plus précis si exception plus précise
			}
		}
	
	//@RequestMapping(value="/{code}" , method=RequestMethod.GET)
	@GetMapping(value="/{code}" ) 
	//URL: http://localhost:8080/serveurWs/mvc/rest/devise/EUR
	public Devise deviseByCode(@PathVariable("code")String codeDevise){
		return serviceDevise.rechercherDeviseParCode(codeDevise);
	}
	
	
	//@RequestMapping(value="" , method=RequestMethod.GET)
	@GetMapping(value="" ) 
	//URL: http://localhost:8080/serveurWs/mvc/rest/devise
	//ou bien http://localhost:8080/serveurWs/mvc/rest/devise?tauxMax=2
	public List<Devise> devisesByCriteria(@RequestParam(value="tauxMax",required=false)Double tauxMax){
		if(tauxMax==null)
		    return serviceDevise.rechercherToutesDevises();
		else 
			return serviceDevise.rechercherDevisesAvecTauxMax(tauxMax);
	}
	
	
	
	
	

}
