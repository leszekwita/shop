package com.radzik.michal.shop;

import com.hazelcast.config.Config;
import com.opencsv.CSVWriter;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.*;

@SpringBootApplication
//@EnableSwagger2
@EnableJpaAuditing
@EnableCaching
@EnableBatchProcessing
@EnableScheduling
@EnableJpaRepositories
public class ShopApplication {

	public static void main(String[] args) throws IOException {
		File file = new File("C://Users//Michal//Desktop//output.csv");
		try {
			FileWriter output = new FileWriter(file);
			CSVWriter write = new CSVWriter(output);

			// Header column value
			String[] header = { "name", "price", "amount"};
			write.writeNext(header);
			// Value
			for (int i = 0; i < 10000; i++) {


			String[] data1 = { "First Name"+ i, String.valueOf(i), String.valueOf(i) };
			write.writeNext(data1);

			}
			write.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		SpringApplication.run(ShopApplication.class, args);
	}


	}


