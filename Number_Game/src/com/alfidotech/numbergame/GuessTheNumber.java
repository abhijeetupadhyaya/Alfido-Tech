
package com.alfidotech.numbergame;

import java.util.Scanner;

public class GuessTheNumber {

	public void guessTheNumber() {

		Scanner sc = new Scanner(System.in);
		int randNum = (int) (Math.random() * 100);
		int ele = 0;
		int count = 0;

		while (ele != randNum) {
			System.out.println("Enter a number between 1 to 100 to guess :");
			ele = sc.nextInt();
			count++;
			if (ele > randNum && ele <= 100) {

				System.out.println("You have entered greater than the actual number.");
			} else if (ele < randNum && ele >= 0) {
				System.out.println("You have entered Smaller than the actual number.");
			} else if (ele == randNum) {
				System.out.println("Congratulations !!! You have guessed the secret number.");
			} else {
				System.out.println("Please enter number between 1 to 100.");
			}
		}
		System.out.println("You have guessed the number in " + count + " attempts and the secret number is " + randNum+" .");

	}

	public static void main(String[] args) {

		System.out.println("      :: Guess the number ::       ");
		new GuessTheNumber().guessTheNumber();
	}

}
