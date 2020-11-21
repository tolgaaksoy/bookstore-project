package com.tolgaaksoy.bookstoreApp.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
	private String username;
    @Column
	private String password;
	
}
