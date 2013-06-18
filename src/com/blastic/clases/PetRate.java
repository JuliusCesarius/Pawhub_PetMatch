
package com.blastic.clases;

import java.util.UUID;

public class PetRate{
   	private String lastRateDate;
   	private UUID petId;
   	private Number petRateId;
   	private Number rate1Star;
   	private Number rate2Stars;
   	private Number rate3Stars;
   	private Number rate4Stars;
   	private Number rate5Stars;
   	private String rateCategory;
   	private Number rateCategoryId;

 	public String getLastRateDate(){
		return this.lastRateDate;
	}
	public void setLastRateDate(String lastRateDate){
		this.lastRateDate = lastRateDate;
	}
 	public UUID getPetId(){
		return this.petId;
	}
	public void setPetId(UUID petId){
		this.petId = petId;
	}
 	public Number getPetRateId(){
		return this.petRateId;
	}
	public void setPetRateId(Number petRateId){
		this.petRateId = petRateId;
	}
 	public Number getRate1Star(){
		return this.rate1Star;
	}
	public void setRate1Star(Number rate1Star){
		this.rate1Star = rate1Star;
	}
 	public Number getRate2Stars(){
		return this.rate2Stars;
	}
	public void setRate2Stars(Number rate2Stars){
		this.rate2Stars = rate2Stars;
	}
 	public Number getRate3Stars(){
		return this.rate3Stars;
	}
	public void setRate3Stars(Number rate3Stars){
		this.rate3Stars = rate3Stars;
	}
 	public Number getRate4Stars(){
		return this.rate4Stars;
	}
	public void setRate4Stars(Number rate4Stars){
		this.rate4Stars = rate4Stars;
	}
 	public Number getRate5Stars(){
		return this.rate5Stars;
	}
	public void setRate5Stars(Number rate5Stars){
		this.rate5Stars = rate5Stars;
	}
 	public String getRateCategory(){
		return this.rateCategory;
	}
	public void setRateCategory(String rateCategory){
		this.rateCategory = rateCategory;
	}
 	public Number getRateCategoryId(){
		return this.rateCategoryId;
	}
	public void setRateCategoryId(Number rateCategoryId){
		this.rateCategoryId = rateCategoryId;
	}
}
