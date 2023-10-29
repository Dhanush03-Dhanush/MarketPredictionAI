import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class ProcessAPI {
    public ArrayList<Double> getAPI() throws IOException {
        Scanner scanner = new Scanner(new File("API_Key.txt"));
        String apiKey = scanner.nextLine();

        Scanner scanner1 = new Scanner(System.in);
        String symbol = "";
        System.out.print("Enter Asset Symbol: ");
        symbol = scanner1.nextLine();

        // Construct the API URL
        String apiUrl = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + symbol +
                "&apikey=" + apiKey;

        // Create an HTTP connection and make the request
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Read the response
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;

        ArrayList<Double> closingPrices = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            if (line.contains("4. close")) {
                String[] parts = line.split(": ");
                if (parts.length == 2) {
                    String priceString = parts[1].replaceAll(",", "").trim(); // Remove commas and trim
                    double price = Double.parseDouble(priceString.substring(1, priceString.length() - 1));
                    closingPrices.add(price);
                }
            }
        }
        reader.close();
        connection.disconnect();
        return closingPrices;
    }
}
