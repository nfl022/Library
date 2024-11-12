package com.nfl.library;

import com.nfl.library.main.Main;
import com.nfl.library.model.BookData;
import com.nfl.library.model.ResultsData;
import com.nfl.library.repository.BookRepository;
import com.nfl.library.service.ConsumeAPI;
import com.nfl.library.service.ConvertData;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.util.Scanner;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.nfl.library.repository")

public class LibraryApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Autowired
	private BookRepository repository;
	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(repository);
		main.showMenu();




	}


	}

