package fr.afcepf.al30.ws.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al30.data.Devise;
import fr.afcepf.al30.data.Pays;

@Repository //ou @Component
@Transactional
public class DeviseDaoJpa implements IDaoDevise {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Devise deviseByCode(String codeDevise) {
		return entityManager.find(Devise.class, codeDevise);
	}

	public List<Devise> allDevises() {
		return entityManager.createQuery("SELECT d FROM Devise d",Devise.class).getResultList();
	}

	public List<Devise> devisesAvecTauxMaxi(double tauxMax) {
		return entityManager.createNamedQuery("Devise.findByTauxMax",Devise.class)
				.setParameter("tauxMax",tauxMax).getResultList();
	}

	public void insertDevise(Devise d) {
		entityManager.persist(d);
	}

	public void updateDevise(Devise d) {
		entityManager.merge(d);
	}

	public void deleteDevise(String codeDevise) {
		Devise d = entityManager.find(Devise.class, codeDevise);
        entityManager.remove(d);
	}

	@Override
	public void insertPays(Pays p) {
		entityManager.persist(p);
	}

	@Override
	public List<Pays> allPays() {
		return entityManager.createQuery("SELECT p FROM Pays p",Pays.class).getResultList();
	}

}
