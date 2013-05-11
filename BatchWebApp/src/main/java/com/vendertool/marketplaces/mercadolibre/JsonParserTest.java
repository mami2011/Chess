package com.vendertool.marketplaces.mercadolibre;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonParserTest {
	private static final String INPUT_GZIP_FILE = "C:/StartUp/Data/output.gz";

	private static final String OUTPUT_FILE = "C:/StartUp/Data/samplecategory.json";

	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		GZIPInputStream gzis = new GZIPInputStream(new FileInputStream(
				INPUT_GZIP_FILE));
		FileOutputStream fos = new FileOutputStream(OUTPUT_FILE);
		byte[] buffer = new byte[1024];
		int len;
		while ((len = gzis.read(buffer)) > 0) {
			fos.write(buffer, 0, len);
		}
		gzis.close();
		fos.close();
		System.out.println("Done");
		
		InputStream is = new FileInputStream(OUTPUT_FILE);
		InputStreamReader reader = new InputStreamReader(is,"UTF-8");//reader.getEncoding()
		BufferedReader br = new BufferedReader(
				reader);
		/*Category result1 =
		        new Gson().fromJson(reader, Category.class);*/
		JsonParser parser = new JsonParser();
		JsonElement jsonElement = parser.parse(new FileReader(OUTPUT_FILE));
		JsonObject jsonObject = jsonElement.getAsJsonObject();

		for (final Entry<String, JsonElement> entry : jsonObject.entrySet()) {
		   String key = entry.getKey();
		   JsonElement value = entry.getValue();
		   ObjectMapper mapper = new ObjectMapper();
		   Category cat = null;
		   try{
		       cat= mapper.readValue(value.toString(), Category.class);
		   }
		   catch (Exception e) {
		       System.out.println(""+value);
		   }
		}
	}
}