package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public abstract class BookMetadataExporter extends BookCollection {
    BookMetadataFormatter Formatter = null;
    public abstract BookMetadataFormatter createFormatter() throws ParserConfigurationException, IOException;
    public void export(PrintStream stream) throws ParserConfigurationException {
        stream.println(this.Formatter.getMetadataString());
    }
    public void add(Book b){
        if(this.Formatter == null ){
            try {
                Formatter = createFormatter();
            } catch (IOException | ParserConfigurationException e) {
                e.printStackTrace();
            }
        }
        Formatter.append(b);

    }

}
