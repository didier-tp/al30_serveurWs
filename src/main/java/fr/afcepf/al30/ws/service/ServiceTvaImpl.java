package fr.afcepf.al30.ws.service;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

@WebService(endpointInterface="fr.afcepf.al30.ws.service.IServiceTva")
@Service //de Spring (ou bien @Component)
//id par defaut du composant spring : serviceTvaImpl (avec minuscule au début)
public class ServiceTvaImpl implements IServiceTva {

	@Override
	public double tva(double ht, double taux) {
		System.out.println("tva() appele avec ht="+ht + " et taux=" + taux);
		return ht*taux/100;
	}

	@Override
	public String getAuteur() {
		return "didier ou ...";
	}

}
