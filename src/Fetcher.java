import org.jsoup.Jsoup;

import javax.lang.model.util.Elements;
import javax.swing.text.Document;
import javax.swing.text.Element;
import java.io.File;
import java.io.IOException;

public class Fetcher {

    public static void main(String[] args) throws IOException {
        fetch();
    }


    public static void fetch() throws IOException {

        Document doc = (Document) Jsoup.connect("http://www.postimees.ee/").get();
        System.out.println(doc);
    }
}
