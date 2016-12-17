package com.example.personal.myapplication;

import android.content.ClipData;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;


/**
 * Created by Sianna-chan on 29/10/2016.
 */
public class DragDrop extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dragdrop);
        findViewById(R.id.img1).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.img2).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.img3).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.img4).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.img5).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.img6).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.img7).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.img8).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.img9).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.img10).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.img11).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.img12).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.img13).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.img14).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.img15).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.img16).setOnTouchListener(new MyTouchListener());



        findViewById(R.id.c1).setOnDragListener(new MyDragListener());
        findViewById(R.id.c2).setOnDragListener(new MyDragListener());
        findViewById(R.id.c3).setOnDragListener(new MyDragListener());
        findViewById(R.id.c4).setOnDragListener(new MyDragListener());
        findViewById(R.id.c5).setOnDragListener(new MyDragListener());
        findViewById(R.id.c6).setOnDragListener(new MyDragListener());
        findViewById(R.id.c7).setOnDragListener(new MyDragListener());
        findViewById(R.id.c8).setOnDragListener(new MyDragListener());
        findViewById(R.id.c9).setOnDragListener(new MyDragListener());
        findViewById(R.id.c10).setOnDragListener(new MyDragListener());
        findViewById(R.id.c11).setOnDragListener(new MyDragListener());
        findViewById(R.id.c12).setOnDragListener(new MyDragListener());
        findViewById(R.id.c13).setOnDragListener(new MyDragListener());
        findViewById(R.id.c14).setOnDragListener(new MyDragListener());
        findViewById(R.id.c15).setOnDragListener(new MyDragListener());
        findViewById(R.id.c16).setOnDragListener(new MyDragListener());




    }

    private class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                        view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);
                return true;
            } else {
                return false;
            }
        }
    }

    private class MyDragListener implements View.OnDragListener {
        Drawable enterShape = getResources().getDrawable(
                R.drawable.shape_droptarget);
        Drawable normalShape = getResources().getDrawable(R.drawable.shape);
        Drawable ShapeFig = getResources().getDrawable(R.drawable.shape1);

       // Context context = getApplicationContext();
      //  CharSequence text = "Hello toast!";
       // int duration = Toast.LENGTH_SHORT;



        @Override
        public boolean onDrag(View v, DragEvent event) {

            int action = event.getAction();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    v.setBackgroundDrawable(enterShape);
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    v.setBackgroundDrawable(normalShape);
                    break;
                case DragEvent.ACTION_DROP:
                    // Dropped, reassign View to ViewGroup
                    View view = (View) event.getLocalState();
                    ViewGroup owner = (ViewGroup) view.getParent();
                    owner.removeView(view);
                    LinearLayout container = (LinearLayout) v;

                    int hijos=container.getChildCount();

                    if (hijos==0) {
                        container.addView(view);
                        view.setVisibility(View.VISIBLE);
                    }if (hijos==1){
                        View view2= container.getChildAt(0);
                        ViewGroup owner2 = (ViewGroup) view2.getParent();
                        owner2.removeView(view2);

                        //Add to new container
                        container.addView(view);
                        view.setVisibility(View.VISIBLE);

                        //Intercambiar fichas.
                        owner.addView(view2);
                    }
                    /*
                    hijos=container.getChildCount();
                    Toast mensaje= mostrarMensaje("sgda: "+Integer.toString(hijos));
                    mensaje.show();*/
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    v.setBackgroundDrawable(normalShape);
                default:
                    break;
            }
            return true;
        }
    }

    public Toast mostrarMensaje(CharSequence text){
        Toast mensaje= Toast.makeText(getApplicationContext(),text, Toast.LENGTH_SHORT);
        return mensaje;
    }
}
