package com.vendertool.listing.dal.listingVariation;

import java.util.List;

import com.vendertool.inventory.dal.listingVariation.ListingVariation;


public interface ListingVariationDao {

	void insert (ListingVariation listingVariation);

	void update(ListingVariation listingVariation);

	void delete(ListingVariation listingVariation);

	
}
