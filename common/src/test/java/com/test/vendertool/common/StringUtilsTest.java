package com.test.vendertool.common;

import java.io.UnsupportedEncodingException;

import com.vendertool.common.utils.StringUtils;

public class StringUtilsTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		StringUtils strUtils = StringUtils.getInstance();
		String inputString = "Vender Tool is going to ROCK! adfawrvfbgrbrswrg f  joancofwnovNWROVSF IPJENvpjnwpfedajp- nefivnapidmnz poiweJCPJFV-EOJMVR DSVAVEVAERVEVRWEV EBFEGRDBGFS FEVAEGBSBEF SVWRVSAF V VWARVWEF FGBEAVERBRGABERSGDRF";
		byte[] actualBytes = inputString.getBytes("UTF-8");
		byte[] compressedByte = strUtils.compressByteArray(inputString);
		String unCompressedString = strUtils.decompressString(compressedByte);

		System.out.println("Actual String : " + inputString);
		System.out.println("Actual Size : " + actualBytes.length);
		System.out.println("Compressed String : " + new String(compressedByte));
		System.out.println("Compressed Size : " + compressedByte.length);
		System.out.println("String after uncompress : " + unCompressedString);
	}
}