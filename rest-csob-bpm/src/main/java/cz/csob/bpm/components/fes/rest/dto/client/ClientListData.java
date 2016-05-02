package cz.csob.bpm.components.fes.rest.dto.client;

import java.util.List;

public class ClientListData {
	
	// attributes

	private List<ClientListItem> clientList;
	
	// getters and setters

	public List<ClientListItem> getClientList() {
		return clientList;
	}

	public void setClientList(List<ClientListItem> clientList) {
		this.clientList = clientList;
	}
	
	// default methods

	@Override
	public String toString() {
		return "ClientListData [clientList=" + clientList + "]";
	}
}
