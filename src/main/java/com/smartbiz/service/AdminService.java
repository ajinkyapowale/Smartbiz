package com.smartbiz.service;

import java.util.List;

import com.smartbiz.exception.SmartbizException;
import com.smartbiz.model.Vendor;

public interface AdminService {
	
	public List<Vendor> getAllVendorList() throws SmartbizException;
	public Vendor saveVendor(Vendor vendor) throws SmartbizException;
	public int deleteVendors (List<Integer> vendorsIds) throws SmartbizException;
	public Vendor getVendorById (Integer vid) throws SmartbizException;

}
