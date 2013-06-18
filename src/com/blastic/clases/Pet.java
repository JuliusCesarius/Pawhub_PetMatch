
package com.blastic.clases;

import java.util.UUID;

public class Pet{
   	private boolean active;
   	private String name;
   	private String petCounter;
   	private UUID petId;
   	private String petProfile;
   	private UUID userId;

 	public boolean getActive(){
		return this.active;
	}
	public void setActive(boolean active){
		this.active = active;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public String getPetCounter(){
		return this.petCounter;
	}
	public void setPetCounter(String petCounter){
		this.petCounter = petCounter;
	}
 	public String getPetProfile(){
		return this.petProfile;
	}
	public void setPetProfile(String petProfile){
		this.petProfile = petProfile;
	}
 	public UUID getPetId(){
		return this.petId;
	}
	public void setPetId(UUID petId){
		this.userId = petId;
	}
 	public UUID getUserId(){
		return this.userId;
	}
	public void setUserId(UUID userId){
		this.userId = userId;
	}
}
