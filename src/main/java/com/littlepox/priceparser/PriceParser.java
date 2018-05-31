package com.littlepox.priceparser;

import java.io.*;
import java.util.*;
import org.json.*;

public class PriceParser {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner stdin = new Scanner(System.in);
        int productId = stdin.nextInt();
        stdin.nextLine();
        String content = stdin.nextLine();
        JSONObject obj = new JSONArray(content).getJSONObject(0);
        JSONArray prices = obj.getJSONArray("price");
        try (PrintWriter fout = new PrintWriter(productId + "_prices.csv")) {
            for (int i = 0; i < prices.length(); i++) {
                JSONObject entry = prices.getJSONObject(i);
                fout.printf("%d,%s,%.6f%n", productId, entry.getString("date"), entry.getDouble("value"));
            }
            fout.close();
        }
    }
}