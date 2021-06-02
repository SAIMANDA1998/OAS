package com.cg.oas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.oas.entities.Address;
import com.cg.oas.repository.IAddressRepository;
import com.cg.oas.service.IAddressService;

@SpringBootTest
public class AddressTest {
	
	@Autowired
	private IAddressService iAddressService;

	@MockBean
	private IAddressRepository iAddressRepo;

	@Test
	public void getAddresssTest() {
		
		Address address = new Address();
		address.setAddressId(1);
		address.setCity("Hyderbad");
		address.setCountry("India");
		address.setDistrict("Medak");
		address.setLandmark("Oppsite to Hyderbad");
		address.setZipcode("500055");
		address.setState("Telangana");
		
		iAddressRepo.save(address);
		Address address1 = iAddressService.addAddress(address);
		assertThat(address1).isEqualTo(address1);

	}

	@Test
	public void createAddressTest() {

		Address address = new Address(10,"Kakinada", "East Godavari", "Andhra Pradesh", "India", "533001","city");
		
		when(iAddressRepo.save(address)).thenReturn(address);
		assertEquals(address, iAddressService.addAddress(address));
	}
	

	@Test
	public void updateAddressTest() {


		Address address = new Address(10,"Hyderbad", "East Godavari", "Andhra Pradesh", "India", "533001","city");
		
		when(iAddressRepo.save(address)).thenReturn(address);
		assertEquals(address, iAddressService.addAddress(address));
	}

	@Test
	public void deleteAddress() {

		Address address = new Address();
		address.setAddressId(1);
		address.setCity("Hyderbad");
		address.setCountry("India");
		address.setDistrict("Medak");
		address.setLandmark("Oppsite to Hyderbad");
		address.setZipcode("500055");
		address.setState("Telangana");
		
		when(iAddressRepo.findById(address.getAddressId())).thenReturn(Optional.of(address));
		iAddressService.deleteAddressById(address.getAddressId());
		verify(iAddressRepo).deleteById(address.getAddressId());
		
	}

}


