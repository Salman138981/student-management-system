package com.masai.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    
	@Pattern(regexp = "\\d{10}", message = "Phone Number must be 10 digits")
    private String phoneNumber;
	 
	 @NotNull(message = "Address is mandatory")
	 private String address;
}
