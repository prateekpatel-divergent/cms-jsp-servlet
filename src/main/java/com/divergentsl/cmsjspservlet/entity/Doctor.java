package com.divergentsl.cmsjspservlet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name ="doctor")
@Setter
@Getter
@ToString
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "speciality")
	private String speciality;
	
	@Column(name = "contact_no")
	private String contactno;
	
	@Column(name = "fee")
	private int fee;
	
	@Column(name = "degree")
	private String degree;
}
