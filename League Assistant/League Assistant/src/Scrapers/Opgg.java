package Scrapers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Opgg {

    Document doc;
    List<String> parsedLinks = new ArrayList<String>();

    public Opgg() throws  IOException{

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
        return this.parsedLinks.get(index);

    }

    public String  getOverviewData(int index, String dataType){
        Elements overviewTitles = doc.select(".champion-overview__header");
        Elements pickRate = doc.select(".champion-overview__stats.champion-overview__stats--pick");
        Elements winRate = doc.select(".champion-overview__stats.champion-overview__stats--win");

        System.out.println(pickRate.size());

        for(int i = 0; i < pickRate.size() ; i++) {

            System.out.println(pickRate.get(i).text());
        }
        for(Element el : winRate){
            System.out.println(el);
        }

        if(dataType.equalsIgnoreCase("pick")){
            return  pickRate.get(index).text();
        }
        else if(dataType.equalsIgnoreCase("win")){
            return winRate.get(index).text();
        }
        return " ";
    }

    public void connect(String champion, String position) throws IOException{


        doc = Jsoup.connect("http://na.op.gg/champion/" + champion + "/statistics/" + position).get();
    }

}