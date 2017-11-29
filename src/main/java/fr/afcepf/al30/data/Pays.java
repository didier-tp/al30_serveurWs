package fr.afcepf.al30.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@XmlAccessorType(XmlAccessType.FIELD)
public class Pays {
	@Id
	private String codePays;//ex: "fr"
	private String nomPays; //ex: "France" 
	//private String capitale;
	
	@ManyToOne
	@JoinColumn(name="devise")
	@XmlTransient
	private Devise devise;

	@Override
	public String toString() {
		return "Pays [codePays=" + codePays + ", nomPays=" + nomPays + "]";
	}
	
	
}
