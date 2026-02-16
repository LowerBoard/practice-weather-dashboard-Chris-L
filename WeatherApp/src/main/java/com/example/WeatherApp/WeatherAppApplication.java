package com.example.WeatherApp;

import com.example.WeatherApp.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class WeatherAppApplication implements CommandLineRunner {

    @Autowired
    private WeatherService weatherService;

	public static void main(String[] args) {
		SpringApplication.run(WeatherAppApplication.class, args);
	}
    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("---Weather Dashboard---");
            System.out.println("1. St.Louis,MO");
            System.out.println("2. New York,NY");
            System.out.println("3. Brussels,BE");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        weatherService.displayWeatherForCity("St.Louis,MO");
                        break;
                    case 2:
                        weatherService.displayWeatherForCity("New York,NY");
                        break;
                    case 3:
                        weatherService.displayWeatherForCity("Brussels,BE");
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                        scanner.next();
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
            }
    } while (choice != 4);

        scanner.close();
        System.exit(0);
    }

}
