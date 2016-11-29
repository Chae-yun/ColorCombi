package com.example.lg.colorcombi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.larswerkman.holocolorpicker.ColorPicker;

public class MainActivity extends Activity implements OnClickListener {

    private final static int COLOR_ACTIVITY = 1;

    int color1;
    int color2;
    int color3;
    int color4;
    Button colorBtn1;
    Button colorBtn2;
    Button colorBtn3;
    Button colorBtn4;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorBtn1 = (Button)findViewById(R.id.color_btn1);
        colorBtn2 = (Button)findViewById(R.id.color_btn2);
        colorBtn3 = (Button)findViewById(R.id.color_btn3);
        colorBtn4 = (Button)findViewById(R.id.color_btn4);

        colorBtn1.setOnClickListener(this);
        colorBtn2.setOnClickListener(this);
        colorBtn3.setOnClickListener(this);
        colorBtn4.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if(requestCode == COLOR_ACTIVITY){
                String btn=intent.getStringExtra("btn");
                if(btn.equals("1")) {
                    color1 = data.getIntExtra("color", 0);
                    colorBtn1.setBackgroundColor(color1);
                }
                if(btn.equals("2")) {
                    color2 = data.getIntExtra("color", 0);
                    colorBtn2.setBackgroundColor(color2);
                }
                if(btn.equals("3")) {
                    color3 = data.getIntExtra("color", 0);
                    colorBtn3.setBackgroundColor(color3);
                }
                if(btn.equals("4")) {
                    color4 = data.getIntExtra("color", 0);
                    colorBtn4.setBackgroundColor(color4);
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.color_btn1:
                intent = new Intent(MainActivity.this, ColorActivity.class);
                if(color1 != 0){
                    intent.putExtra("oldColor",color1);
                }
                intent.putExtra("btn","1");
                startActivityForResult(intent, COLOR_ACTIVITY);

                break;
            case R.id.color_btn2:
                intent = new Intent(MainActivity.this, ColorActivity.class);
                if(color2 != 0){
                    intent.putExtra("oldColor",color2);
                }
                intent.putExtra("btn","2");
                startActivityForResult(intent, COLOR_ACTIVITY);

                break;
            case R.id.color_btn3:
                intent = new Intent(MainActivity.this, ColorActivity.class);
                if(color3 != 0){
                    intent.putExtra("oldColor",color3);
                }
                intent.putExtra("btn","3");
                startActivityForResult(intent, COLOR_ACTIVITY);

                break;
            case R.id.color_btn4:
                intent = new Intent(MainActivity.this, ColorActivity.class);
                if(color4 != 0){
                    intent.putExtra("oldColor",color4);
                }
                intent.putExtra("btn","4");
                startActivityForResult(intent, COLOR_ACTIVITY);

                break;
        }
    }
}
