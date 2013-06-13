package org.springframework.batch.admin.category;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.GZIPInputStream;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.vendertool.marketplaces.mercadolibre.Category;

public class CategoryItemReader implements ItemReader<String> {
	static GZIPInputStream zipIn;
	static int exceptionCount = 0;
	private static final String INPUT_GZIP_FILE = "C:/StartUp/Data/output.gz";

	private static final String OUTPUT_FILE = "C:/StartUp/Data/samplecategory.json";
	static int c;

	private static BufferedReader br;

	// Whole static code needs to be put into the before job listener.
	private static List<Category> categories = null;
	static org.codehaus.jackson.JsonParser jp;
	private static int MAX_SIZE = 0;
	static HashMap<String, LinkedHashMap> result;
	private static int CURRENT_INDEX = 0;
	static Set<String> keySet;
	static Set<Entry<String, JsonElement>> set;
	static Iterator<Entry<String, JsonElement>> iterator;
	static {
		byte[] buffer = new byte[1024];
		try {
			GZIPInputStream gzis = new GZIPInputStream(new FileInputStream(
					INPUT_GZIP_FILE));
			FileOutputStream fos = new FileOutputStream(OUTPUT_FILE);
			int len;
			while ((len = gzis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			gzis.close();
			fos.close();
			System.out.println("Done");
			/*
			 * // Open the file FileInputStream fstream = new
			 * FileInputStream(OUTPUT_FILE);
			 * 
			 * // Get the object of DataInputStream DataInputStream in = new
			 * DataInputStream(fstream); br = new BufferedReader(new
			 * InputStreamReader(in));
			 */
			/*
			 * Gson gson = new Gson(); BufferedReader br = new BufferedReader(
			 * new FileReader(OUTPUT_FILE)); TypeToken<List<Category>> token =
			 * new TypeToken<List<Category>>(){}; categories = gson.fromJson(br,
			 * token.getType()); CURRENT_INDEX = categories.size();
			 */

			/*
			 * JsonFactory f = new MappingJsonFactory(); jp =
			 * f.createJsonParser(new File(OUTPUT_FILE));
			 * org.codehaus.jackson.JsonToken current; current = jp.nextToken();
			 * JsonNode node = jp.readValueAsTree(); node.findParents(fieldName)
			 * current = node.asToken();
			 */
			JsonParser parser = new JsonParser();
			JsonElement jsonElement = parser.parse(new FileReader(OUTPUT_FILE));
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			set = jsonObject.entrySet();
			/*
			 * keySet = result.keySet(); MAX_SIZE = keySet.size(); iterator =
			 * keySet.iterator();
			 */
			System.out.println("");
			iterator = set.iterator();
		} catch (IOException ex) {
			System.out.println("failed");
		}
	}

	@Override
	public String read() throws Exception, UnexpectedInputException,
			ParseException {
		/*
		 * Locale locale = Locale.getDefault(); locale.setDefault(new
		 * Locale("es","ES"));
		 * 
		 * String value = iterator.next(); System.out.println(""+value);
		 * LinkedHashMap category= (LinkedHashMap)result.get(value); // byte
		 * ptext[] = .getBytes(); String categoryString =
		 * category.toString();//new String(ptext, "UTF-8");
		 * 
		 * try{ Category obj = new Gson().fromJson(categoryString,
		 * Category.class); }catch(Exception e){ exceptionCount++; } if
		 * (!iterator.hasNext()) {
		 * System.out.println("Exception Counts : "+exceptionCount); return
		 * null; }
		 */

		if (!iterator.hasNext()) {
			System.out.println("Exception Count : "+exceptionCount);
			return null;
		}
		Entry<String, JsonElement> entryValue = iterator.next();
		entryValue.getValue();
		JsonElement value = entryValue.getValue();
		ObjectMapper mapper = new ObjectMapper();
		Category cat = null;
		try {
			cat = mapper.readValue(value.toString(), Category.class);
		} catch (Exception e) {
			exceptionCount++;
			System.out.println("" + value);
		}
		return value.toString();
	}
}