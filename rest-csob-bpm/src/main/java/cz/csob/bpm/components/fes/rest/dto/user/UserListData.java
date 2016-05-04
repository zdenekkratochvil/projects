package cz.csob.bpm.components.fes.rest.dto.user;

import java.util.List;

public class UserListData {
	
	// attributes

	List<UserListItem> items;

	// getters and setters

	public List<UserListItem> getItems() {
		return items;
	}

	public void setItems(List<UserListItem> items) {
		this.items = items;
	}
	
	// default methods

	@Override
	public String toString() {
		return "UserData [items=" + items + "]";
	}

}
