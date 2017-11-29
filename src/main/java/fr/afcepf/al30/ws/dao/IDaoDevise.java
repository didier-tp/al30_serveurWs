package fr.afcepf.al30.ws.dao;

import java.util.List;

import fr.afcepf.al30.data.Devise;

public interface IDaoDevise {
	
	public Devise deviseByCode(String codeDevise);
	public List<Devise> allDevises(); 
	public List<Devise> devisesAvecTauxMaxi(double tauxMax);
	
	public void insertDevise(Devise d);
	public void updateDevise(Devise d);
	public void deleteDevise(String codeDevise);
	//...
}
