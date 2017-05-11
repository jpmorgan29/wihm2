package com.example.jpmorgan.wihm_223;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView txtDisp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        txtDisp1 = (TextView) findViewById(R.id.txtDisp1);
       // txtDisp2 = (TextView) findViewById(R.id.txtDisp2);
        //final int[] gg = {120,120,110,123,121,111,114,117,114,114,122,123};
        final String[] wc1 = {"122", "142", "144", "154", "160", "154", "155","153","152","148","143","142","170","163","162","send nudes"};
        final android.os.Handler handler = new android.os.Handler();
        handler.post(new Runnable() {

            int i = 0;

            @Override
            public void run() {
                //  txtDisp1.setText(gg[i]);
                txtDisp1.setText(wc1[i]);
               // txtDisp2.setText(wc2[i]);
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
    public void ClickForGraph(View v){
        Intent i_ClickForGraph= new Intent(getApplicationContext(), GraphActivity.class);
        startActivity(i_ClickForGraph);

    }

}
