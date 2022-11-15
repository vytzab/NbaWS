package lt.viko.eif.vytzab.nbaws.transformers;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

public class XmlPdfConverter {

	public static final String RESOURCES_DIR = "src//main//resources//";
	public static final String OUTPUT_DIR = "src//main//resources//output//";

	public static void convertToPDF() throws IOException, FOPException, TransformerException {
		StreamSource xslSource = new StreamSource(RESOURCES_DIR + "//nbaPdf.xsl");
		StreamSource xmlSource = new StreamSource(RESOURCES_DIR + "//nba.xml");
		OutputStream out = new java.io.FileOutputStream(OUTPUT_DIR + "//nba.pdf");

		FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
		FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

		try {
			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(xslSource);
			Result res = new SAXResult(fop.getDefaultHandler());

			transformer.transform(xmlSource, res);
		} finally {
			out.close();
		}
	}

}
