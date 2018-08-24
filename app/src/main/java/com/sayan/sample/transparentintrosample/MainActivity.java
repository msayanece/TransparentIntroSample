package com.sayan.sample.transparentintrosample;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import outlander.showcaseview.ShowcaseViewBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        standardShowCase();
        customShowCase();
    }

    private void customShowCase() {
        TextView textHello = findViewById(R.id.button);
        ShowcaseViewBuilder showcaseBuilder = ShowcaseViewBuilder.init(this);
        showcaseBuilder.setBackgroundOverlayColor(getResources().getColor(R.color.colorPrimaryDark));
        showcaseBuilder.setHideOnTouchOutside(true);
        showcaseBuilder.setRingColor(getResources().getColor(R.color.colorPrimaryHighlight));
        showcaseBuilder.setRingWidth(getTargetRingWidth(textHello));
        showcaseBuilder.setTargetView(textHello);
        showcaseBuilder.setAlpha(0.3f);
        showcaseBuilder.setPadding(10, 10, 10, 10);
        showcaseBuilder.addCustomView(R.layout.tutorial_layout);
        TextView textViewTitle = showcaseBuilder.getRootView().findViewById(R.id.textViewTitle);
        TextView textViewDescription = showcaseBuilder.getRootView().findViewById(R.id.textViewDescription);
        textViewTitle.setText("asdasdsdasdsasaadsdsasdsad");
        textViewDescription.setText("asdsahgdahghadshads afsfahsfajfjasjsdajdsa fsajsfajsdajhasdhsdagh sadhasdhsdjsdajsda");
        showcaseBuilder.show();
    }

    private int getTargetRingWidth(View view) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (width == height){
            return width + 10;
        }else if (width > height){
            return width + 10;
        }else {
            return height + 10;
        }
    }

//    private void standardShowCase() {
//        Target targetHello = new ViewTarget(R.id.textViewHello, this);
//        TextPaint textPaint = new TextPaint();
//        textPaint.setColor(Color.RED);
//        textPaint.setTextSize(50);
//        ShowcaseView.Builder showcaseViewBuilder = new ShowcaseView.Builder(this, true)
//                .setTarget(targetHello)
//                .setContentTitle("This is the hello world text")
//                .setContentText("This means the App wants to say Hello to the world as if it has come to the world for the first time.")
//                .setShowcaseEventListener(new OnShowcaseEventListener() {
//                    @Override
//                    public void onShowcaseViewHide(ShowcaseView showcaseView) {
//                        Target targetButton = new ViewTarget(R.id.button, MainActivity.this);
//                        ShowcaseView.Builder nextShowcaseViewBuilder = new ShowcaseView.Builder(MainActivity.this, true)
//                                .setTarget(targetButton)
//                                .setContentTitle("This is a Button")
//                                .replaceEndButton(createButton(MainActivity.this, "Got It"))
//                                .setContentText("This is an illustration of next tutorial.");
//                        nextShowcaseViewBuilder.build();
//                    }
//
//                    @Override
//                    public void onShowcaseViewDidHide(ShowcaseView showcaseView) {
//                        Toast.makeText(MainActivity.this, "onShowcaseViewDidHide", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onShowcaseViewShow(ShowcaseView showcaseView) {
//                        Toast.makeText(MainActivity.this, "onShowcaseViewShow", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onShowcaseViewTouchBlocked(MotionEvent motionEvent) {
//                        Toast.makeText(MainActivity.this, "onShowcaseViewTouchBlocked", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .replaceEndButton(createButton(MainActivity.this, "Got It"))
//                .setContentTitlePaint(textPaint)
//                ;
//        showcaseViewBuilder.build();
//    }

    @NonNull
    private Button createButton(Activity activity, String name) {
        Button button = new Button(activity);
        button.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        button.setText(name);
        button.setBackgroundColor(activity.getResources().getColor(R.color.colorAccent));
        button.setTextColor(activity.getResources().getColor(R.color.colorButtonText));
        return button;
    }
}
