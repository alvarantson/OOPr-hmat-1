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

        String url = "https://sonaveeb.ee/search/est-est/detail/" + searchword + "/1?ieuser=false";
        List<String> result = new ArrayList<>();

        Document document = Jsoup.connect(url).get();
        Elements otherWords = document.select(".btn btn-sm ml-1"); // doesnt work
        Elements homonyms = document.select(".homonym-header");

        result.addAll(findWordForms(searchword));

        for (Element otherWord : otherWords) {
            result.addAll(findWordForms(otherWord.text()));
        }

        for (Element homonym : homonyms) {
            result.addAll(findWordForms(homonym.text()));
        }

        return result;

    }

    public static List<String> findWordForms(String baseWord) throws IOException {

        String url = "https://sonaveeb.ee/search/est-est/detail/" + baseWord + "/1?ieuser=false";
        List<String> result = new ArrayList<>();

        Document document = Jsoup.connect(url).get();
        Elements elements = document.select(".morph-word"); // doesnt work
        for (Element element : elements) {
            result.add(element.text());
        }

        return result;

    }

}
