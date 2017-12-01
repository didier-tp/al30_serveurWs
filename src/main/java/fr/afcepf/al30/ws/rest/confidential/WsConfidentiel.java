package fr.afcepf.al30.ws.rest.confidential;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.afcepf.al30.ws.rest.annotation.AuthTokenRequired;

@RestController
@RequestMapping(value="/rest/confidential" ,headers="Accept=application/json" )
public class WsConfidentiel {
	
	//url = http://localhost:8080/serveurWs/mvc/rest/confidential/news
	@RequestMapping(value="/news" ,method=RequestMethod.GET )
	@AuthTokenRequired
	public ResponseEntity<News> getNews(){
			News news = new News();
			news.setTitre("news of the day");
			news.setTexte("you know what ? i am happy !");
			return new ResponseEntity<News>(news,HttpStatus.OK);
	}

}
