package lt.viko.eif.vytzab.nbaws.transformers;

import java.io.File;
import java.io.StringWriter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XmlHtmlConverter {

	public static final String RESOURCES_DIR = "src//main//resources//";
	public static final String OUTPUT_DIR = "src//main//resources//output//";

	public static void convertToHTML() {
		StreamSource xslSource = new StreamSource(RESOURCES_DIR + "//nbaHtml.xsl");
		StreamSource xmlSource = new StreamSource(RESOURCES_DIR + "//nba.xml");
		StreamResult out = new StreamResult(new File(OUTPUT_DIR + "//nbaHtml.html"));

		StringWriter buffer = new StringWriter();

		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(xslSource);

			transformer.transform(xmlSource, out);

			transformer.transform(xmlSource, new StreamResult(buffer));
//			System.out.println(buffer.toString());
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

}
