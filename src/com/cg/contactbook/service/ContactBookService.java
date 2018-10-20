package com.cg.contactbook.service;

import java.sql.SQLException;

import com.cg.contactbook.bean.EnquiryBean;
import com.cg.contactbook.exceptions.DataValidationException;

public interface ContactBookService {
public int addEnquiry(EnquiryBean enqry) throws SQLException, DataValidationException;
public EnquiryBean getEnquiryDetails(int EnquiryId) throws SQLException;
public boolean validEnquiry(EnquiryBean enqry);
}
