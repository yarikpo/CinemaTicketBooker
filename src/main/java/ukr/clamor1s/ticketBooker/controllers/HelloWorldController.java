package ukr.clamor1s.ticketBooker.controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {

	@GetMapping("/hello")
	public String hello() {
		
		return "hello";
	}
	
	@RequestMapping(
		    value = "/process", 
		    method = RequestMethod.POST,
		    consumes = "application/json")
		public ResponseEntity<?> process(@RequestBody String payload) 
		    throws Exception {

		  System.out.println(payload);
//		  Gson g = new Gson();
//		  JSONParser parser = new JSONParser();  
		  
		  return new ResponseEntity<>(HttpStatus.OK);

		}
	
}
