package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public abstract class BookMetadataExporter extends BookCollection {
    public abstract BookMetadataFormatter createFormatter() throws ParserConfigurationException, IOException;
    public void export(PrintStream stream) throws ParserConfigurationException {
        // Please implement this method. You may create additional methods as you see fit.
        BookMetadataFormatter Formatter = null;
        try {
            Formatter = createFormatter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Book> book_list = new ArrayList<Book>(this.books);

        for(int k = 0 ; k < book_list.size(); k+=1){
            Formatter.append(book_list.get(k));
        }
        stream.println(Formatter.getMetadataString());

    }

}
