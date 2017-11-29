package fr.afcepf.al30.data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Devise.findByTauxMax", 
            query="SELECT d FROM Devise d WHERE d.tauxChange <= :tauxMax")
@XmlAccessorType(XmlAccessType.FIELD) //pour @XmlTransient sur private
public class Devise {
	@Id
	private String codeDevise; //"EUR" , "USD" , "JPY" , "GBP" , ...
	private double tauxChange; //par rapport au dollar
	
	//+get/set , etc
	@OneToMany(mappedBy="devise")
	@XmlTransient
	//@JsonIgnore
	private List<Pays> pays;

	@Override
	public String toString() {
		return "Devise [codeDevise=" + codeDevise + ", tauxChange=" + tauxChange + "]";
	}

	public Devise(String codeDevise, double tauxChange) {
		super();
		this.codeDevise = codeDevise;
		this.tauxChange = tauxChange;
	}


	
	
}
