package lt.viko.eif.vytzab.nbaws.utilities;

import lt.viko.eif.vytzab.nbaws.Player;
import lt.viko.eif.vytzab.nbaws.Record;

public class Printer {

	public static void printPlayer(Player player) {
		System.out.println(player.getFirstName() + " " + player.getLastName());
		System.out.println("Age: " + player.getAge());
		System.out.println("Height: " + player.getHeight());
		System.out.println("Weight: " + player.getWeight());
		System.out.println("Nationality: " + player.getNationality());
		System.out.println("Status: " + player.getStatus());
		printRecord(player.getRecord());
	}

	public static void printRecord(Record record) {
		System.out.println("Games played: " + record.getGamesplayed());
		System.out.println("Wins: " + record.getWins() + " | Losses: " + record.getLosses());
	}

}
