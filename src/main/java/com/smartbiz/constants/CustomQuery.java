package com.smartbiz.constants;

public final class CustomQuery {
	
	public static final String DELETE_VENDORS = "UPDATE Vendor v SET v.deleted = 'Y' where v.vid IN ?1";

}
