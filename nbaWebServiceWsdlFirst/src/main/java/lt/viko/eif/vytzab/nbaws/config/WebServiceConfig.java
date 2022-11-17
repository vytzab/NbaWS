package lt.viko.eif.vytzab.nbaws.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lt.viko.eif.vytzab.nbaws.NbaWsImpl;

/*
 * Class used for configuration of the web service.
*/
@Configuration
public class WebServiceConfig {

	@Autowired
	private Bus bus;

	/*
	 * Creates a web service endpoint to connect to.
	 */
	@Bean
	public Endpoint endpoint() {
		Endpoint endpoint = new EndpointImpl(bus, new NbaWsImpl());
		endpoint.publish("/nbaWs");

		return endpoint;
	}
}