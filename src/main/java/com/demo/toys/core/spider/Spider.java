package com.demo.toys.core.spider;

import com.demo.toys.core.spider.domain.ItemDO;
import com.google.common.collect.Sets;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/**
 * Created by Kavinal on 2017/2/14.
 */
public  class Spider {
    private String url;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private Document fetchDocumentFromUrl(String url) throws IOException {
        return Jsoup.connect(url).userAgent("Mozilla").timeout(2000).get();
    }
    private  Set<ItemDO> parseSinglePage(Document document) throws ParseException {
        Elements elements = document.select("div#content tbody tr");
        Set<ItemDO> set = Sets.newHashSet();
        for(Element el : elements){
            if(isLightDoc(el)){
                ItemDO item = new ItemDO();
                String title = parseTitle(el);
                String url = "https://bbs.hupu.com"+parseUrl(el);
                Date postDate = parsePostDate(el);
                item.setPostTime(postDate);
                item.setTitle(title);
                item.setUrl(url);
                set.add(item);
            }
        }
        return set;
    }

    public Set<ItemDO> praseAllPages(String baseUrl) throws IOException, ParseException {
        Set<ItemDO> set = Sets.newHashSet();
        for(int i = 1;i <= 100;i++){
            String url = "";
            if(i != 1)
                url = "-"+i;
            Set<ItemDO> items = parseSinglePage(fetchDocumentFromUrl(baseUrl + url));
            set.addAll(items);
        }
        return set;
    }

    private boolean isLightDoc(Element element){
        return !element.select("td.p_title span.light_r ").isEmpty();
    }

    private String parseTitle(Element element){
        return element.select("td.p_title > a[href]").last().html();
    }
    private String parseUrl(Element element){
        return element.select("td.p_title > a[href]").last().attr("href");
    }
    private Date parsePostDate(Element element) throws ParseException {
        String html = element.select("td.p_author").first().html();
        String [] res = html.split("<br>");
        return sdf.parse(res[res.length - 1]);
    }

    public static void main(String [] args){
        Spider spider = new Spider();
        try {
            Set<ItemDO> set = spider.praseAllPages("https://bbs.hupu.com/bxj");
            set.size();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
