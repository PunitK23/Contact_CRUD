package com.punitit.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "CONTACT_DTLS")
public class Contact {
	
	@Id
	@Column(name = "CONTACT_ID")
	@GeneratedValue
	private Integer contactId;
	
	@Column(name = "CONTACT_NAME")
	@NotEmpty(message = "Contact name is Mandatory")
	private String contactName;
	
	@Column(name = "CONTACT_EMAIL")
	@NotEmpty(message = "Contact Email is Mandatory")
	@Email(message = "Insert valid Email")
	private String contactEmail;
	
	@Column(name = "CONTACT_PHNO")
	@NotNull(message = "Contact Number is Mandatory")
	private Long contactPhno;

	@Column(name = "CREATED_DATE", updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(name = "UPDATED_DATE", insertable = false)
	@UpdateTimestamp
	private LocalDate updatedDate;
	
	@Column(name = "ACTIVE_SW")
	private String activeSw;
	
}
