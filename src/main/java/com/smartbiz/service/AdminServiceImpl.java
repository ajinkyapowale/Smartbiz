package com.smartbiz.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.smartbiz.constants.Constant;
import com.smartbiz.exception.SmartbizException;
import com.smartbiz.model.Vendor;
import com.smartbiz.repository.VendorRepository;

@Component
public class AdminServiceImpl implements AdminService{

	private final Logger logger = Logger.getLogger(AdminServiceImpl.class);
	
	@Autowired
	VendorRepository vendorRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<Vendor> getAllVendorList() throws SmartbizException{
		List<Vendor> vendorLst = null;
		try {
			vendorLst = (List<Vendor>) vendorRepo.findByStatusAndDeleted(Constant.ACTIVE,Constant.NO);
		}catch (Exception e) {
			throw new SmartbizException(e);
		}
		return vendorLst;
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public Vendor saveVendor(Vendor vendor) throws SmartbizException {
		Vendor updatedVendor = null;
		try {
			logger.debug("Vendor: "+vendor);
			vendor.setStatus(Constant.ACTIVE);
			vendor.setDeleted(Constant.NO);
			updatedVendor = vendorRepo.save(vendor);
		}catch (Exception e) {
			throw new SmartbizException(e);
		}
		return updatedVendor;
	}

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public int deleteVendors(List<Integer> vendorIds) throws SmartbizException {
		int result=0;
		try {
			logger.debug("Vendor Ids: "+vendorIds);
			
			result = vendorRepo.deleteVendors(vendorIds);
			
		}catch (Exception e) {
			throw new SmartbizException(e);
		}
		return result;
	}

	@Override
	public Vendor getVendorById(Integer vid) throws SmartbizException {
		
		Vendor vendor = null;
		try {
			
			vendor = vendorRepo.findByVid(vid);
			
		}catch(Exception e) {
			throw new SmartbizException(e);
		}
		
		return vendor;
	}
	
	

}
