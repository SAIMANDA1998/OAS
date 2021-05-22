package com.cg.oas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oas.entities.Address;
import com.cg.oas.repository.IAddressRepository;
import com.cg.oas.service.IAddressService;

@RestController
@RequestMapping("/Address")
public class AddressController {
	@Autowired
	private IAddressService iAddressService;
	@Autowired
	private IAddressRepository iAddressRepository;
	@PostMapping("/addAddress")
	public ResponseEntity<Address> addAddress(@RequestBody Address address)
	{
		Address obj=iAddressService.addAddress(address);
		return new ResponseEntity<Address>(obj, HttpStatus.OK);
	}
	 @GetMapping("/getallAddress")
		public ResponseEntity<List<Address>> getAllAddress() 
	  {
		  List<Address> list=iAddressRepository.findAll();
		  return new ResponseEntity<List<Address>>(list, HttpStatus.OK);
	  }
	 @PutMapping("/updateAddress")
	 public ResponseEntity<Address> updateAddress(@RequestBody Address newAddress)
		{
			Address obj=iAddressService.updateAddress(newAddress);
			return new ResponseEntity<Address>(obj, HttpStatus.OK);
		}
	 @DeleteMapping("/deleteAddressById/{addressId}")
	 public ResponseEntity<List<Address>> deleteAddress(@PathVariable Integer addressId)
		{
		List<Address> obj=iAddressService.deleteAddressById(addressId);
			return new ResponseEntity<List<Address>>(obj, HttpStatus.OK);
		}
	 @GetMapping("/getAddressById/{addressId}")
	 public ResponseEntity<Address> getAddressById(@PathVariable Integer addressId)
		{
			Address obj=iAddressService.getAddressById(addressId);
			return new ResponseEntity<Address>(obj, HttpStatus.OK);
		}
	 
	 
	}
