package com.revature.models.dtos;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.revature.models.database.Ingrediants;
import com.revature.models.database.Steps;

@Entity
@Table(name = "data_transfer_table")
public class RecipeDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int idDTO;
	
	@Column(name = "name")
	private String nameDTO;
	
	@Column(name = "description")
	private String descriptionDTO;
	
	@Column(name = "category")
	private String categoryDTO;
	
	@Column(name = "inspiration")
	private String inspirationDTO;
	
	@Column(name = "user_id")
	private int userIdDTO;
	
    private Ingrediants[] ingrediants;
    
    private Steps[] steps;

	public RecipeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
public RecipeDTO(String nameDTO, String descriptionDTO, String categoryDTO, String inspirationDTO, int userIdDTO) {
	super();
	this.nameDTO = nameDTO;
	this.descriptionDTO = descriptionDTO;
	this.categoryDTO = categoryDTO;
	this.inspirationDTO = inspirationDTO;
	this.userIdDTO = userIdDTO;
}
@Override
public String toString() {
	return "RecipeDTO [idDTO=" + idDTO + ", nameDTO=" + nameDTO + ", descriptionDTO=" + descriptionDTO
			+ ", categoryDTO=" + categoryDTO + ", inspirationDTO=" + inspirationDTO + ", userIdDTO=" + userIdDTO + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((categoryDTO == null) ? 0 : categoryDTO.hashCode());
	result = prime * result + ((descriptionDTO == null) ? 0 : descriptionDTO.hashCode());
	result = prime * result + idDTO;
	result = prime * result + ((inspirationDTO == null) ? 0 : inspirationDTO.hashCode());
	result = prime * result + ((nameDTO == null) ? 0 : nameDTO.hashCode());
	result = prime * result + userIdDTO;
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
	RecipeDTO other = (RecipeDTO) obj;
	if (categoryDTO == null) {
		if (other.categoryDTO != null)
			return false;
	} else if (!categoryDTO.equals(other.categoryDTO))
		return false;
	if (descriptionDTO == null) {
		if (other.descriptionDTO != null)
			return false;
	} else if (!descriptionDTO.equals(other.descriptionDTO))
		return false;
	if (idDTO != other.idDTO)
		return false;
	if (inspirationDTO == null) {
		if (other.inspirationDTO != null)
			return false;
	} else if (!inspirationDTO.equals(other.inspirationDTO))
		return false;
	if (nameDTO == null) {
		if (other.nameDTO != null)
			return false;
	} else if (!nameDTO.equals(other.nameDTO))
		return false;
	if (userIdDTO != other.userIdDTO)
		return false;
	return true;
}
public int getIdDTO() {
	return idDTO;
}
public void setIdDTO(int idDTO) {
	this.idDTO = idDTO;
}
public String getNameDTO() {
	return nameDTO;
}
public void setNameDTO(String nameDTO) {
	this.nameDTO = nameDTO;
}
public String getDescriptionDTO() {
	return descriptionDTO;
}
public void setDescriptionDTO(String descriptionDTO) {
	this.descriptionDTO = descriptionDTO;
}
public String getCategoryDTO() {
	return categoryDTO;
}
public void setCategoryDTO(String categoryDTO) {
	this.categoryDTO = categoryDTO;
}
public String getInspirationDTO() {
	return inspirationDTO;
}
public void setInspirationDTO(String inspirationDTO) {
	this.inspirationDTO = inspirationDTO;
}
public int getUserIdDTO() {
	return userIdDTO;
}
public void setUserIdDTO(int userIdDTO) {
	this.userIdDTO = userIdDTO;
}
	
	

	
	
}
