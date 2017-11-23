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

public class Main3Activity extends AppCompatActivity {

    DrawView drawView;
    Button important;
    LinearLayout container;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main3);

        drawView = new DrawView(this);
        container = (LinearLayout) findViewById(R.id.conteiner3);
        container.addView(drawView);
        important = (Button) findViewById(R.id.part4);
    }

    public void goToPart4(View view) {
        Intent intent = new Intent(this, Main4Activity.class);
        startActivity(intent);
    }

    class DrawView extends View {

        Paint p;
        Rect rect;

        public DrawView(Context context) {
            super(context);
            p = new Paint();
            rect = new Rect();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            // заливка канвы цветом
            canvas.drawARGB(80, 102, 204, 255);

            // настройка кисти
            // красный цвет
            p.setColor(Color.RED);
            // толщина линии = 10
            p.setStrokeWidth(10);

            // рисуем точку (50,50)
            canvas.drawPoint(50, 50, p);

            // рисуем линию от (100,100) до (500,50)
            canvas.drawLine(100, 100, 500, 50, p);

            // рисуем круг с центром в (100,200), радиус = 50
            canvas.drawCircle(100, 200, 50, p);

            // рисуем прямоугольник
            // левая верхняя точка (200,150), нижняя правая (400,200)
            canvas.drawRect(200, 150, 400, 200, p);

            // настройка объекта Rect
            // левая верхняя точка (250,300), нижняя правая (350,500)
            rect.set(250, 300, 350, 500);
            // рисуем прямоугольник из объекта rect
            canvas.drawRect(rect, p);
        }

    }
}
