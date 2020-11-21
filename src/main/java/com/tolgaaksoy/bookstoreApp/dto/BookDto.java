package com.tolgaaksoy.bookstoreApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Long Id;
    private String bookName;
    private String bookSubName;
    private String bookSeriesName;
    private String isbn;
    private String description;
    private Long authorid;
    private Long bookstoreid;
}
