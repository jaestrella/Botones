package com.iesvirgendelcarmen.dam.botones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Botones extends AppCompatActivity implements View.OnLongClickListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private int numero=0;
    private TextView tn;
    private LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botones);

        mainLayout =(LinearLayout) findViewById(R.id.mainLayout);

        ToggleButton tBtn=(ToggleButton) findViewById(R.id.tBtn);
        tBtn.setOnCheckedChangeListener(this);
        /*tBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    mainLayout.setBackgroundColor(getResources().getColor(R.color.colorOn));
                }else
                    mainLayout.setBackgroundColor(getResources().getColor(R.color.colorOFF));
            }
        });*/

        tn=(TextView)findViewById(R.id.numero);
        tn.setText(numero+"");

        Button btnInc=(Button)findViewById(R.id.inc);
        Button btnDec=(Button)findViewById(R.id.dec);


        btnInc.setOnClickListener(this);
        btnDec.setOnClickListener(this);
        btnInc.setOnLongClickListener(this);
        btnDec.setOnLongClickListener(this);


///////////////////////////////////////////////////////////////////////////////////////////////
        /*
        btnInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero++;
                tn.setText(numero+"");
            }
        });

        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numero > 0)
                    numero--;
                tn.setText(numero+"");
            }
        });
        */
///////////////////////////////////////////////////////////////////////////////////////////////
    }
    @Override
    public boolean onLongClick(View view) {
        switch (view.getId()){
            case R.id.inc:
                numero +=10;
                tn.setText(numero+"");
                return true;
            case R.id.dec:
                if (numero > 10)
                    numero-=10;
                tn.setText(numero+"");
                return true;

        }
        return false;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.inc:
                numero++;
                tn.setText(numero+"");
                break;
            case R.id.dec:
                if (numero > 0)
                    numero--;
                tn.setText(numero+"");
                break;
        }

    }
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(b) {
            mainLayout.setBackgroundColor(getResources().getColor(R.color.colorOn));
        }else
            mainLayout.setBackgroundColor(getResources().getColor(R.color.colorOFF));
    }
}
