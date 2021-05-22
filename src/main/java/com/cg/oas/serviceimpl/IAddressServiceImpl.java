package com.cg.oas.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oas.entities.Address;
import com.cg.oas.exception.AddressIdNotFoundException;
import com.cg.oas.repository.IAddressRepository;
import com.cg.oas.service.IAddressService;

@Service
public class IAddressServiceImpl implements IAddressService{
	@Autowired
	private IAddressRepository iAddressRepo;

	@Override
	public Address addAddress(Address address) {
		// TODO Auto-generated method stub
		return iAddressRepo.save(address);
	}

	@Override
	public List<Address> deleteAddressById(int addressId)throws AddressIdNotFoundException {
		Optional<Address> optional = iAddressRepo.findById(addressId);
		if(optional.isPresent()) {
			
		// TODO Auto-generated method stub
		iAddressRepo.deleteById(addressId);
		return iAddressRepo.findAll();
		}
		else
			throw new AddressIdNotFoundException("No Address Id");
	}

	@Override
	public Address updateAddress(Address newAddress) throws AddressIdNotFoundException{
		// TODO Auto-generated method stub
		Optional<Address> optional = iAddressRepo.findById(newAddress.getAddressId());
		if(optional.isPresent()) {
		iAddressRepo.save(newAddress);
		return newAddress;
		}
		else
			throw new AddressIdNotFoundException("No Address Id");
	}

	@Override
	public Address getAddressById(int addressId) throws AddressIdNotFoundException{
		// TODO Auto-generated method stub
		Optional<Address> optional = iAddressRepo.findById(addressId);
		if(optional.isPresent()) {
			return optional.get();	
		}
		else
			throw new AddressIdNotFoundException("No Address Id");
		
		}
	}
