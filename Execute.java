package me.aiyanxu.leetcode;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.util.Cookie;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Created by aiyanxu on 2015/4/24.
 */
public class Execute {
    public static CloseableHttpClient httpClient;
    public static List initial() throws IOException {
        List res = new ArrayList<>();
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getCookieManager().setCookiesEnabled(true);
        HtmlPage currentPage = webClient.getPage("https://leetcode.com/accounts/login/");
        HtmlInput username = currentPage.getHtmlElementById("id_login");
        username.setValueAttribute("aiyanxu");
        HtmlInput password = currentPage.getHtmlElementById("id_password");
        password.setValueAttribute("3p5xNyLTHy0s");
        HtmlButton submit = (HtmlButton)currentPage.getByXPath("//button[@class='btn btn-primary']").get(0);
        submit.click();
        currentPage =webClient.getPage("https://leetcode.com/problemset/algorithms/");
        List<HtmlSpan> spans = (List<HtmlSpan>)currentPage.getByXPath("//td/span[@class='ac']");
        ArrayList<String> problems = new ArrayList<>();
        for (HtmlSpan span : spans){
            HtmlAnchor anchor = (HtmlAnchor)span.getParentNode().getParentNode().getByXPath("td[3]/a").get(0);
            problems.add("https://leetcode.com" + anchor.getHrefAttribute() + "submissions/");
        }
        Set<Cookie> cookies = webClient.getCookieManager().getCookies();
        CookieStore cookieStore = new BasicCookieStore();

        for (Cookie cookie : cookies){
            BasicClientCookie basicClientCookie = new BasicClientCookie(cookie.getName(),cookie.getValue());
            basicClientCookie.setDomain("leetcode.com");
            basicClientCookie.setPath("/");
            cookieStore.addCookie(basicClientCookie);
        }
        res.add(problems);
        res.add(cookieStore);
        return res;
    }

    public static ArrayList<String> getSubmissions(String url) throws IOException {
        ArrayList<String> res = new ArrayList<>();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        String htmlSource = EntityUtils.toString(response.getEntity());
        Document doc = Jsoup.parse(htmlSource);
        Elements elements = doc.select("a.status-accepted");
        for (Element element : elements ){
            res.add(element.attr("href"));
        }
        return res;
    }

    public static String getProgram(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        String htmlSource = EntityUtils.toString(response.getEntity());
        Document doc = Jsoup.parse(htmlSource);
        String title = doc.select("h4 a.inline-wrap").first().text();

        String[] lines = htmlSource.split("\n");
        for (String line : lines){
            if (line.toLowerCase().contains("class solution") && line.toLowerCase().contains("scope")) {
                return title+" => "+line;
            }
        }
        return "";
    }
    public static void main(String args[]) throws IOException, InterruptedException, ExecutionException {
        ArrayList<String> problems = (ArrayList<String>) Execute.initial().get(0);
        CookieStore cookieStore = (CookieStore) Execute.initial().get(1);
        Execute.httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        ArrayList<Callable<ArrayList<String>>> partitions = new ArrayList<>();
        for (String sub : problems){
            partitions.add(new Callable<ArrayList<String>>() {
                @Override
                public ArrayList<String> call() throws Exception {
                    return Execute.getSubmissions(sub);
                }
            });
        }
        ExecutorService executorPool = Executors.newFixedThreadPool(40);
        List<Future<ArrayList<String>>> tmp = executorPool.invokeAll(partitions,10000, TimeUnit.SECONDS);
        ArrayList<String> result = new ArrayList<>();
        for (Future<ArrayList<String>> subs : tmp){
            for (String sub : subs.get()){
                result.add("https://leetcode.com"+sub);
            }
        }
        ArrayList<Callable<String>> partitions2 = new ArrayList<>();
        for (String url : result){
            partitions2.add(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return Execute.getProgram(url);
                }
            });
        }
        List<Future<String>> tmp2 = executorPool.invokeAll(partitions2,10000, TimeUnit.SECONDS);
        ArrayList<String> finalResult = new ArrayList<>();
        for (Future<String> res : tmp2){
                finalResult.add(res.get());
        }
        executorPool.shutdown();
        System.out.println(finalResult);
        StringBuilder sb = new StringBuilder();
        for (String str : finalResult){
            sb.append(str+"\n");
        }
        FileWriter f = new FileWriter("result.txt");
        f.write(sb.toString());
        f.close();
    }
}
