package com.alfidotech.wordcounter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {

	public int countWord(String str) {
		int wordCount = 0;

		// Split the string into words
		String[] words = str.split(" ");

		// Count the number of words
		for (String word : words) {
			wordCount++;
		}
		return wordCount;

	}

	public double avgWordLength(String str) {

		// Split the string into words
		String[] words = str.split(" ");

		int totalCharacters = 0;
		for (String word : words) {
			totalCharacters += word.length();
		}

		// Calculate the average word length
		double averageWordLength = (double) totalCharacters / words.length;

		return averageWordLength;

	}

	public Map<String, Integer> WordFrequency(String str) {

		Map<String, Integer> wordFrequencyMap = new HashMap<>();

		// Split the string into words
		String[] words = str.split(" ");

		// Iterate over the words and count their frequency
		for (String word : words) {
			if (wordFrequencyMap.containsKey(word)) {
				wordFrequencyMap.put(word, wordFrequencyMap.get(word) + 1);
			} else {
				wordFrequencyMap.put(word, 1);
			}
		}

		return wordFrequencyMap;

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("                             :: Count the words ::");
		System.out.println("Input the String to count words,average word length and frequency of each word ");
		System.out.print("Enter the String : ");
		String str = sc.nextLine();

		WordCounter wc = new WordCounter();

		// Print the word count
		System.out.println("The number of words is: " + wc.countWord(str));

		// Print the average word length
		System.out.println("The average word length is " + wc.avgWordLength(str));

		// Print the word frequency
		Map<String, Integer> wordFrequencyMap = wc.WordFrequency(str);
		System.out.println("\nFrequency of each word :");
		for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

	}

}
