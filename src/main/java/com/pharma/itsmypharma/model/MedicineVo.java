package com.pharma.itsmypharma.model;

import com.pharma.itsmypharma.Entity.MedicalMaster;

public class MedicineVo {

	public String mediId;

	public String medicineName;

	public String description;

	public String mrp;

	public String price;

	public String company;

	public String companyAddress;

	public String alterBrand;

	public String relatedProduct;
	
    public String image;

	
	public MedicineVo() {
		
	}
	
	public MedicineVo(MedicalMaster master) {
		this.mediId=master.getMediId();
		this.medicineName=master.getDrugName();
		this.description=master.getComposition();
		//this.mrp=master.getMrp();
		//this.price=master.getPrice();
		this.company=master.getManuFact();
		this.companyAddress=master.getManuFactAddr();
		//this.alterBrand=master.getAlterBrand();
		//this.relatedProduct=master.getRelatedProduct();
		this.image=null;
	}

	public String getMediId() {
		return mediId;
	}

	public void setMediId(String mediId) {
		this.mediId = mediId;
	}

	

	public String getMrp() {
		return mrp;
	}

	public void setMrp(String mrp) {
		this.mrp = mrp;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	

	public String getAlterBrand() {
		return alterBrand;
	}

	public void setAlterBrand(String alterBrand) {
		this.alterBrand = alterBrand;
	}

	public String getRelatedProduct() {
		return relatedProduct;
	}

	public void setRelatedProduct(String relatedProduct) {
		this.relatedProduct = relatedProduct;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	
	

}
