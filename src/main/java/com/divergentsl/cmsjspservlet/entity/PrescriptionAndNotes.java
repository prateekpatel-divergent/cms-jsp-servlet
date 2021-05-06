package com.divergentsl.cmsjspservlet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "prescription")
@Setter
@Getter
@ToString
public class PrescriptionAndNotes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "prescription")
	private String prescription;
	
	@Column(name = "note")
	private String note;
	
	@ManyToOne
	@JoinColumn(name = "doctor_Id", nullable = false)
	private Doctor doctorId;

	@ManyToOne
	@JoinColumn(name = "patient_Id")
	private Patient patientid;
}
