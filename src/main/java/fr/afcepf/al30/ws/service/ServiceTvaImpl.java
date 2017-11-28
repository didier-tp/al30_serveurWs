package fr.afcepf.al30.ws.service;

import javax.jws.WebService;

@WebService(endpointInterface="fr.afcepf.al30.ws.service.IServiceTva")
public class ServiceTvaImpl implements IServiceTva {

	@Override
	public double tva(double ht, double taux) {
		return ht*taux/100;
	}

	@Override
	public String getAuteur() {
		return "didier ou ...";
	}

}
