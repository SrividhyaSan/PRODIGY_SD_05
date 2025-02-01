package webscraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class EcommerceScraper {
    public static void main(String[] args) {
        String url = "https://www.example.com/products"; // Replace with actual e-commerce website

        try {
            // Fetch HTML content from the website
            Document document = Jsoup.connect(url).get();

            // Select product details using CSS selectors (Modify based on website structure)
            Elements products = document.select(".product");  // Modify CSS class as per website
            FileWriter csvWriter = new FileWriter("products.csv");
            csvWriter.append("Product Name,Price,Rating\n");

            for (Element product : products) {
                String name = product.select(".product-title").text(); // Modify selector
                String price = product.select(".product-price").text(); // Modify selector
                String rating = product.select(".product-rating").text(); // Modify selector

                csvWriter.append(name).append(",").append(price).append(",").append(rating).append("\n");
            }

            csvWriter.flush();
            csvWriter.close();
            System.out.println("Scraped data saved to products.csv successfully!");

        } catch (IOException e) {
            System.out.println("Error fetching data: " + e.getMessage());
        }
    }
}
