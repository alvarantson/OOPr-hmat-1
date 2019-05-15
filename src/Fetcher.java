import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
/*
public abstract class Fetcher {
    private String pealkiri;
    private String link;
    private String aeg;
    private String artikkel;
    private String portaal;
    private int counter;

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

    public abstract List<Fetcher> getAjaleht();

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
                link = item.attr("href");
                Document artikkel = Jsoup.connect(link).get();
                try {
                    aeg = artikkel.select(".article__publish-date").first().text();
                } catch (Exception e) {
                    aeg = "-";
                }
                artikliSisu = "";
                for (Element tekst : artikkel.select(".article-body__item").select("p")) {
                    artikliSisu = artikliSisu + tekst.text() + "\n";
                }
                tagastus.add(new Fetcher(pealkiri, link, aeg, artikliSisu, "Postimees"));
            } catch (Exception e) {
                continue;
            }
        }
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
                if (link.contains("http")) {
                    continue;
                } else {
                    link = "https://www.ohtuleht.ee" + link;
                }
                Document artikkel = Jsoup.connect(link).get();

                try {
                    aeg = artikkel.select(".details--inner").text();
                } catch (Exception e) {
                    aeg = "-";
                }
                artikliSisu = "";
                artikliSisu = artikliSisu + artikkel.select(".article-main--gallery-title").select(".article-main--content").first().text() + "\n";
                for (Element tekst : artikkel.select(".page-layout--inner").select("p")) {
                    artikliSisu = artikliSisu + tekst.text() + "\n";
                }
                tagastus.add(new Fetcher(pealkiri, link, aeg, artikliSisu, "Ohtuleht"));
            } catch (Exception e) {
                continue;
            }
        }
        return tagastus;
    }
    public static ArrayList<Fetcher> getTelegram() throws IOException, InterruptedException {
        String url = "https://www.telegram.ee/";
        org.jsoup.nodes.Document document = Jsoup.connect(url).get();
        ArrayList<Fetcher> tagastus = new ArrayList<Fetcher>();
        String pealkiri;
        String link;
        String aeg;
        String artikliSisu;
        Elements text = document.select(".grid-item");
        for (Element item : text) {
            pealkiri = item.text();
            link = item.select("a").attr("href");
            Document artikkel = Jsoup.connect(link).get();
            aeg = artikkel.select(".time").text();
            artikliSisu = "";
            int counter = 0;
            for (Element tekst : artikkel.select("p")) {
                counter++;
                if (counter < 4)
                    continue;
                artikliSisu += tekst.text();
            }
            tagastus.add(new Fetcher(pealkiri, link, aeg, artikliSisu, "Telegram"));
        }
        return tagastus;
    }
    public static ArrayList<Fetcher> getElu24() throws IOException, InterruptedException {
        String url = "https://elu24.postimees.ee/";
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
                link = item.attr("href");
                Document artikkel = Jsoup.connect(link).get();
                try {
                    aeg = artikkel.select(".article__publish-date").first().text();
                } catch (Exception e) {
                    aeg = "-";
                }
                artikliSisu = "";
                for (Element tekst : artikkel.select(".article-body__item").select("p")) {
                    artikliSisu = artikliSisu + tekst.text() + "\n";
                }
                tagastus.add(new Fetcher(pealkiri, link, aeg, artikliSisu, "Elu 24"));
            } catch (Exception e) {
                continue;
            }
        }
        return tagastus;
    }
    public static ArrayList<Fetcher> getDelfi() throws IOException, InterruptedException {
        String url = "http://www.delfi.ee/";
        org.jsoup.nodes.Document document = Jsoup.connect(url).get();
        ArrayList<Fetcher> tagastus = new ArrayList<Fetcher>();
        String pealkiri;
        String link;
        String aeg;
        String artikliSisu;
        Elements text = document.select(".headline__title");
        for (org.jsoup.nodes.Element item : text) {
            pealkiri = item.text();
            link = item.select("a").attr("href");
            Document artikkel = Jsoup.connect(link).get();
            aeg = artikkel.select(".article__date").text();
            int counter = 0;
            artikliSisu = "";
            for (Element tekst : artikkel.select(".article__body").select("p")) {
                counter++;
                artikliSisu += tekst.text();
            }
            tagastus.add(new Fetcher(pealkiri, link, aeg, artikliSisu, "Delfi"));
        }
        return tagastus;
    }
    public static ArrayList<Fetcher> getAnneJaStiil() throws IOException, InterruptedException {
        String url = "https://annestiil.delfi.ee/";
        org.jsoup.nodes.Document document = Jsoup.connect(url).get();
        ArrayList<Fetcher> tagastus = new ArrayList<Fetcher>();
        String pealkiri;
        String link;
        String aeg;
        String artikliSisu;
        Elements text = document.select(".headline__title");
        for (org.jsoup.nodes.Element item : text) {
            pealkiri = item.text();
            link = item.select("a").attr("href");
            Document artikkel = Jsoup.connect(link).get();
            aeg = artikkel.select(".article__date").text();
            int counter = 0;
            artikliSisu = "";
            for (Element tekst : artikkel.select(".article__body").select("p")) {
                counter++;
                artikliSisu += tekst.text();
            }
            tagastus.add(new Fetcher(pealkiri, link, aeg, artikliSisu, "Anne ja Stiil"));
        }
        return tagastus;
    }
    public static ArrayList<Fetcher> getKroonika() throws IOException, InterruptedException {
        String url = "https://kroonika.delfi.ee/";
        org.jsoup.nodes.Document document = Jsoup.connect(url).get();
        ArrayList<Fetcher> tagastus = new ArrayList<Fetcher>();
        String pealkiri;
        String link;
        String aeg;
        String artikliSisu;
        Elements text = document.select(".headline__title");
        for (org.jsoup.nodes.Element item : text) {
            pealkiri = item.text();
            link = item.select("a").attr("href");
            Document artikkel = Jsoup.connect(link).get();
            aeg = artikkel.select(".article__date").text();
            int counter = 0;
            artikliSisu = "";
            for (Element tekst : artikkel.select(".article__body").select("p")) {
                counter++;
                artikliSisu += tekst.text();
            }
            tagastus.add(new Fetcher(pealkiri, link, aeg, artikliSisu, "Kroonika"));
        }
        return tagastus;
    }


*/