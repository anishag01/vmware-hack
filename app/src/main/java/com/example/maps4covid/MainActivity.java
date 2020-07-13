package com.example.maps4covid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.ArrayMap;

import java.util.Map;
import java.util.Random;

import ca.hss.heatmaplib.HeatMap;
import ca.hss.heatmaplib.HeatMapMarkerCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HeatMap heatMap = (HeatMap) findViewById(R.id.heatmap);

        heatMap.setMinimum(0.0);
        heatMap.setMaximum(200.0);

        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            HeatMap.DataPoint point = new HeatMap.DataPoint(rand.nextFloat(), rand.nextFloat(), rand.nextDouble() * 100.0);
            heatMap.addData(point);
        }

        //make the colour gradient from pink to yellow
        Map<Float, Integer> colorStops = new ArrayMap<>();
        colorStops.put(0x0.0p0f, 0xffee42f4);
        colorStops.put(0x1.0p0f, 0xffeef442);
        heatMap.setColorStops(colorStops);

        //make the minimum opacity completely transparent
        heatMap.setMinimumOpactity(80);
        //make the maximum opacity 50% transparent
        heatMap.setMaximumOpactity(60);

        //set the radius to 300 pixels.
        heatMap.setRadius(600);

        //set the maximum width to 400px
        heatMap.setMaxDrawingWidth(500);

        //draw a dark violet circle at the location of each data point
        heatMap.setMarkerCallback(new HeatMapMarkerCallback.CircleHeatMapMarker(0xff9400D3));

        heatMap.forceRefresh();


    }
}