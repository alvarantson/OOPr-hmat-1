import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class TestFetcher {
    public static void main(String[] args) throws Exception {
        ArrayList<Fetcher> asd = Fetcher.getPostimees();
        System.out.println(asd.size());
        System.out.println(asd.get(3).getPealkiri() + " - " + asd.get(3).getAeg());
    }
}
