import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Fetcher {
    private String pealkiri;
    private String link;
    private String aeg;
    private String artikkel;
    private String portaal;
    private boolean trash;

    public Fetcher(String pealkiri, String link, String aeg, String artikkel, String portaal) {
        this.pealkiri = pealkiri;
        this.link = link;
        this.aeg = aeg;
        this.artikkel = artikkel;
        this.portaal = portaal;
    }

    public String getPealkiri() {
        return pealkiri;
    }

    public String getLink() {
        return link;
    }

    public String getAeg() {
        return aeg;
    }

    public String getArtikkel() {
        return artikkel;
    }

    public String getPortaal() {
        return portaal;
    }

    @Override
    public String toString() {
        return "Fetcher{" +
                "pealkiri='" + pealkiri + '\'' +
                ", link='" + link + '\'' +
                ", aeg='" + aeg + '\'' +
                ", artikkel='" + artikkel + '\'' +
                ", portaal='" + portaal + '\'' +
                '}';
    }

    public static ArrayList<Fetcher> getPostimees() throws IOException, InterruptedException {
        String url = "https://postimees.ee";
        org.jsoup.nodes.Document document = Jsoup.connect(url).get();
        ArrayList<Fetcher> tagastus = new ArrayList<Fetcher>();


        String pealkiri;
        String link;
        String aeg;
        String artikliSisu;

        Elements text = document.select(".list-article__url");
        for (org.jsoup.nodes.Element item : text) {
            try {
                pealkiri = item.select(".list-article__headline").text();
                //System.out.println(pealkiri);
                link = item.attr("href");
                //System.out.println(link);
                //System.out.println("artikli sisu:");


                Document artikkel = Jsoup.connect(link).get();
                try {
                    aeg = artikkel.select(".article__publish-date").first().text();
                } catch (Exception e) {
                    aeg = "-";
                }
                //System.out.println(aeg);

                artikliSisu = "";
                for (Element tekst : artikkel.select(".article-body__item").select("p")) {
                    artikliSisu = artikliSisu + tekst.text() + "\n";
                }
                //System.out.println(artikliSisu);
                //System.out.println();

                tagastus.add(new Fetcher(pealkiri, link, aeg, artikliSisu, "Postimees"));
            } catch (Exception e) {
                continue;
            }
        }
        //TimeUnit.SECONDS.sleep(1);
        return tagastus;
    }

    public static ArrayList<Fetcher> getOhtuleht() throws IOException, InterruptedException {
        String url = "https://www.ohtuleht.ee/";
        org.jsoup.nodes.Document document = Jsoup.connect(url).get();
        ArrayList<Fetcher> tagastus = new ArrayList<Fetcher>();
        String pealkiri;
        String link;
        String aeg;
        String artikliSisu;

        Elements text = document.select(".article-unit--title");
        for (Element item : text) {
            try {
                pealkiri = item.select("a").text();
                link = item.select("a").attr("href");

                Document artikkel = Jsoup.connect(link).get();

                try {
                    aeg = artikkel.select(".details--inner").text();
                } catch (Exception e) {
                    aeg = "-";
                }
                artikliSisu = "";
                for (Element tekst : artikkel.select(".article-main--content").select("p")) {
                    artikliSisu = artikliSisu + tekst.text() + "\n";
                }



            } catch (Exception e) {
                continue;
            }
        }


        return tagastus;
    }
}