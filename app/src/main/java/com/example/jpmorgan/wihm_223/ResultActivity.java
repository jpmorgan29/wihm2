package com.example.jpmorgan.wihm_223;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Random;

public class ResultActivity extends AppCompatActivity {
    TextView txtDisp1;
    private FirebaseDatabase mFirebaseDatabase;
    DatabaseReference ref;
    private DatabaseReference mFirebaseReference;
    private TextView allUsers;

    private static final Random RANDOM = new Random();
    private LineGraphSeries<DataPoint> series;
    private BarGraphSeries<DataPoint> series2;
    private int lastX = 0;
    private double lastY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // we get graph view instance
        GraphView graph = (GraphView) findViewById(R.id.graph);
        // data
        series = new LineGraphSeries<DataPoint>();
        graph.addSeries(series);
        // customize a little bit viewport
        Viewport viewport = graph.getViewport();
        viewport.setYAxisBoundsManual(true);
        viewport.setMinY(0);
        viewport.setMaxY(100);
        //viewport.setMaxX(200);
        viewport.setScalable(true);
        viewport.setScrollable(true);
        series.setThickness(10);
        series.setColor(Color.BLACK);
        series.setDataPointsRadius(10);
        

        txtDisp1 = (TextView) findViewById(R.id.txtDisp1);
       // txtDisp2 = (TextView) findViewById(R.id.txtDisp2);
        //final int[] gg = {120,120,110,123,121,111,114,117,114,114,122,123};
      
        final String[] wc1 = {"122", "142", "144", "154", "160", "154", "155","153","152","148","143","142","170","163","162","send nudes"};
        final Handler handler = new Handler();
        handler.post(new Runnable() {

            int i = 0;

            @Override
            public void run() {
              //  txtDisp1.setText(wc1[i]);
                i++;
                if (i == wc1.length) {
                    handler.removeCallbacks(this);
                } else {
                    //5 sec
                    handler.postDelayed(this, 1000 * 1);
                }
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        // we're going to simulate real time with thread that append data to the graph
        new Thread(new Runnable() {

            @Override
            public void run() {
                // we add 100 new entries
                for (int i = 0; i < 100; i++) {
                    runOnUiThread(new Runnable() {
                        

                        @Override
                        public void run() {
                            addEntry();
                        }
                    });

                    // sleep to slow down the add of entries
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // manage error ...
                    }
                }
            }
        }).start();
    }

    // add random data to graph
    private void addEntry() {
        lastY = RANDOM.nextDouble() * 100d;
        // here, we choose to display max 10 points on the viewport and we scroll to end
        series.appendData(new DataPoint(lastX++, lastY), true, 100);
        txtDisp1.setText(Double.toString(Math.round(lastY)));
    }


    private void addEventFireBaseListener(TextView allUsers) {
    }

}
