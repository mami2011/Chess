package org.springframework.batch.admin.category;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.batch.item.ItemWriter;

import com.vendertool.marketplaces.mercadolibre.Category;
import com.vendertool.marketplaces.mercadolibre.Path_from_root;
import com.vendertool.marketplaces.mercadolibre.Settings;

public class CategoryItemWritter implements ItemWriter<Object> {
	@Override
	public void write(List<? extends Object> items) throws Exception {
		/*int count = 0;
		for (String message : (List<String>) items) {
			count++;
			ConnectionFactory factory = new ConnectionFactory();
			factory.setUsername("guest"); // username, I have set a default
											// account
			factory.setPassword("guest"); // password
			factory.setVirtualHost("/"); // have no virtual host
			factory.setHost("ec2-54-224-103-18.compute-1.amazonaws.com"); // AWS
																			// rabbitMQ
																			// broker
			factory.setPort(5672); // port number
			Connection conn = factory.newConnection();
			Channel channel = conn.createChannel();
			String exchangeName = "messaging.sample.exchange"; // this is the
																// exchange name
			String routingKey = "test"; // routing key
			byte[] messageBodyBytes = ("message:" + count + "")
					.getBytes();
			channel.basicPublish(exchangeName, routingKey,
					MessageProperties.PERSISTENT_TEXT_PLAIN, messageBodyBytes);
			channel.close();
			conn.close();
		}*/
		for(String value : (List<String>)items){
			Category cat = null;
			ObjectMapper mapper = new ObjectMapper();
			try {
				cat = mapper.readValue(value.toString(), Category.class);
				insertData(cat);
			} catch (Exception e) {
				System.out.println("" + value);
			}
		}
	}

	/**
	 * 
	 * @param cat
	 */
	private void insertData(Category cat) {
		dal.dao.MlCategories categories = new dal.dao.MlCategories();
		
		categories.setMeliCategoryName(cat.getName());
		categories.setMeliCategoryId(cat.getId());
		categories.setSiteId("MLB");
		//categories.setBuyingAllowed(buyingAllowed);
		
		String attribute = cat.getAttribute_types();
		if(attribute != null){
			categories.setHasAttributes(true);
		}
		
//		categories.setListingAllowed(setting.);
		List<Path_from_root> pathFromRootList = cat.getPath_from_root();
		if (pathFromRootList != null && pathFromRootList.size() > 1) {
			categories.setRootId(pathFromRootList.get(
					pathFromRootList.size() - 2).getId());
		}
		
		
		Settings setting = cat.getSettings();
		if(setting != null){
			boolean adultCOntent = setting.getAdult_content();
			categories.setBuyingAllowed(setting.getBuying_allowed());//boolean
			
			setting.getCoverage_areas();
			setting.getCurrencies();
			setting.getImmediate_payment();
			setting.getItem_conditions();
			setting.getItems_reviews_allowed();
			setting.getListing_allowed();
			setting.getMax_pictures_per_item();
			setting.getMaximum_price();
			setting.getMinimum_price();
			setting.getMirror_category();
			setting.getPrice();
			setting.getRounded_address();
			setting.getRounded_address();
			setting.getSeller_contact();
			
			setting.getShipping_modes();
			setting.getShipping_options();
			setting.getShipping_profile();
			setting.getShow_contact_information();
			setting.getSimple_shipping();
			setting.getStock();
			setting.getTags();
			setting.getVip_subdomain();
			List<String> buyingModes = setting.getBuying_modes();
			if( buyingModes != null && buyingModes.size() > 0 ){
				for(String buyingMode : buyingModes){
					if(buyingMode != null && buyingMode.length() > 0){
						
					}
				}
			}
		}
		/*categories.setHasAttributes(hasAttributes);
		categories.setListingAllowed(listingAllowed);
		categories.setMeliCategoryId(meliCategoryId);
		categories.setMeliCategoryName(meliCategoryName);
		categories.setRootId(rootId);
		categories.setSiteId(siteId);*/
		
		String categoryId = cat.getId();
		String categoryName = cat.getName();
		String permalink = cat.getPermalink();
		
		
		//Save ALL
		//categories --> save it
		
	}
}
