package com.example.cachepractice.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SimpleBookRepository implements BookRepository {
	@Override
	@Cacheable( "books" )
	public Book getByIsbn( String isbn ) {
		// 캐싱을 이용한다면 아래 강제 딜레이 로직이 실행되지 않음
		this.simulateSlowService();
		return new Book( isbn, "Some Book" );
	}

	private void simulateSlowService() {
		try {
			long time = 3000L;
			Thread.sleep( time );
		} catch ( InterruptedException e ) {
			throw new IllegalStateException( e );
		}
	}
}
