package com.example.lab6;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Main4Activity extends AppCompatActivity {

    DrawView drawView;
    Button important;
    LinearLayout container;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main4);

        drawView = new DrawView(this);
        container = (LinearLayout) findViewById(R.id.conteiner4);
        container.addView(drawView);
        important = (Button) findViewById(R.id.part5);
    }

    public void goToPart5(View view) {
        Intent intent = new Intent(this, Main5Activity.class);
        startActivity(intent);
    }


    class DrawView extends View {

        Paint p;
        RectF rectf;
        float[] points;
        float[] points1;

        public DrawView(Context context) {
            super(context);
            p = new Paint();
            rectf = new RectF(700, 100, 800, 150);
            points = new float[]{100, 50, 150, 100, 150, 200, 50, 200, 50, 100};
            points1 = new float[]{300, 200, 600, 200, 300, 300, 600, 300, 400, 100, 400, 400, 500, 100, 500, 400};
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            p.setColor(Color.RED);
            p.setStrokeWidth(10);

            // рисуем точки их массива points
            canvas.drawPoints(points, p);

            // рисуем линии по точкам из массива points1
            canvas.drawLines(points1, p);

            // перенастраиваем кисть на зеленый цвет
            p.setColor(Color.GREEN);

            // рисуем закругленный прямоугольник по координатам из rectf
            // радиусы закругления = 20
            canvas.drawRoundRect(rectf, 20, 20, p);

            // смещаем коорднаты rectf на 150 вниз
            rectf.offset(0, 150);
            // рисуем овал внутри прямоугольника rectf
            canvas.drawOval(rectf, p);

            // смещаем rectf в (900,100) (левая верхняя точка)
            rectf.offsetTo(900, 100);
            // увеличиваем rectf по вертикали на 25 вниз и вверх
            rectf.inset(0, -25);
            // рисуем дугу внутри прямоугольника rectf
            // с началом в 90, и длиной 270
            // соединение крайних точек через центр
            canvas.drawArc(rectf, 90, 270, true, p);

            // смещаем коорднаты rectf на 150 вниз
            rectf.offset(0, 150);
            // рисуем дугу внутри прямоугольника rectf
            // с началом в 90, и длиной 270
            // соединение крайних точек напрямую
            canvas.drawArc(rectf, 90, 270, false, p);

            // перенастраиваем кисть на толщину линии = 3
            p.setStrokeWidth(3);
            // рисуем линию (150,450) - (150,600)
            canvas.drawLine(150, 450, 150, 600, p);

            // перенастраиваем кисть на синий цвет
            p.setColor(Color.BLUE);

            // настраиваем размер текста = 30
            p.setTextSize(30);
            // рисуем текст в точке (150,500)
            canvas.drawText("text left", 150, 500, p);

            // настраиваем выравнивание текста на центр
            p.setTextAlign(Paint.Align.CENTER);
            // рисуем текст в точке (150,525)
            canvas.drawText("text center", 150, 525, p);

            // настраиваем выравнивание текста на левое
            p.setTextAlign(Paint.Align.RIGHT);
            // рисуем текст в точке (150,550)
            canvas.drawText("text right", 150, 550, p);
        }
    }

}
