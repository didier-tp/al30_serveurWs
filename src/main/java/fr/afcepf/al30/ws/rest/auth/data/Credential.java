package fr.afcepf.al30.ws.rest.auth.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@NoArgsConstructor
public class Credential {
	private String username;
	private String password;
	//...
	
}
