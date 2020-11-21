package com.tolgaaksoy.bookstoreApp.models;

import java.util.ArrayList;
import java.util.List;

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
public class Bookstore extends BaseEntity{

	@Column
	private String bookstoreName;
	@Lob
	@Column
	private String description;

	@OneToMany(targetEntity = Book.class, mappedBy = "bookstore")
	public List<Book> books = new ArrayList<>();
}
