package com.smartbiz.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.smartbiz.model.Vendor;
import com.smartbiz.constants.CustomQuery;

public interface VendorRepository extends Repository<Vendor, Long>{
	
	Collection<Vendor> findByStatusAndDeleted(String status,String deleted);
	Vendor findByVid (Integer vid);
	
	List<Vendor> save (List<Vendor> vendors);
	Vendor save (Vendor vendor);

	@Modifying
	@Query(CustomQuery.DELETE_VENDORS)
	int deleteVendors (List<Integer> vendorIds);
	
}
