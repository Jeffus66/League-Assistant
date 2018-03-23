package Scrapers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class opgg {

    Document doc;
    List<String> parsedLinks = new ArrayList<String>();

    public opgg() throws  IOException{

    }

    public void run() throws IOException{

    }

    public String getOverviewImages(int index) throws IOException{
        Elements img = doc.select(".champion-overview__data").select("img");
        //System.out.println(overviewTitles.get(i).text());

        for(Element el : img) {

            String src = el.absUrl("src");
            //System.out.println(src);

            if(src.contains("spell") ||src.contains("item")){
                this.parsedLinks.add(src);
            }
        }
        for(String url : parsedLinks){
            System.out.println(url);
        }

        return this.parsedLinks.get(index);

    }

    public String getOverviewData(){
        Elements overviewTitles = doc.select(".champion-overview__header");
        Elements overviewData = doc.select(".l-champion-statistics");

        for(int i = 0; i < 2 ; i++) {

            System.out.println(overviewTitles.get(i).text());
        }
        return "a";
    }

    public void connect(String champion, String position) throws IOException{
        this.doc = doc;

        doc = Jsoup.connect("http://na.op.gg/champion/" + champion + "/statistics/" + position).get();
    }

}