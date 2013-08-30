package com.vendertool.listing.dal.listing;

import java.util.List;

import com.vendertool.listing.dal.listing.Listing;



public interface ListingDao {

	void insert (Listing listing);

	void update(Listing listing);

	void delete(Listing listing);
	List<Listing> findByListingId(long listingId);
	
	List<Listing> findByAccountId(long listingId);
	
}
