
package com.blastic.clases;

public class Rating{
   	private Number rateCategoryId;
   	private Number stars;

 	public Number getRateCategoryId(){
		return this.rateCategoryId;
	}
	public void setRateCategoryId(Number rateCategoryId){
		this.rateCategoryId = rateCategoryId;
	}
 	public Number getStars(){
		return this.stars;
	}
	public void setStars(Number stars){
		this.stars = stars;
	}
}
