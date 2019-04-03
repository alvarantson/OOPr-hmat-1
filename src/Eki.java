import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Eki {

    /*
    public static String findBaseWords(String searchword) throws IOException {
        String url = "https://sonaveeb.ee/search/est-est/detail/" + searchword + "/1?ieuser=false";
        String baseWord;

        Document document = Jsoup.connect(url).get();
        Elements elements = document.select(".homonym-name");
        for (Element element : elements) {

        }
        return baseWord; // kui ei leia midagi, tagastab ""
    }
*/

    public static List<String> findAllWords(String searchword) throws IOException {
        List<String> result = new ArrayList<>();
        String url = "https://sonaveeb.ee/search/est-est/detail/" + searchword + "/1?ieuser=false";

        Document document = Jsoup.connect(url).get();
        Elements otherWords = document.select(".btn btn-sm ml-1");
        Elements homonyms = document.select(".homonym-header");

        for (Element otherWord : otherWords) {
        }

        for (Element homonym : homonyms) {

        }

        return result;
    }

    public static List<String> findWordForms(String baseWord) throws IOException {
        List<String> result = new ArrayList<>();

        return result;
    }
}
