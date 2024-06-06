package com.example.cruddemo.util;

import com.github.javafaker.Faker;

import java.util.Random;

public class randomData {
    private static final Faker FAKER = new Faker();
    private static final Random RANDOM = new Random();

    public static String getRandomFirstName() {
        return FAKER.name().firstName();
    }

    public static String getRandomLastName() {
        return FAKER.name().lastName();
    }

    public static String getRandomEmail(String firstName, String lastName) {
        int randomNumber = RANDOM.nextInt(1000); // This will generate a random number between 0 and 999
        String formattedNumber;
        if (randomNumber < 10) {
            formattedNumber = String.format("%02d", randomNumber);
        } else {
            formattedNumber = String.format("%03d", randomNumber);
        }
        return firstName + "." + lastName + formattedNumber + "@gmail.com";
    }
}
