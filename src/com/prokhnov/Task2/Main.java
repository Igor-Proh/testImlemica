package com.prokhnov.Task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new FileReader("src/com/prokhnov/Task2/inputTask2.txt"));
        int testsQuantity = Integer.parseInt(reader.readLine());

        for (int testIndex = 0; testIndex < testsQuantity; testIndex++) {

            List<String> citiesId = new ArrayList<>(10000);
            int citiesQuantity = Integer.parseInt(reader.readLine());

            Matrix matrix = new Matrix(citiesQuantity);

            for (int cityIndex = 0; cityIndex < citiesQuantity; cityIndex++) {

                String cityName = reader.readLine();
                citiesId.add(cityName);

                int neighboursQuantity = Integer.parseInt(reader.readLine());

                //Add weight of way for neighbours
                for (int neighbourIndex = 0; neighbourIndex < neighboursQuantity; neighbourIndex++) {

                    String[] idAndCost = reader.readLine().split(" ");
                    int neighbourCityId = Integer.parseInt(idAndCost[0]);
                    int neighbourWayCost = Integer.parseInt(idAndCost[1]);
                    matrix.setWeightOfWay(cityIndex, neighbourCityId, neighbourWayCost);

                }
            }

            int quantityOfWays = Integer.parseInt(reader.readLine());

            for (int waysId = 0; waysId < quantityOfWays; waysId++) {

                String[] cities = reader.readLine().split(" ");
                String start = cities[0];
                String distinct = cities[1];

                // Get cheapest way with Dijkstra algorithm
                Dijkstra.dijkstra(matrix.getMatrix(), citiesId.indexOf(start), citiesId.indexOf(distinct));
            }

        }

        reader.close();
    }
}
