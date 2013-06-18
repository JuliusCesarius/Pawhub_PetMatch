
package com.blastic.clases;

import java.util.UUID;

public class TopCategory{
   	private String name;
   	private String petName;
   	private UUID petid;
   	private String picture;
   	private Number rateCategoryId;
   	private Number rates;

 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public String getPetName(){
		return this.petName;
	}
	public void setPetName(String petName){
		this.petName = petName;
	}
 	public UUID getPetid(){
		return this.petid;
	}
	public void setPetid(UUID petid){
		this.petid = petid;
	}
 	public String getPicture(){
		return this.picture;
	}
	public void setPicture(String picture){
		this.picture = picture;
	}
 	public Number getRateCategoryId(){
		return this.rateCategoryId;
	}
	public void setRateCategoryId(Number rateCategoryId){
		this.rateCategoryId = rateCategoryId;
	}
 	public Number getRates(){
		return this.rates;
	}
	public void setRates(Number rates){
		this.rates = rates;
	}
}
