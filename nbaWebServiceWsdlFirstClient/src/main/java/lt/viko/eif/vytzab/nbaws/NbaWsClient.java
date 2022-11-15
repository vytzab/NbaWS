package lt.viko.eif.vytzab.nbaws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;

import org.apache.fop.apps.FOPException;

import lt.viko.eif.vytzab.nbaws.entities.Nba;
import lt.viko.eif.vytzab.nbaws.menu.Menu;
import lt.viko.eif.vytzab.nbaws.methods.PlayerMethods;
import lt.viko.eif.vytzab.nbaws.methods.RecordMethods;
import lt.viko.eif.vytzab.nbaws.transformers.PojoToXmlConverter;
import lt.viko.eif.vytzab.nbaws.transformers.XmlHtmlConverter;
import lt.viko.eif.vytzab.nbaws.transformers.XmlPdfConverter;
import lt.viko.eif.vytzab.nbaws.utilities.Mapper;
import lt.viko.eif.vytzab.nbaws.utilities.Printer;

public class NbaWsClient {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int option = 9;

		try {
			NbaWsImplService service = new NbaWsImplService(new URL("http://localhost:8080/nbaws/nbaWs?wsdl"));
			NbaPortType port = service.getNbaWsImplPort();

			while (option != 0) {
				Menu.mainMenu();
				option = Integer.parseInt(reader.readLine());
				switch (option) {
				case 1: {
					Menu.viewPlayerMenu();
					GetPlayerRequest getPlayerRequest = new GetPlayerRequest();
					getPlayerRequest.setId(BigInteger.valueOf(Integer.parseInt(reader.readLine())));
					GetPlayerResponse response = port.getPlayer(getPlayerRequest);

					Printer.printPlayer(response.getPlayer());
					break;
				}
				case 2: {
					Menu.viewAllPlayersMenu();
					GetAllPlayersRequest getAllPlayersRequest = new GetAllPlayersRequest();
					GetAllPlayersResponse response = port.getAllPlayers(getAllPlayersRequest);

					for (int i = 0; i < response.getPlayer().size(); i++) {
						System.out.print(i + 1 + ". ");
						Printer.printPlayer(response.getPlayer().get(i));
					}
					break;
				}
				case 3: {
					Menu.addPlayerMenu();
					CreatePlayerRequest createPlayerRequest = new CreatePlayerRequest();
					createPlayerRequest.setPlayer(PlayerMethods.createPlayer());
					CreatePlayerResponse response = port.createPlayer(createPlayerRequest);

					System.out.println(response.isCreatePlayerResult());
					break;
				}
				case 4: {
					Menu.removePlayerMenu();
					DeletePlayerRequest deletePlayerRequest = new DeletePlayerRequest();
					deletePlayerRequest.setId(BigInteger.valueOf(Integer.parseInt(reader.readLine())));
					DeletePlayerResponse response = port.deletePlayer(deletePlayerRequest);

					System.out.println(response.isDeletePlayerResult());
					break;
				}
				case 5: {
					Menu.viewRecordMenu();
					GetRecordRequest getRecordRequest = new GetRecordRequest();
					getRecordRequest.setPlayerId(BigInteger.valueOf(Integer.parseInt(reader.readLine())));
					GetRecordResponse response = port.getRecord(getRecordRequest);

					Printer.printRecord(response.getRecord());
					break;
				}
				case 6: {
					Menu.updateRecordMenu();
					UpdateRecordRequest updateRecordRequest = new UpdateRecordRequest();
					updateRecordRequest.setPlayerId(BigInteger.valueOf(Integer.parseInt(reader.readLine())));
					updateRecordRequest.setRecord(RecordMethods.createRecord());
					UpdateRecordResponse response = port.updateRecord(updateRecordRequest);

					System.out.println(response.isUpdateRecordResult());
					break;
				}
				case 7: {
					Menu.updatePlayerMenu();
					UpdatePlayerRequest updatePlayerRequest = new UpdatePlayerRequest();
					updatePlayerRequest.setPlayer(PlayerMethods.createPlayer());
					UpdatePlayerResponse response = port.updatePlayer(updatePlayerRequest);

					System.out.println(response.isUpdatePlayerResult());
					break;
				}
				case 8: {
					Menu.convertToHtmlMenu();
					GetAllPlayersRequest getAllPlayersRequest = new GetAllPlayersRequest();
					GetAllPlayersResponse response = port.getAllPlayers(getAllPlayersRequest);
					Nba nba = new Nba();
					Mapper.mapPlayers(nba, response);

					try {
						PojoToXmlConverter.transformToXML("src//main//resources//nba.xml", nba);
					} catch (JAXBException e) {
						System.out.println("Error!!! - " + e);
					}

					XmlHtmlConverter.convertToHTML();
					System.out.println("File has been saved in src/main/resources/output");
					break;
				}
				case 9: {
					Menu.convertToPdfMenu();
					GetAllPlayersRequest getAllPlayersRequest = new GetAllPlayersRequest();
					GetAllPlayersResponse response = port.getAllPlayers(getAllPlayersRequest);
					Nba nba = new Nba();
					Mapper.mapPlayers(nba, response);

					try {
						PojoToXmlConverter.transformToXML("src//main//resources//nba.xml", nba);
					} catch (JAXBException e) {
						System.out.println("Error!!! - " + e);
					}

					try {
						XmlPdfConverter.convertToPDF();
					} catch (FOPException | IOException | TransformerException e) {
						System.out.println("Error!!! - " + e);
					}
					System.out.println("File has been saved in src/main/resources/output");
					break;
				}
				case 0: {
					System.out.println("See you soon :)");
					break;
				}
				default: {
					System.out.println("Such option does not exist, please try again.");
					break;
				}
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

}
