package com.vendertool.test;

import com.vendertool.sharedtypes.core.Listing;

public class ListingTests {

	public static void main(String [] args){
		
		System.out.println(Listing.ListingFormatEnum.get(4));
		System.out.println(Listing.ListingFormatEnum.get(2));
		System.out.println(Listing.ListingFormatEnum.get(33));
	}
}