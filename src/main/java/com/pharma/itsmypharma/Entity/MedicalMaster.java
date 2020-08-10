package com.pharma.itsmypharma.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "pharma_medi_mast")
@DynamicInsert
@DynamicUpdate
public class MedicalMaster implements Serializable {

	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Id
	@Column(name = "pmm_medi_id")
	private String mediId;

	@Column(name = "pmm_drug_name")
	private String drugName;

	@Column(name = "pmm_composition")
	private String composition;

	@Column(name = "pmm_manufact")
	private String manuFact;

	@Column(name = "pmm_mrp")
	private String mrp;

	@Column(name = "pmm_price")
	private String price;

	@Column(name = "pmm_package_vol")
	private String packageVolume;

	@Column(name = "pmm_presc_type")
	private Character prescType;

	@Column(name = "pmm_medi_use")
	private String mediUse;

	@Column(name = "pmm_how_use")
	private String howToUse;

	@Column(name = "pmm_safety_advice")
	private String safetyAdvice;

	@Column(name = "pmm_alter_brand")
	private String alterBrand;

	@Column(name = "pmm_related_product")
	private String relatedProduct;

	@Column(name = "pmm_manufact_addr")
	private String manuFactAddr;

//	@OneToMany(mappedBy = "medicalMaster", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<MedicalImages> imageList;
	
	public MedicalMaster() {
	}

	public String getMediId() {
		return mediId;
	}

	public void setMediId(String mediId) {
		this.mediId = mediId;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getComposition() {
		return composition;
	}

	public void setComposition(String composition) {
		this.composition = composition;
	}

	public String getManuFact() {
		return manuFact;
	}

	public void setManuFact(String manuFact) {
		this.manuFact = manuFact;
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

	public String getPackageVolume() {
		return packageVolume;
	}

	public void setPackageVolume(String packageVolume) {
		this.packageVolume = packageVolume;
	}

	public Character getPrescType() {
		return prescType;
	}

	public void setPrescType(Character prescType) {
		this.prescType = prescType;
	}

	public String getMediUse() {
		return mediUse;
	}

	public void setMediUse(String mediUse) {
		this.mediUse = mediUse;
	}

	public String getHowToUse() {
		return howToUse;
	}

	public void setHowToUse(String howToUse) {
		this.howToUse = howToUse;
	}

	public String getSafetyAdvice() {
		return safetyAdvice;
	}

	public void setSafetyAdvice(String safetyAdvice) {
		this.safetyAdvice = safetyAdvice;
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

	public String getManuFactAddr() {
		return manuFactAddr;
	}

	public void setManuFactAddr(String manuFactAddr) {
		this.manuFactAddr = manuFactAddr;
	}

//	public List<MedicalImages> getImageList() {
//		return imageList;
//	}
//
//	public void setImageList(List<MedicalImages> imageList) {
//		this.imageList = imageList;
//	}
	
	

}
