/**
 * 
 */
package com.alvaroscheid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

/**
 * @author alvaro-scheid
 *
 */
@Entity
@Table(name = "usernames")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Setter
    private long id;
	@Getter
	@Setter
	@NotBlank(message = "Username is mandatory")
	@Column(unique = true)
    private String username;
	@Getter
	@Setter
    @NotBlank(message = "Password is mandatory")
    private String password;
}
