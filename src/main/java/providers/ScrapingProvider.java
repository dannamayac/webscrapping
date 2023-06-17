package providers;

import entity.Product;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import services.ProductService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScrapingProvider
{

    public static void data(String html)
    {
        Document doc = Jsoup.parse(html);
        Elements elements = doc.select(".js-product-item");
        for (Element element : elements)
        {
            String name = element.selectFirst("h3").getAllElements().text();
            String link = doc.selectFirst(".js-algolia-product-title").getAllElements().attr("href");
            String price = element.selectFirst(".price").getAllElements().text();
            String[] arrayObject = link.split("/");
            String code = arrayObject[arrayObject.length - 1];

            Product product = new Product();
            product.setName(name);
            product.setLink(link);
            product.setCode(code);
            product.setPrice(price);

            try
            {
                new ProductService().save(product);
            }
            catch (SQLException e)
            {
                throw new RuntimeException(e);
            }
            catch (ClassNotFoundException e)
            {
                throw new RuntimeException(e);
            }
        }
    }

}
