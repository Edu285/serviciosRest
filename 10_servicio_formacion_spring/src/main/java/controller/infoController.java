package controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Ficha;

@RestController
public class infoController {
	
	@GetMapping(value="info",produces=MediaType.APPLICATION_JSON_VALUE)
	public Ficha info() {
		return new Ficha("PC",800,"Informatica");
	}
}
