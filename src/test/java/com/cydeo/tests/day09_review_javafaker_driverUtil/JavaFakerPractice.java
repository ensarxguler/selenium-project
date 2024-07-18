package com.cydeo.tests.day09_review_javafaker_driverUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {

    @Test
    public void test1() {
        
        // Create a Java Faker object.
        Faker faker = new Faker();
        
        // Print out a random first name using Faker object.
        System.out.println("faker.name().firstName() = " + faker.name().firstName());

        // Print out a random last name using Faker object.
        System.out.println("faker.name().lastName() = " + faker.name().lastName());

        // Print out a random full name using Faker object.
        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        
        // Print out a city.
        System.out.println("faker.address().city() = " + faker.address().city());

        // Print out a zip code.
        System.out.println("faker.address().zipCode() = " + faker.address().zipCode());

        // ----------------------------------------------------------------------------------------------------

        // Print out a random numeral using .numerify() method and (#) hashtags.
        System.out.println("faker.numerify(\"###-###-###\") = " + faker.numerify("###-###-###"));

        // For Turkish IDs:
        System.out.println("faker.numerify(\"###########\") = " + faker.numerify("###########"));

        // For Credit cards:
        System.out.println("faker.numerify(\"####-####-####-####\") = " + faker.numerify("####-####-####-####"));

        // For Turkish Phone numbers:
        System.out.println("faker.numerify(\"+90-5##-###-####\") = " + faker.numerify("+90-5##-###-####"));

        // ----------------------------------------------------------------------------------------------------

        // Print out a random numeral using .letterify() method and (?) question marks.
        System.out.println("faker.letterify(\"?????-?????\") = " + faker.letterify("?????-guler"));
        
        // .bothify() method is used to generate both letter and digits randomly using both (?) questions mark and (#) hashtags.
        System.out.println("faker.bothify(\"###-????-??#?##\") = " + faker.bothify("###-????-??#?##"));
        
        //chuckNorris method is used to create chuckNorris facts.
        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact());

        System.out.println("faker.mukhtar().fact() = " + faker.chuckNorris().fact().replaceAll("Chuck Norris", "Fatma"));

    }

}
