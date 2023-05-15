package com.example.cachepractice.cache;

public interface BookRepository {
	Book getByIsbn( String isbn );
}
