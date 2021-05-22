package com.cg.oas.service;

import java.util.List;

import com.cg.oas.entities.Address;

public interface IAddressService
{
	public Address addAddress(Address address);
	public List<Address> deleteAddressById(int addressId);
//	public int deleteAddressByCity(String city);
	public Address updateAddress(Address newAddress);
	public Address getAddressById(int addressId);
	

}
