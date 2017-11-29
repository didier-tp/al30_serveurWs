package fr.afcepf.al30.ws.serveur;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.xml.ws.Endpoint;

import fr.afcepf.al30.ws.service.ServiceTvaImpl;

public class StartWsServerApp {

	public static void main(String[] args) {
		String   hostName = "localhost"; //par defaut
		try {
			final InetAddress addr = InetAddress.getLocalHost();
			hostName = new String(addr.getHostName());
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		//String machineServeur="localhost";//ou adress ip (ipconfig)
		String portTcpIp="8080"; //ou 8081
		String address ="http://" +	hostName + ":" + portTcpIp
		                      + "/serveurWs/services/tva?wsdl";
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
