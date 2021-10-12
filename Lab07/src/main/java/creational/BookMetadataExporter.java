package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BookMetadataExporter extends BookCollection {
    BookMetadataFormatter Formatter = null;
    public abstract BookMetadataFormatter createFormatter() throws ParserConfigurationException, IOException;
    public void export(PrintStream stream) throws ParserConfigurationException {
        try {
            Formatter = createFormatter();
        } catch (IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        Iterator<Book> list_book = this.books.iterator();
        while(list_book.hasNext()){
            this.Formatter.append(list_book.next());
        }
        stream.println(this.Formatter.getMetadataString());
    }

}
