package com.library.management.service;


import com.library.management.DTO.BookAssignRequest;
import com.library.management.DTO.BookAssignResponse;

import java.util.List;

public interface BookAssignService {

    BookAssignResponse assignBook(BookAssignRequest request);

    List<BookAssignResponse> getAll();

    BookAssignResponse getById(Long id);

    BookAssignResponse update(Long id,BookAssignRequest request);

    String delete(Long id);

    BookAssignResponse returnBook(Long id);
}
