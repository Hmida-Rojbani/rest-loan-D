package de.tekup.loan.rest.api.rest.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.loan.rest.api.msg.CustomerRequest;
import de.tekup.loan.rest.api.msg.WsResponse;
import de.tekup.loan.rest.api.service.LoanService;

@RestController
@RequestMapping("/api")
public class LoanRestController {
	@Autowired
	private LoanService service;
	
	@PostMapping(path="/get-status", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
								   , consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<WsResponse> getLoanStatus(@RequestBody CustomerRequest request){
		WsResponse response = service.getLoanStatus(request);
		return new ResponseEntity<WsResponse>(response,HttpStatus.OK);
	}

}
