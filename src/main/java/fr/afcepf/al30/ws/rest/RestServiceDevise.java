package fr.afcepf.al30.ws.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al30.data.Devise;
import fr.afcepf.al30.ws.service.IServiceDevise;

/*
 * classe java d'un WS REST basée sur l'api standard JAX-RS
 * cette api est implémentée par la partie "-rs" de CXF dans ce projet
 */

@Path("devise")
@Produces("application/json")
@Component //de Spring --> id de ce composant : restServiceDevise
public class RestServiceDevise {
	
	@Autowired
	private IServiceDevise serviceDevise; //business service en arrière plan
	
	@GET
	@Path("/{code}")
	//URL: http://localhost:8080/serveurWs/services/rest/devise/EUR
	public Devise deviseByCode(@PathParam("code")String codeDevise){
		return serviceDevise.rechercherDeviseParCode(codeDevise);
	}
	
	//...

}