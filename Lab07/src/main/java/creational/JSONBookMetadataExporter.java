package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class JSONBookMetadataExporter extends BookMetadataExporter {
    public BookMetadataFormatter createFormatter() throws ParserConfigurationException ,IOException{
        return new JSONBookMetadataFormatter();
    }
}
