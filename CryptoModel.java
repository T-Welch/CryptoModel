import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.net.MalformedURLException;
import java.net.URL;
import com.google.gson.*;

public class CryptoModel {
    public final static String POLYGON_API_KEY = "lNnIsZpfQFzjclMQKmfxpNXGFALupHGt";
    static JsonElement jse = null;

    public static URL constructURL(String ticker, int timespanMultiplier, String timespan, String dateRange)
            throws MalformedURLException {
        URL formedURL = new URL("https://api.polygon.io/v2/aggs/ticker/X:"
                + ticker + "/range/"
                + timespanMultiplier + "/"
                + timespan + "/"
                + dateRange
                + "?apiKey=" + POLYGON_API_KEY);
        return formedURL;
    }



    public static JsonElement queryAPI(URL formedURL) {
        
        try {
            // open connection

            InputStream inputStream = formedURL.openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            // pass in result to parser

            jse = new JsonParser().parse(bufferedReader);

            // close stream
            inputStream.close();
            bufferedReader.close();

            //System.out.println("\r");
            //System.out.println(jse);

        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        }
        
        return jse;
    }


    public static double getValueFromJSON(String requestedData) {
        double dataRequested = 0;

        dataRequested = jse.getAsJsonObject().get("results")
        .getAsJsonArray().get(0)
        .getAsJsonObject().get(requestedData).getAsDouble();
        return dataRequested;
    }


    public static double getPeriodATH() {
        // double periodATH = 0;

        // periodATH = jse.getAsJsonObject().get("results")
        // .getAsJsonArray().get(0)
        // .getAsJsonObject().get("h").getAsDouble();
        

        return getValueFromJSON("h");
    }

    public static double getPeriodClose() {
        // double periodClosePrice = 0;

        // periodClosePrice = jse.getAsJsonObject().get("results")
        // .getAsJsonArray().get(0)
        // .getAsJsonObject().get("c").getAsDouble();
        return getValueFromJSON("c");
    }

    public static double getPeriodATL() {
        // double periodATL = 0;
        // periodATL = jse.getAsJsonObject().get("results")
        // .getAsJsonArray().get(0)
        // .getAsJsonObject().get("l").getAsDouble();
        return getValueFromJSON("l");
    }
    public static double getPeriodNumberTransactions() {
        // double periodNumberTransactions = 0;
        // periodNumberTransactions = jse.getAsJsonObject().get("results")
        // .getAsJsonArray().get(0)
        // .getAsJsonObject().get("n").getAsDouble();

        return getValueFromJSON("n");

    }

    public static double getPeriodOpen() {
        return getValueFromJSON("o");
    }
    public static String[] getTickers() throws IOException {
        URL url = new URL(
            "https://api.polygon.io/v3/reference/tickers?market=crypto&active=true&sort=ticker&order=asc&limit=1000&apiKey=lNnIsZpfQFzjclMQKmfxpNXGFALupHGt");

    // open connection

    InputStream inputStream = url.openStream();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

    // pass in result to parser

    JsonElement jse = new JsonParser().parse(bufferedReader);

    // close stream
    inputStream.close();
    bufferedReader.close();

    // System.out.println("----------------------------------------------------------------");
    int count = jse.getAsJsonObject().get("count").getAsInt();
    jse = jse.getAsJsonObject().get("results");
    int total = 0;

    for (int i = 0; i < count; i++) {

        String str = jse.getAsJsonArray().get(i).getAsJsonObject().get("currency_symbol").getAsString();
        if (str.equals("USD")) {
            total++;
        }

    }
    int testInt = 0;
    String tickers[] = new String[total];
    for (int i = 0; i < count; i++) {
        String str = jse.getAsJsonArray().get(i).getAsJsonObject().get("currency_symbol").getAsString();
        if (str.equals("USD")) {
            tickers[testInt] = jse.getAsJsonArray().get(i).getAsJsonObject().get("ticker").getAsString();
            testInt++;
        }

    }
    return tickers;
    }

    public static int numberOfTickers() throws IOException {
        URL url = new URL(
            "https://api.polygon.io/v3/reference/tickers?market=crypto&active=true&sort=ticker&order=asc&limit=1000&apiKey=lNnIsZpfQFzjclMQKmfxpNXGFALupHGt");

    // open connection

    InputStream inputStream = url.openStream();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

    // pass in result to parser

    JsonElement jse = new JsonParser().parse(bufferedReader);

    // close stream
    inputStream.close();
    bufferedReader.close();

    // System.out.println("----------------------------------------------------------------");
    int count = jse.getAsJsonObject().get("count").getAsInt();
    jse = jse.getAsJsonObject().get("results");
    int total = 0;

    for (int i = 0; i < count; i++) {

        String str = jse.getAsJsonArray().get(i).getAsJsonObject().get("currency_symbol").getAsString();
        if (str.equals("USD")) {
            total++;
        }
    }

return total;
    }




    public static void main(String[] args) throws MalformedURLException {
        jse = queryAPI(constructURL("BTCUSD", 1, "day", "2022-02-02/2022-02-02"));


        System.out.println("Time period high: $" + getPeriodATH());
        System.out.println("Time period low: $" + getPeriodATL());
        System.out.println("Time period opening price: $" + getPeriodOpen());
        System.out.println("Time period closing price: $" + getPeriodClose());
        System.out.println("Number of transactions in the time period: " + getPeriodNumberTransactions());



    }

}
