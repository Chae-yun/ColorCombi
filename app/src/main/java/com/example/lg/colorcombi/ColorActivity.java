package com.example.lg.colorcombi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.larswerkman.holocolorpicker.ColorPicker;
import com.larswerkman.holocolorpicker.OpacityBar;
import com.larswerkman.holocolorpicker.SVBar;
import com.larswerkman.holocolorpicker.SaturationBar;
import com.larswerkman.holocolorpicker.ValueBar;

/**
 * Created by LG on 2016-08-13.
 */
public class ColorActivity extends Activity {
    Intent intent ;
    ColorPicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        intent = getIntent();
        int oldColor = intent.getIntExtra("oldColor", 0);

        picker = (ColorPicker) findViewById(R.id.picker);
        SVBar svBar = (SVBar) findViewById(R.id.svbar);
        OpacityBar opacityBar = (OpacityBar) findViewById(R.id.opacitybar);
        SaturationBar saturationBar = (SaturationBar) findViewById(R.id.saturationbar);
        ValueBar valueBar = (ValueBar) findViewById(R.id.valuebar);

        picker.addSVBar(svBar);
        picker.addOpacityBar(opacityBar);
        picker.addSaturationBar(saturationBar);
        picker.addValueBar(valueBar);

        picker.getColor();

        if(oldColor != 0){
            picker.setOldCenterColor(oldColor);
        }else{
            picker.setOldCenterColor(picker.getColor());
        }
    }

    public void getColor(View view){

        intent.putExtra("color", picker.getColor());
        setResult(RESULT_OK, intent);
        finish();
    }
}
