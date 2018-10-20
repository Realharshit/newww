package com.cg.contactbook.service;

import java.sql.SQLException;

import com.cg.contactbook.bean.EnquiryBean;
import com.cg.contactbook.dao.ContactBookDao;
import com.cg.contactbook.dao.ContactBookDaoImpl;
import com.cg.contactbook.exceptions.DataValidationException;

public class ContactBookServiceImpl implements ContactBookService {
ContactBookDao dao=new ContactBookDaoImpl();
	@Override
	public int addEnquiry(EnquiryBean enqry) throws SQLException, DataValidationException {
	int enqryId;
	boolean validation = validEnquiry(enqry);
	if(validation==false)
		throw new DataValidationException("Data is incorrect");
	enqryId=dao.addEnquiry(enqry);
	
		return enqryId;
	}

	@Override
	public EnquiryBean getEnquiryDetails(int enquiryId) throws SQLException {
		EnquiryBean enquiryBean = null;
		try {
			enquiryBean = dao.getEnquiryDetails(enquiryId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return enquiryBean;
	}

	@Override
	public boolean validEnquiry(EnquiryBean enqry) {
		String contact=enqry.getContactNo();
		boolean c=validatecontactNo(contact);
		String fname=enqry.getfName();
		boolean d=validateFirstName(fname);
		String lname=enqry.getlName();
		boolean e=validateLastName(lname);
		String pLocation=enqry.getpLocation();
		boolean f=validatePLocation(pLocation);
		String pDomain=enqry.getpDomain();
		boolean t=validatePDomain(pDomain);
		if(c==true&&d==true&&e==true&&f==true&&t==true)
		return true;
		else
			return false;
	}
	public boolean validatecontactNo(String contactNo){
		boolean c;
		char numbers[]=contactNo.toCharArray();
		for (char d : numbers) {
			if(d<'0'||d>'9')
				return false;
		}
		if(contactNo.length()==10)
			return true;
		else
			return false;
	}
	public boolean validateFirstName(String fName){
	if(fName.length()==0)
		return false;
	else
		return true;
	}
	public boolean validateLastName(String lName){
		if(lName.length()==0)
			return false;
		else
			return true;
	}
	public boolean validatePLocation(String pLocation){
		if(pLocation.length()==0)
			return false;
		else
			return true;
	
	}
	public boolean validatePDomain(String pDomain){
		if(pDomain.length()==0)
			return false;
		else
			return true;
	}
}
