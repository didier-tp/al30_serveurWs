package fr.afcepf.al30.ws.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al30.data.Devise;
import fr.afcepf.al30.ws.dao.IDaoDevise;

@Service
@WebService(endpointInterface="fr.afcepf.al30.ws.service.IServiceDevise")
@Transactional
public class ServiceDeviseImpl implements IServiceDevise {
	
	@Autowired //ou @Inject
	private IDaoDevise daoDevise;
	
	@PostConstruct
	public void initJeuxDeDonnees(){
		if(daoDevise.allDevises().isEmpty()){
			daoDevise.insertDevise(new Devise("EUR",0.84));
			daoDevise.insertDevise(new Devise("USD",1.0));
			daoDevise.insertDevise(new Devise("JPY",112.0));
			daoDevise.insertDevise(new Devise("GBP",0.758));
		}
	}

	@Override
	public double convertir(double montant, String codeDeviseSource, String codeDeviseCible) {
		Devise deviseSource = daoDevise.deviseByCode(codeDeviseSource);
		Devise deviseCible = daoDevise.deviseByCode(codeDeviseCible);
		return montant * deviseCible.getTauxChange() / deviseSource.getTauxChange();
	}

	@Override
	public Devise rechercherDeviseParCode(String codeDevise) {
		return daoDevise.deviseByCode(codeDevise);
	}

	@Override
	public List<Devise> rechercherToutesDevises() {
		return daoDevise.allDevises();
	}

	@Override
	public List<Devise> rechercherDevisesAvecTauxMax(double tauxMax) {
		return daoDevise.devisesAvecTauxMaxi(tauxMax);
	}

	@Override
	public void ajouterDevise(Devise d) {
		daoDevise.insertDevise(d);
	}

	@Override
	public void modifierDevise(Devise d) {
		daoDevise.updateDevise(d);
	}

	@Override
	public void supprimerDevise(String codeDevise) {
		daoDevise.deleteDevise(codeDevise);
	}

}
