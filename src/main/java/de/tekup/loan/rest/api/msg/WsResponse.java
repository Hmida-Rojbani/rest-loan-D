package de.tekup.loan.rest.api.msg;

import java.util.List;

import lombok.Data;

@Data
public class WsResponse {
	
	private boolean isEligeble;
	private long approvedAmount;
	private List<String> criteriaMismatch;
}
