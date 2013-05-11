package org.springframework.batch.admin.categorypull;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class CategoryPullReader implements ItemReader<String> {

	private static String CATEGORY_URL = "https://api.mercadolibre.com/sites/MLB/categories/all";

	@Override
	public String read() throws Exception, UnexpectedInputException,
			ParseException {
/*		System.out.println("Connecting to Mercadolibre site...\n");
		URL url = new URL(CATEGORY_URL);
		url.openConnection();
		InputStream reader = url.openStream();
		FileOutputStream writer = new FileOutputStream(
				"C:/StartUp/Data/categoryAll.gz");
		try {
			byte[] buffer = new byte[1024];
			int noRead;
			while ((noRead = reader.read(buffer)) != -1) {
				writer.write(buffer, 0, noRead);
			}
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
			}
		}*/
		// Place the file in the location and return null so that the current
		// step is considered to be done.
		return null;
	}
}