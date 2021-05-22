package com.cg.oas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oas.entities.Address;
@Repository
public interface IAddressRepository extends JpaRepository<Address,Integer>
{
//	public Address addAddress(Address address);
//	public int deleteAddressById(int addressId);
////	public int deleteAddressByCity(String city);
//	public boolean updateAddress(Address newAddress);
//	public Address getAddressById(int addressId);
	

}
