import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Fetcher {
    private String pealkiri;
    private String link;
    private String aeg;
    private String artikkel;


    public static void getPostimees() throws IOException {
        String url = "https://postimees.ee";
        org.jsoup.nodes.Document document = Jsoup.connect(url).get();
        //ArrayList<Fetcher>;

        Elements text = document.select(".list-article__url");
        for (org.jsoup.nodes.Element item : text) {
            String pealkiri = item.select(".list-article__headline").text();
            System.out.println(pealkiri);
            String link = item.attr("href");
            System.out.println(link);
            System.out.println("artikli sisu:");

            Document artikkel = Jsoup.connect(item.attr("href")).get();
            String aeg = artikkel.select(".article__publish-date").first().text();
            System.out.println(aeg);
            String artikliSisu = "";
            for (Element tekst: artikkel.select(".article-body__item").select("p")){
                artikliSisu = artikliSisu + tekst.text() + "\n";
            }
            System.out.println(artikliSisu);
            System.out.println();
        }
    }
}
