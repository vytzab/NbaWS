package lt.viko.eif.vytzab.nbaws.utilities;

import java.math.BigInteger;

import lt.viko.eif.vytzab.nbaws.GetAllPlayersResponse;
import lt.viko.eif.vytzab.nbaws.Player;
import lt.viko.eif.vytzab.nbaws.entities.Nba;

public class Mapper {

	public static void mapPlayers(Nba nba, GetAllPlayersResponse response) {
		
		for (int i = 0; i < response.getPlayer().size(); i++) {
			Player player = new Player();
			player.setId(BigInteger.valueOf(i+1));
			player.setFirstName(response.getPlayer().get(i).getFirstName());
			player.setLastName(response.getPlayer().get(i).getLastName());
			player.setAge(response.getPlayer().get(i).getAge());
			player.setHeight(response.getPlayer().get(i).getHeight());
			player.setWeight(response.getPlayer().get(i).getWeight());
			player.setNationality(response.getPlayer().get(i).getNationality());
			player.setStatus(response.getPlayer().get(i).getStatus());
			player.setRecord(response.getPlayer().get(i).getRecord());
					
			nba.addPlayer(player);
		}
	}

}
