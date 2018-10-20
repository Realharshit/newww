package com.cg.contactbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.contactbook.bean.EnquiryBean;
import com.cg.contactbook.exceptions.NoDetailsFoundException;
import com.cg.contactbook.exceptions.ServicesDownException;
import com.cg.contactbook.util.ConnectionProvider;

public class ContactBookDaoImpl implements ContactBookDao{
	private Connection conn = new ConnectionProvider().getDBConnection();
	@Override
	public int addEnquiry(EnquiryBean enqry) throws SQLException {
		try{
			conn.setAutoCommit(false);
			String sql = "INSERT INTO enquiry(enqryid,firstname,lastname,contactno,domain,city)"
					+ "VALUES(enquiries.nextval,?,?,?,?,?)";
			PreparedStatement pstmt1 = conn.prepareStatement(sql);

			pstmt1.setString(1, enqry.getfName());
			pstmt1.setString(2, enqry.getlName());
			pstmt1.setString(3, enqry.getContactNo());
			pstmt1.setString(4, enqry.getpDomain());
			pstmt1.setString(5, enqry.getpLocation());
			pstmt1.executeUpdate();
			conn.commit();
			PreparedStatement pstmt2 = conn.prepareStatement("SELECT MAX(enqryid) FROM enquiry");
			ResultSet rs = pstmt2.executeQuery();
			rs.next();
			int enquiryId= rs.getInt(1);
			return enquiryId;
		}catch(SQLException e){
			e.printStackTrace();
			conn.rollback();
			throw e;
		}finally{
			conn.setAutoCommit(true);
		}
	}

	@Override
	public EnquiryBean getEnquiryDetails(int enquiryId) throws SQLException, ServicesDownException, NoDetailsFoundException {
		try {
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM enquiry WHERE enqryid=";
			PreparedStatement pstmt2 = conn.prepareStatement(sql+enquiryId);
			ResultSet demandRS = pstmt2.executeQuery();
			if(demandRS.next()){
				String fName = demandRS.getString("firstname");
				String lName = demandRS.getString("lastname");
				String contactNo = demandRS.getString("contactno");
				String pDomain = demandRS.getString("domain");
				String pLocation = demandRS.getString("city");
				EnquiryBean enquirybean1=new EnquiryBean(fName,lName,contactNo,pDomain,pLocation);
				return enquirybean1;
			}
			else throw new NoDetailsFoundException("No Details are Found");
		} catch (SQLException e) {
			conn.rollback();
			throw new ServicesDownException("We are sorry! Services are down");
		}finally{
			conn.setAutoCommit(true);
		}

	}

}