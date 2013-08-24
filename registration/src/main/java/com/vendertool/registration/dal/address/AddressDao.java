package com.vendertool.registration.dal.address;

import java.util.List;

import org.hibernate.FlushMode;



public interface AddressDao {

	void insert (Address address);
	
	//void insert (Address address,FlushMode flushMode );

	void update(Address address);

	void delete(Address address);

	List <Address> findByAddressId(Address address);
	
}
