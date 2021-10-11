package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class CSVBookMetadataExporter extends BookMetadataExporter {
    public BookMetadataFormatter createFormatter() throws ParserConfigurationException, IOException {
        return new CSVBookMetadataFormatter();
    }
}
