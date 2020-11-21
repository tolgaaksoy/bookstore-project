package com.tolgaaksoy.bookstoreApp.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Book extends BaseEntity{

	@Column
	private String bookName;

	@Column
	private String bookSubName;

	@Column
	private String bookSeriesName;

	@Column
	private String isbn;

	@Lob
	@Column
	private String description;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "author_id", referencedColumnName = "id")
	private Author author;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bookstore_id", referencedColumnName = "id")
	private Bookstore bookstore;

}
