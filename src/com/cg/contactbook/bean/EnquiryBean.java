package com.cg.contactbook.bean;

public class EnquiryBean {
	private int enqryId;
	private String fName;
	private String lName;
	private String contactNo;
	private String pLocation;
	private String pDomain;

	public EnquiryBean() {
		super();
	}

	public EnquiryBean(int enqryId, String fName, String lName, String contactNo,
			String pLocation, String pDomain) {
		super();
		this.enqryId = enqryId;
		this.fName = fName;
		this.lName = lName;
		this.contactNo = contactNo;
		this.pLocation = pLocation;
		this.pDomain = pDomain;
	}


	public EnquiryBean(String fName, String lName, String contactNo,
			String pLocation, String pDomain) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.contactNo = contactNo;
		this.pLocation = pLocation;
		this.pDomain = pDomain;
	}

	

	public EnquiryBean(int enqryId) {
		super();
		this.enqryId = enqryId;
	}

	public int getEnqryId() {
		return enqryId;
	}

	public void setEnqryId(int enqryId) {
		this.enqryId = enqryId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getpLocation() {
		return pLocation;
	}

	public void setpLocation(String pLocation) {
		this.pLocation = pLocation;
	}

	public String getpDomain() {
		return pDomain;
	}

	public void setpDomain(String pDomain) {
		this.pDomain = pDomain;
	}

	@Override
	public String toString() {
		return "EnquiryBean [enqryId=" + enqryId + ", fName=" + fName + ", lName="
				+ lName + ", contactNo=" + contactNo + ", pLocation=" + pLocation
				+ ", pDomain=" + pDomain + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contactNo == null) ? 0 : contactNo.hashCode());
		result = prime * result + enqryId;
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + ((lName == null) ? 0 : lName.hashCode());
		result = prime * result + ((pDomain == null) ? 0 : pDomain.hashCode());
		result = prime * result + ((pLocation == null) ? 0 : pLocation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnquiryBean other = (EnquiryBean) obj;
		if (contactNo == null) {
			if (other.contactNo != null)
				return false;
		} else if (!contactNo.equals(other.contactNo))
			return false;
		if (enqryId != other.enqryId)
			return false;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		if (pDomain == null) {
			if (other.pDomain != null)
				return false;
		} else if (!pDomain.equals(other.pDomain))
			return false;
		if (pLocation == null) {
			if (other.pLocation != null)
				return false;
		} else if (!pLocation.equals(other.pLocation))
			return false;
		return true;
	}



}
