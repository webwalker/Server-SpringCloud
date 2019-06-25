package com.xujian.cache.repository;

public interface BookRepository {

    Book getByIsbn(String isbn);

}