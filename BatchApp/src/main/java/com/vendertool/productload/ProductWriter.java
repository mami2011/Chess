package com.vendertool.productload;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.vendertool.batch.ExampleItemWriter;

/**
 * Dummy {@link ItemWriter} which only logs data it receives.
 */
@Component("productwriter")
public class ProductWriter implements ItemWriter<Object> {

private static final Log log = LogFactory.getLog(ExampleItemWriter.class);
	
	/**
	 * @see ItemWriter#write(java.util.List)
	 */
	public void write(List<? extends Object> data) throws Exception {
		log.info(data);
	}

}
