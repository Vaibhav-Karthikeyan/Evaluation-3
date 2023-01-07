package com.masai.app.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class User {
	@Id
	@GeneratedValue
	private int userId;
	private String userName;
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
	@Pattern(regexp="^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{6,12}$",message = "{password.invalid}")
	private String password;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<Fir> fir=new ArrayList<>();
}
