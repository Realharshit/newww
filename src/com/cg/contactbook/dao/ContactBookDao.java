package com.cg.contactbook.dao;

import java.sql.SQLException;

import com.cg.contactbook.bean.EnquiryBean;
import com.cg.contactbook.exceptions.NoDetailsFoundException;
import com.cg.contactbook.exceptions.ServicesDownException;

public interface ContactBookDao {
public int addEnquiry(EnquiryBean enqry) throws SQLException;
public EnquiryBean getEnquiryDetails(int EnquiryId) throws SQLException, ServicesDownException, NoDetailsFoundException;
}
