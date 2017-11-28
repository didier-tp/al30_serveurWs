package fr.afcepf.al30.ws.service;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService() //targetNamespace par defaut: http://service/ws.al30.afcepf.fr/
public interface IServiceTva {
	public double tva(@WebParam(name="ht")double ht,
			          @WebParam(name="taux") double taux);
	public String getAuteur();
	//...
}
