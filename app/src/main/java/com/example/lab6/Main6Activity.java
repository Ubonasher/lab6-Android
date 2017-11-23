package com.example.lab6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class Main6Activity extends AppCompatActivity {
    DrawView drawView;
    LinearLayout container;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main6);

        drawView = new DrawView(this);
        container = (LinearLayout) findViewById(R.id.conteiner6);
        container.addView(drawView);
    }

    public class DrawView extends View {
        Paint p;
        public DrawView(Context context) {

            super(context);
            p = new Paint();
        }
        @Override
        public void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            p.setColor(Color.BLUE);
            p.setStrokeWidth(5);

            canvas.drawLine(350, 350, 50, 150, p);
            canvas.drawLine(50, 150, 350, 150, p);
            canvas.drawLine(350, 150, 50, 350, p);
            canvas.drawLine(50, 350, 200, 50, p);
            canvas.drawLine(200, 50, 350, 350, p);
        }
    }
}

