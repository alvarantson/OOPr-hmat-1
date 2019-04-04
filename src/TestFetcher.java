import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class TestFetcher {
    public static void main(String[] args) throws Exception {
        //System.out.println(Fetcher.getKroonika());
        //System.out.println(Fetcher.getKroonika().size());
        System.out.println(Eki.findAllWords("tee"));
    }
}
