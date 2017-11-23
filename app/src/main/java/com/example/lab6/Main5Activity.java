package com.example.lab6;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Main5Activity extends AppCompatActivity {

    DrawView drawView;
    Button important;
    LinearLayout container;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main5);

        drawView = new DrawView(this);
        container = (LinearLayout) findViewById(R.id.conteiner5);
        container.addView(drawView);
        important = (Button) findViewById(R.id.part6);
    }

    public void goToPart6(View view) {
        Intent intent = new Intent(this, Main6Activity.class);
        startActivity(intent);
    }


    class DrawView extends View {

        Paint p;
        Rect rect;
        StringBuilder sb;

        public DrawView(Context context) {
            super(context);
            p = new Paint();
            rect = new Rect(100,200,200,300);
            sb = new StringBuilder();

        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            p.setColor(Color.BLUE);
            p.setStrokeWidth(1);

            p.setTextSize(30);

            // создаем строку с значениями ширины и высоты канвы
            sb.setLength(0);
            sb.append("width = ").append(canvas.getWidth())
                    .append(", height = ").append(canvas.getHeight());
            canvas.drawText(sb.toString(), 100, 100, p);

            // перенастраивам кисть на заливку
            p.setStyle(Paint.Style.FILL);
            canvas.drawRect(rect, p);

            // перенастраивам кисть на контуры
            p.setStyle(Paint.Style.STROKE);
            rect.offset(150, 0);
            canvas.drawRect(rect, p);

            // перенастраивам кисть на заливку + контуры
            p.setStyle(Paint.Style.FILL_AND_STROKE);
            rect.offset(150, 0);
            canvas.drawRect(rect, p);
        }

    }
}
