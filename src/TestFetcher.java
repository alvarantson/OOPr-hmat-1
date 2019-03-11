import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestFetcher {
    public static void main(String[] args) throws Exception {
        String url = "https://postimees.ee";
        Document document = Jsoup.connect(url).get();

        Elements text = document.select(".list-article__headline");
        for (Element item:text){
            System.out.println(item.text());
        }

    }
}
