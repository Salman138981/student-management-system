package com.masai.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rollNo;

    @NotNull(message = "First Name is Required")
    @Size(min = 1, message = "First Name is Required")
    private String firstName;

    @NotNull(message = "Last Name is Required")
    @Size(min = 1, message = "Last Name is Required")
    private String lastName;

      @Pattern(regexp = "\\d{10}", message = "Phone Number must be 10 digits")
    private String phoneNumber;

    @Past(message = "Date of Birth must be in the past")
    private LocalDate dateOfBirth;

    @NotNull(message = "Gender is mandatory")
    private String gender;

    @NotNull(message = "Address is mandatory")
    private String address;
	
}
