package com.vendertool.common.dal;

import java.util.HashMap;
import java.util.Map;

import com.vendertool.common.DAOFactoryKey;

public class DAOFactoryRegistry {

	private static Map<DAOFactoryKey, BaseDAOFactory> s_registry;

	// To make Singleton *** Start ***
	private static class DAORegistrySingletonHelper {
		private static final DAOFactoryRegistry INSTANCE = new DAOFactoryRegistry();
	}

	private DAOFactoryRegistry() {
		s_registry = new HashMap<DAOFactoryKey, BaseDAOFactory>();
	}

	// To make Singleton *** End ***

	public static DAOFactoryRegistry getInstance() {
		return DAORegistrySingletonHelper.INSTANCE;
	}

	public BaseDAOFactory getFactory(DAOFactoryKey key) {
		BaseDAOFactory dao = null;
		if (key != null) {
			dao = s_registry.get(key);
		}
		return dao;
	}

	public void register(DAOFactoryKey key, BaseDAOFactory factory) {
		if (key != null) {
			s_registry.put(key, factory);
		}
	}
}