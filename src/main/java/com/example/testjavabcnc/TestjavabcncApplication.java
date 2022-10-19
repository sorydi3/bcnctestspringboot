package com.example.testjavabcnc;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;

import com.example.testjavabcnc.entity.Price;
import com.example.testjavabcnc.repository.EcomerceH2reposiory;

@SpringBootApplication
public class TestjavabcncApplication {
	@Autowired
	private EcomerceH2reposiory ecomerceH2reposiory;
	public static void main(String[] args) {
		SpringApplication.run(TestjavabcncApplication.class, args);
	}
	

	/**
	 * @return the ecomerceH2reposiory
	 */
	@Bean
	public void fillH2database(){
		ecomerceH2reposiory.save(new Price(1, LocalDateTime.of(2020, 06, 14, 10, 00, 00), LocalDateTime.of(2020, 12, 31, 23, 59, 59), 1, 35455, 0, "EUR", 35.50));
		ecomerceH2reposiory.save(new Price(1, LocalDateTime.of(2020, 06, 14, 16, 00, 00), LocalDateTime.of(2020, 06, 14, 18, 30, 00), 2, 35455, 1, "EUR", 25.45));
		ecomerceH2reposiory.save(new Price(1, LocalDateTime.of(2020, 06, 15, 21, 00, 00), LocalDateTime.of(2020, 06, 16, 21, 00, 00), 3, 35455, 1, "EUR", 30.50));
		ecomerceH2reposiory.save(new Price(1, LocalDateTime.of(2020, 06, 15, 10, 00, 00), LocalDateTime.of(2020, 06, 15, 18, 30, 00), 4, 35455, 1, "EUR", 38.95));
		ecomerceH2reposiory.save(new Price(1, LocalDateTime.of(2020, 06, 16, 16, 00, 00), LocalDateTime.of(2020, 12, 31, 23, 59, 59), 1, 35455, 0, "EUR", 38.95));
		ecomerceH2reposiory.save(new Price(1, LocalDateTime.of(2020, 06, 14, 10, 00, 00), LocalDateTime.of(2020, 12, 31, 23, 59, 59), 1, 35455, 0, "EUR", 35.50));
		ecomerceH2reposiory.save(new Price(1, LocalDateTime.of(2020, 06, 14, 16, 00, 00), LocalDateTime.of(2020, 06, 14, 18, 30, 00), 2, 35455, 1, "EUR", 25.45));
		ecomerceH2reposiory.save(new Price(1, LocalDateTime.of(2020, 06, 15, 21, 00, 00), LocalDateTime.of(2020, 06, 16, 21, 00, 00), 3, 35455, 1, "EUR", 30.50));
		ecomerceH2reposiory.save(new Price(1, LocalDateTime.of(2020, 06, 15, 10, 00, 00), LocalDateTime.of(2020, 06, 15, 18, 30, 00), 4, 35455, 1, "EUR", 38.95));
	}

	/**
	 * 
	 * @return
	 * 
	 */
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper(); //
    }
}
