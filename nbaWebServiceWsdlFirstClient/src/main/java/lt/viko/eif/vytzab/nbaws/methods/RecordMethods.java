package lt.viko.eif.vytzab.nbaws.methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

import lt.viko.eif.vytzab.nbaws.Record;

public class RecordMethods {

	public static Record createRecord() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Record record = new Record();
		System.out.println("Please enter the wins");
		String wins = reader.readLine();
		System.out.println("Please enter the losses");
		String losses = reader.readLine();

		record.setWins(BigInteger.valueOf(Integer.parseInt(wins)));
		record.setLosses(BigInteger.valueOf(Integer.parseInt(losses)));
		record.setGamesplayed(
				BigInteger.valueOf(Integer.parseInt(wins)).add(BigInteger.valueOf(Integer.parseInt(losses))));

		return record;
	}
}
