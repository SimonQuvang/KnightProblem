package com.company;

public class Main {

    public static void main(String args[]){

        //Just a main fuction to test out the code while programming
        Driver driver = new Driver();

        System.out.println(driver.minimum_steps(8, 8, 4, 4, 3, 2));
        System.out.println(driver.minimum_steps(292, 293, 23, 23, 48,59));
        System.out.println(driver.minimum_steps(5093, 2837, 0, 0, 2839, 1920));
    }
}
