package com.vendertool.registration.bof;

import org.apache.log4j.Logger;

import com.vendertool.common.DAOFactoryKey;
import com.vendertool.common.dal.BaseBOF;
import com.vendertool.common.dal.BaseDAOFactory;
import com.vendertool.common.dal.DAOFactoryRegistry;
import com.vendertool.registration.dal.address.AddressDAOFactory;
import com.vendertool.registration.dal.address.AddressDao;
import com.vendertool.sharedtypes.core.Address;

public class AddressBOF extends BaseBOF {

	private static final Logger logger = Logger.getLogger(AddressBOF.class
			.getName());
	private AddressDao dao;

	// To make Singleton *** Start ***
	private static class AddressBOFSingletonHelper {
		private static final AddressBOF INSTANCE = new AddressBOF();
	}

	private AddressBOF() {
		BaseDAOFactory baseFactory = DAOFactoryRegistry.getInstance()
				.getFactory(DAOFactoryKey.ADDRESS_DAO);
		if (baseFactory != null) {
			AddressDAOFactory addressDAOFactory = (AddressDAOFactory) baseFactory;
			dao = addressDAOFactory.getDAO();
		} else {
			// TODO log
		}
	}

	// To make Singleton *** End ***

	public static AddressBOF getInstance() {
		return AddressBOFSingletonHelper.INSTANCE;
	}

	public void insert(Address addressBO) {
		com.vendertool.registration.dal.address.Address addressDo = new com.vendertool.registration.dal.address.Address();

		//addressDo.setAddressId();
		addressDo.setAddrLn1(addressBO.getAddressLine1());
		addressDo.setAddrLn2(addressBO.getAddressLine2());
		addressDo.setCity(addressBO.getCity());
		addressDo.setState(addressBO.getState());
		addressDo.setPostalCode(addressBO.getZip());
		//Need Country code enum to set
		//addressDo.setCountryCodeIso3(addressBO.getCountry());
		
		// Insert into DB
		
		dao.insert(addressDo);
	}

}