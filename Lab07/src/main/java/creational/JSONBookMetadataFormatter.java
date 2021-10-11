package creational;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.io.IOException;
import java.io.StringWriter;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {

    JSONObject Jbooks;
    JSONArray bookList;

    public JSONBookMetadataFormatter() {
        reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        bookList= new JSONArray();
        Jbooks  =  new JSONObject();
        Jbooks.put("Books",bookList);

        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) {

        this.bookList.add(JSONBookMetadataFormatter.parser(b));
        return this;
    }

    @Override
    public String getMetadataString() {
        return Jbooks.toString();
    }
    private static JSONObject parser(Book book) {

        JSONObject jbook = new JSONObject();
        jbook.put("ISBN",book.getISBN());
        jbook.put("Title",book.getTitle());
        jbook.put("Publisher",book.getPublisher());
        JSONArray  authors = new JSONArray();
        String[] temp =  book.getAuthors();
        for (int j =0 ; j< temp.length;j+=1){
            authors.add(temp[j]);
        }
        jbook.put("Authors",authors);


        return jbook;
    }
}