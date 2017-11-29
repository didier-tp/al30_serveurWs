package fr.afcepf.al30.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Devise.findByTauxMax", 
            query="SELECT d FROM Devise d WHERE d.tauxChange <= :tauxMax")
public class Devise {
	@Id
	private String codeDevise; //"EUR" , "USD" , "JPY" , "GBP" , ...
	private double tauxChange; //par rapport au dollar
	
	//+get/set , etc
}
