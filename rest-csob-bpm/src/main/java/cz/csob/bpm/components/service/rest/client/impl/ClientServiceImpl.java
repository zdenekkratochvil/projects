package cz.csob.bpm.components.service.rest.client.impl;

import java.sql.Array;
import java.util.Arrays;
import java.util.Date;

import org.springframework.stereotype.Service;

import cz.csob.bpm.components.fes.rest.dto.client.Account;
import cz.csob.bpm.components.fes.rest.dto.client.Address;
import cz.csob.bpm.components.fes.rest.dto.client.ClientListData;
import cz.csob.bpm.components.fes.rest.dto.client.ClientListItem;
import cz.csob.bpm.components.fes.rest.dto.client.Email;
import cz.csob.bpm.components.fes.rest.dto.client.Role;
import cz.csob.bpm.components.service.rest.client.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Override
	public ClientListData getClientListByCuid(String cuid) {
		return getMockClientListData();
	}

	@Override
	public ClientListData getClientListByIppid(String ippid) {
		return getMockClientListData();
	}

	public ClientListData getClientListByAccountNumber(String accountNumber) {
		return getMockClientListData();
	}

	@Override
	public ClientListData getDisponentListByAccountNumber(String accountNumber) {
		return getMockClientListData();
	}	

	private ClientListData getMockClientListData() {
		ClientListData data = new ClientListData();
		
		ClientListItem item0 = new ClientListItem();
		item0.setBirthDate(new Date());
		item0.setBirthNumber("8101020123");
		item0.setCuid("123456");
		item0.setIppid("789456");
		item0.setName("Dežo");
		item0.setRiskFlag(false);
		item0.setSurname("Demeter");
		item0.setTitle("PhDr.");
		
		Address address0 = new Address();
		address0.setCity("Praha 6");
		address0.setStreet("Evropská 15");
		address0.setPostCode("16000" );
		
		item0.getAddresses().add(address0);
		
		Account account0 = new Account();
		account0.setId("123456789");
		account0.setId("0300");
		account0.setIban("IBAN123456789");
		
		item0.getAccounts().add(account0);
		
		Email email0 = new Email();
		email0.setEmail("dedem@email.com");
		
		item0.getEmails().add(email0);
		
		Role role0 = new Role();
		role0.setType((short) 5);
		
		item0.getRoles().add(role0);
		
		ClientListItem item1 = new ClientListItem();
		item1.setBirthDate(new Date());
		item1.setBirthNumber("7855147654");
		item1.setCuid("67893");
		item1.setIppid("122287");
		item1.setName("Martina");
		item1.setRiskFlag(false);
		item1.setSurname("Nováková");

		data.setClientList(Arrays.asList(item0, item1));

		return data;
	}

	

}
