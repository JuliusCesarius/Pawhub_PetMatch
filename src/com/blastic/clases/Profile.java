
package com.blastic.clases;

import java.util.UUID;

public class Profile{
   	private String aboutMe;
   	private String creationDate;
   	private String dOB;
   	private String lastName;
   	private Number livesIn;
   	private String livesInCity;
   	private String name;
   	private String phone;
   	private String picture;
   	private Number privacy;
   	private Number profileId;
   	private UUID userId;
   	private Number wasBornIn;
   	private String wasBornInCity;

 	public String getAboutMe(){
		return this.aboutMe;
	}
	public void setAboutMe(String aboutMe){
		this.aboutMe = aboutMe;
	}
 	public String getCreationDate(){
		return this.creationDate;
	}
	public void setCreationDate(String creationDate){
		this.creationDate = creationDate;
	}
 	public String getDOB(){
		return this.dOB;
	}
	public void setDOB(String dOB){
		this.dOB = dOB;
	}
 	public String getLastName(){
		return this.lastName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
 	public Number getLivesIn(){
		return this.livesIn;
	}
	public void setLivesIn(Number livesIn){
		this.livesIn = livesIn;
	}
 	public String getLivesInCity(){
		return this.livesInCity;
	}
	public void setLivesInCity(String livesInCity){
		this.livesInCity = livesInCity;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public String getPhone(){
		return this.phone;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
 	public String getPicture(){
		return this.picture;
	}
	public void setPicture(String picture){
		this.picture = picture;
	}
 	public Number getPrivacy(){
		return this.privacy;
	}
	public void setPrivacy(Number privacy){
		this.privacy = privacy;
	}
 	public Number getProfileId(){
		return this.profileId;
	}
	public void setProfileId(Number profileId){
		this.profileId = profileId;
	}
 	public UUID getUserId(){
		return this.userId;
	}
	public void setUserId(UUID userId){
		this.userId = userId;
	}
 	public Number getWasBornIn(){
		return this.wasBornIn;
	}
	public void setWasBornIn(Number wasBornIn){
		this.wasBornIn = wasBornIn;
	}
 	public String getWasBornInCity(){
		return this.wasBornInCity;
	}
	public void setWasBornInCity(String wasBornInCity){
		this.wasBornInCity = wasBornInCity;
	}
}
