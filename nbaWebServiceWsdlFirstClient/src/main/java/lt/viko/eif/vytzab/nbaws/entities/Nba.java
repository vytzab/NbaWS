package lt.viko.eif.vytzab.nbaws.entities;

import javax.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import lt.viko.eif.vytzab.nbaws.Player;

/**
 * Represents a league of players
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Nba {

	@XmlElementWrapper(name = "players")
	@XmlElement(name = "player")
	private List<Player> players = new ArrayList<>();

	/**
	 * Default constructor without any parameters.
	 */
	public Nba() {

	}

	/**
	 * Returns the list of <Player>.
	 */
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * Sets a list of <Player> for the <Nba> object.
	 */
	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	/**
	 * Adds a player to the list of <Player>.
	 */
	public void addPlayer(Player player) {
		players.add(player);
	}

	/**
	 * Formats and outputs information for the whole league
	 */
	@Override
	public String toString() {
		String organizationString = "";
		organizationString += "Players: \n";
		for (Player player : players) {
			organizationString += player.getFirstName() + " " + player.getLastName() + "\n  Age: " + player.getAge()
					+ "\n  Height: " + player.getHeight() + "\n  Weight: " + player.getWeight() + "\n  Nationality: "
					+ player.getNationality() + "\n  Record: \n\tGames played : " + player.getRecord().getGamesplayed()
					+ "\n\tAll time wins : " + player.getRecord().getWins() + "\n\tAll time wins : "
					+ player.getRecord().getLosses() + "\n  Status: " + player.getStatus() + "\n";
		}
		return organizationString;
	}
}