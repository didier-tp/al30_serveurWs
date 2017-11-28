package fr.afcepf.al30.ws.serveur;

import javax.xml.ws.Endpoint;

import fr.afcepf.al30.ws.service.ServiceTvaImpl;

public class StartWsServerApp {

	public static void main(String[] args) {
		String address ="http://localhost:8080/serveurWs/services/tva";
		System.out.println("démarrage du serveur avec url="+address);
        ServiceTvaImpl implementor = new ServiceTvaImpl();
		Endpoint.publish(address, implementor);
		try {
			Thread.sleep(15*60*1000);//15mn
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(0);
		System.out.println("serveur automatiquement arreté apres 15mn");
	}
	
	//pour tester:
	//1. http://localhost:8080/serveurWs/services/tva?wsdl dans navigateur
    //2. test avec soap-ui , (new soap-project , meme url ?wsdl , ...)
}
