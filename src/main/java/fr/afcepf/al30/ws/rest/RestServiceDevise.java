package fr.afcepf.al30.ws.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
	
	@POST
	@Path("")
	//URL: http://localhost:8080/serveurWs/services/rest/devise
	// avec dans le corps invisible de la requete une jsonString 
	// de type { "codeDevise" : "ms1" , "tauxChange" : 1.123 }
	@Consumes("application/json") //pour param en entrée
	public Devise saveOrUpdateDevise(Devise d){
		Devise existingDevise = serviceDevise.rechercherDeviseParCode(d.getCodeDevise());
		if(existingDevise==null){
			serviceDevise.ajouterDevise(d);
		}else{
			serviceDevise.modifierDevise(d);
		}
		return d;//converti en JSON via @Produces(...)
	}
	
	@GET
	@Path("/{code}")
	//URL: http://localhost:8080/serveurWs/services/rest/devise/EUR
	public Devise deviseByCode(@PathParam("code")String codeDevise){
		return serviceDevise.rechercherDeviseParCode(codeDevise);
	}
	
	@DELETE
	@Path("/{code}")
	//URL: http://localhost:8080/serveurWs/services/rest/devise/ms1
	public Response deleteByCode(@PathParam("code")String codeDevise){
		try {
			serviceDevise.supprimerDevise(codeDevise);
			return Response.status(Status.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();//ou plus précis si exception plus précise
		}
	}
	
	@GET
	@Path("")
	//URL: http://localhost:8080/serveurWs/services/rest/devise
	//ou bien http://localhost:8080/serveurWs/services/rest/devise?tauxMax=2
	public List<Devise> devisesByCriteria(@QueryParam("tauxMax")Double tauxMax){
		if(tauxMax==null)
		    return serviceDevise.rechercherToutesDevises();
		else 
			return serviceDevise.rechercherDevisesAvecTauxMax(tauxMax);
	}

}
