package de.tekup.loan.rest.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import de.tekup.loan.rest.api.msg.CustomerRequest;
import de.tekup.loan.rest.api.msg.WsResponse;

@Service
public class LoanService {
	
	public WsResponse getLoanStatus(CustomerRequest request) {
		
		WsResponse response = new WsResponse();
		List<String> mismatchList = new ArrayList<>();
		
		if(!(request.getAge() >= 30 && request.getAge() <=50))
			mismatchList.add("Client age must be between 30 and 50.");
		if(!(request.getYearlyIncome() >= 25000))
			mismatchList.add("Client yearly income must be over 25000");
		if(!(request.getCibilScore() >= 500))
			mismatchList.add("Client cibil score must be over 500");
		
		if(mismatchList.isEmpty()) {
			response.setEligeble(true);
			long amount = (long)((60 - request.getAge())*request.getYearlyIncome()*0.4);
			response.setApprovedAmount(amount);
		}else {
			response.setEligeble(false);
			response.setApprovedAmount(0);
			response.setCriteriaMismatch(mismatchList);
		}
		
		return response;
	}

}
