package de.tekup.loan.rest.api.rest.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	
	@PostMapping("/get-status")
	public ResponseEntity<WsResponse> getLoanStatus(@RequestBody CustomerRequest request){
		WsResponse response = service.getLoanStatus(request);
		return new ResponseEntity<WsResponse>(response,HttpStatus.OK);
	}

}