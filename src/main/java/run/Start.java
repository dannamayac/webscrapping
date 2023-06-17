package run;

import providers.ScrapingProvider;
import services.ScrapingService;

public class Start
{
    public static void main(String args[])
    {
        ScrapingService scrapingProvider = new ScrapingService();
        String html = scrapingProvider.getData();
        ScrapingProvider.data(html);
    }
}
