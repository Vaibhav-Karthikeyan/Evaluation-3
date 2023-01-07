package com.masai.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","user"})
public class Fir {
	@Id
	@GeneratedValue
	private int firId;
	@Pattern(regexp="^[A-Z][a-z]*",message = "{firstName.invalid}")
	private String firstName;
	@Pattern(regexp="^[A-Z][a-z]*",message = "{lastName.invalid}")
	private String lastName;
	@Size(min=10,max=10,message = "{mobileNumber.invalid}")
	private String mobileNumber;
	private String address;
	@Min(8)
	private int age;
	@Pattern(regexp="male|Male|female|Female|transgender|Transgender",message = "{gender.invalid}")
	private String gender;
	@ManyToOne(fetch = FetchType.LAZY) 
	private User user;
}
