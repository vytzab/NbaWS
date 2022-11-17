package lt.viko.eif.vytzab.nbaws.methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

import lt.viko.eif.vytzab.nbaws.Player;

/*
 * Class for player methods.
*/
public class PlayerMethods {

	/*
	 * Method for user creation, when receiving input from the user through the
	 * command line.
	 */
	public static Player createPlayer() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Player player = new Player();
		System.out.println("Please enter the ID");
		String id = reader.readLine();
		System.out.println("Please enter the first name");
		String fName = reader.readLine();
		System.out.println("Please enter the last name");
		String lName = reader.readLine();
		System.out.println("Please enter the age");
		String age = reader.readLine();
		System.out.println("Please enter the height");
		String height = reader.readLine();
		System.out.println("Please enter the weight");
		String weight = reader.readLine();
		System.out.println("Please enter the nationality");
		String nationality = reader.readLine();
		System.out.println("Please enter the status");
		String status = reader.readLine();

		player.setId(BigInteger.valueOf(Integer.parseInt(id)));
		player.setFirstName(fName);
		player.setLastName(lName);
		player.setAge(age);
		player.setHeight(height);
		player.setWeight(weight);
		player.setNationality(nationality);
		player.setStatus(status);
		player.setRecord(RecordMethods.createRecord());

		return player;
	}

}
