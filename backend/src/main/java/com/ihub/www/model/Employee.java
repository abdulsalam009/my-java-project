package com.ihub.www.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String name;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	private Date doj;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="deptId_fk")
	private Department dept;
}
