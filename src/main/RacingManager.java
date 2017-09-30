package main;

import java.util.*;

import character.JumperChocobo;
import character.Pikachu;
import character.RunnerChocobo;
import simInterface.ICharacter;
import simInterface.IObstructable;
import provide.Library;
public class RacingManager {

	public static double GOAL = 100.00;
	public static ICharacter characters[];
	public static boolean hasWinner;
	
	
	
	public static double getGoal() {
		return GOAL;
	}

	public static ICharacter[] getCharacters() {
		return characters;
	}

	public static boolean hasWinner() {
		return hasWinner;
	}

	public static void initializeCharacter()
	{
		ICharacter r = new RunnerChocobo(); r.start();
		ICharacter j = new JumperChocobo(); j.start();
		ICharacter p = new Pikachu(); p.start();
		characters = new ICharacter[] {r,j,p}; 
		for(ICharacter crt: characters)
		{
			crt.start();
			printCharacterDistance(crt.getClass().getSimpleName(), crt.getDistance());
		}
	}
	
	public static void sortCharacter()
	{
		Arrays.sort(characters);
	}
	
	public static boolean checkWinner(ICharacter crt)
	{
		if(crt.getDistance() >= GOAL)
		{
			hasWinner = true;
			return true;
		}
		return false;
	}
	
	public static void randomObstructedCharacters()
	{
		int num = provide.Library.randomChance();
		if(num >= 1 &&  num <= 20)
		{
			for(ICharacter crt: characters)
			{
				if(crt instanceof JumperChocobo)
				{
					((JumperChocobo) crt).obstructed();
				}
			}
		}
		if(num >= 21 && num <= 40)
		{
			for(ICharacter crt: characters)
			{
				if(crt instanceof Pikachu)
				{
					((Pikachu) crt).obstructed();
				}
			}
		}
		if(num >= 41 && num <= 60)
		{
			for(ICharacter crt: characters)
			{
				if(crt instanceof JumperChocobo)
				{
					((JumperChocobo) crt).obstructed();
				}
				if(crt instanceof Pikachu)
				{
					((Pikachu) crt).obstructed();
				}
			}
		}
	}
	
	public static void decreaseObstructedDuration()
	{
		for(ICharacter crt: characters)
		{
			if(crt instanceof IObstructable)
			{
				if(((IObstructable) crt).getObstructedDuration() > 0)
				((IObstructable) crt).setObstructedDuration(((IObstructable) crt).getObstructedDuration() - 1);
				else
				((IObstructable) crt).setObstructedDuration(0);
				if(((IObstructable) crt).getObstructedDuration() == 0)
				{
					if(crt instanceof JumperChocobo)
					{
						crt.setSpeed(7.5);
					}
					if(crt instanceof Pikachu)
					{
						crt.setSpeed(4.0);
					}
				}
			}
		}
	}
	
	public static void printRound(int round) {
		System.out.printf("\nRound %d\n", round);
	}

	public static void printCharacterDistance(String characterName, double characterDistance) {
		System.out.printf("- %s distance : %.2f\n", characterName, characterDistance);
	}

	public static void printJumperChocoboPreparingToJump(double jumperChocoboDistance) {
		System.out.printf("- JumperChocobo distance : %.2f and preparing to jump\n", jumperChocoboDistance);
	}

	public static void printJumperChocoboObstructed() {
		System.out.printf("+ JumperChocobo has obstructed > speed down for 2 seconds\n");
	}

	public static void printPikachuObstructed() {
		System.out.printf("+ Pikachu has obstructed > stop running for 1 second\n");
	}

	public static void printTheWinner(String characterName) {
		System.out.printf("\n%s is the WINNER!", characterName);
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Welcome to CHOCOBO RACING.\nThe goal at distance 100 m.\n");
		System.out.println("Press 'any key' to START.");
		kb.nextLine();
		initializeCharacter();
		System.out.printf("Initialized Characters\n");
		int roundCount = 0;
		while(true)
		{
			roundCount++;
			printRound(roundCount);
			sortCharacter();
			decreaseObstructedDuration();
			randomObstructedCharacters();
			boolean hasWinner = false;
			for(ICharacter crt: characters)
			{
				crt.run();
				/*for(ICharacter crt: characters)
				{
					if(crt instanceof RunnerChocobo)
					{
						printCharacterDistance("RunnerChocobo",crt.getDistance());
					}
					if(crt instanceof JumperChocobo)
					{
						printCharacterDistance("JumperChocobo",crt.getDistance());
					}
					if(crt instanceof Pikachu)
					{
						printCharacterDistance("Pikachu",crt.getDistance());
					}
				}*/
				hasWinner = checkWinner(crt);
				if(hasWinner)
				{
					if(crt instanceof RunnerChocobo)
					{
						printTheWinner("RunnerChocobo");
					}
					if(crt instanceof JumperChocobo)
					{
						printTheWinner("JumperChocobo");
					}
					if(crt instanceof Pikachu)
					{
						printTheWinner("Pikachu");
					}
					return;
				}
			}
		}
	}

}
