package lt.viko.eif.vytzab.nbaws;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.cxf.feature.Features;

/*
 * Web Service implementation class.
*/
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class NbaWsImpl implements NbaPortType {
	private static Map<BigInteger, Player> league = new HashMap<BigInteger, Player>();

	public NbaWsImpl() {
	}

	/*
	 * Creates a new player. Returns response, containing a boolean value, depending
	 * on the success of the call.
	 */
	@Override
	public CreatePlayerResponse createPlayer(CreatePlayerRequest request) {
		CreatePlayerResponse response = new CreatePlayerResponse();
		Player player = request.getPlayer();

		if (league.get(player.getId()) != null) {
			response.setCreatePlayerResult(false);
		} else {
			league.put(player.getId(), player);
			response.setCreatePlayerResult(true);
		}

		return response;
	}

	/*
	 * Get a player. Returns response, containing a <Player> object from the league
	 * HashMap.
	 */
	@Override
	public GetPlayerResponse getPlayer(GetPlayerRequest request) {
		GetPlayerResponse response = new GetPlayerResponse();
		BigInteger playerId = request.getId();

		response.setPlayer(league.get(playerId));

		return response;
	}

	/*
	 * Get all players. Returns response, containing all <Player> objects from the
	 * league HashMap.
	 */
	@Override
	public GetAllPlayersResponse getAllPlayers(GetAllPlayersRequest request) {
		GetAllPlayersResponse response = new GetAllPlayersResponse();
		Set<BigInteger> ids = league.keySet();
		for (BigInteger id : ids) {
			response.getPlayer().add(league.get(id));
		}

		return response;
	}

	/*
	 * Delete a player. Returns response, containing a boolean value, depending on
	 * the success of the call.
	 */
	@Override
	public DeletePlayerResponse deletePlayer(DeletePlayerRequest request) {
		DeletePlayerResponse response = new DeletePlayerResponse();
		BigInteger playerId = request.getId();

		if (league.get(playerId) == null) {
			response.setDeletePlayerResult(false);
		} else {
			league.remove(playerId);
			response.setDeletePlayerResult(true);
		}

		return response;
	}

	/*
	 * Updates a player. Returns response, containing a boolean value, depending on
	 * the success of the call.
	 */
	@Override
	public UpdatePlayerResponse updatePlayer(UpdatePlayerRequest request) {
		UpdatePlayerResponse response = new UpdatePlayerResponse();
		Player player = request.getPlayer();

		if (league.get(player.getId()) == null) {
			response.setUpdatePlayerResult(false);
		} else {
			league.remove(player.getId());
			league.put(player.getId(), player);
			response.setUpdatePlayerResult(true);
		}

		return response;
	}

	/*
	 * Get a record. Returns response, containing a <Record> object from the
	 * <Player> object from the league HashMap.
	 */
	@Override
	public GetRecordResponse getRecord(GetRecordRequest request) {
		GetRecordResponse response = new GetRecordResponse();
		BigInteger playerId = request.getPlayerId();

		response.setRecord(league.get(playerId).getRecord());

		return response;
	}

	/*
	 * Updates a record. Returns response, containing a boolean value, depending on
	 * the success of the call.
	 */
	@Override
	public UpdateRecordResponse updateRecord(UpdateRecordRequest request) {
		UpdateRecordResponse response = new UpdateRecordResponse();
		BigInteger playerId = request.getPlayerId();
		Record record = request.getRecord();

		if (league.get(playerId) == null) {
			response.setUpdateRecordResult(false);
		} else {
			league.get(playerId).setRecord(record);
			response.setUpdateRecordResult(true);
		}

		return response;
	}
}