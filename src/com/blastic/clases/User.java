
package com.blastic.clases;

import java.util.UUID;

public class User{
   	private String emailId;
   	private boolean online;
   	private String password;
   	private String pets;
   	private String picture;
   	private String profile;
   	private UUID userId;
   	private String userName;

 	public String getEmailId(){
		return this.emailId;
	}
	public void setEmailId(String emailId){
		this.emailId = emailId;
	}
 	public boolean getOnline(){
		return this.online;
	}
	public void setOnline(boolean online){
		this.online = online;
	}
 	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password){
		this.password = password;
	}
 	public String getPets(){
		return this.pets;
	}
	public void setPets(String pets){
		this.pets = pets;
	}
 	public String getPicture(){
		return this.picture;
	}
	public void setPicture(String picture){
		this.picture = picture;
	}
 	public String getProfile(){
		return this.profile;
	}
	public void setProfile(String profile){
		this.profile = profile;
	}
 	public UUID getUserId(){
		return this.userId;
	}
	public void setUserId(UUID userId){
		this.userId = userId;
	}
 	public String getUserName(){
		return this.userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
}
