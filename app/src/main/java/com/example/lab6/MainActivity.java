package com.example.lab6;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    DrawView drawView;
    Button important;
    LinearLayout container;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        drawView = new DrawView(this);
        container = (LinearLayout) findViewById(R.id.conteiner);
        container.addView(drawView);
        important = (Button) findViewById(R.id.part2);
    }

    public void goToPart2(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    public class DrawView extends View {

        public DrawView(Context context) {
            super(context);
        }

        @Override
        public void onDraw(Canvas canvas) {
            canvas.drawColor(Color.GREEN);
        }

    }
}
