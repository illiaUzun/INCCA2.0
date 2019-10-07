package com.onpu.PhGame;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PreUnityActivity extends Activity {

    private int currentSwipeItem;
    private final int maxNumberOfElements = 8;

    private ImageView phylsImage;
    private ImageView leftArrow;
    private ImageView rightArrow;
    private TextView phylsName;
    private TextView phylsInfo;
    private TextView phylsYears;
    private TextView swipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preunity);
        currentSwipeItem = 0;

        findViewById(R.id.button).setOnClickListener(v -> {
            Intent intent = new Intent(this, UnityPlayerActivity.class);
            startActivity(intent);
        });

        phylsImage = findViewById(R.id.phylsImage);
        phylsName = findViewById(R.id.phylsName);
        phylsYears = findViewById(R.id.phylsYears);
        phylsInfo = findViewById(R.id.phylsInfo);
        swipes = findViewById(R.id.textView);
        rightArrow = findViewById(R.id.rightArrow);
        leftArrow = findViewById(R.id.leftArrow);

        currentSwipeItem = 0;
        chooseItem(currentSwipeItem);

        findViewById(R.id.rootLayout).setOnTouchListener(new OnSwipeTouchListener(PreUnityActivity.this) {
            public void onSwipeRight() {
                if (currentSwipeItem > 0)
                    currentSwipeItem--;
                chooseItem(currentSwipeItem);
            }

            public void onSwipeLeft() {
                if (currentSwipeItem < maxNumberOfElements)
                    currentSwipeItem++;
                chooseItem(currentSwipeItem);
            }
        });

        rightArrow.setOnClickListener(v -> {
            if (currentSwipeItem < maxNumberOfElements)
                currentSwipeItem++;
            chooseItem(currentSwipeItem);
        });

        leftArrow.setOnClickListener(v -> {
            if (currentSwipeItem > 0)
                currentSwipeItem--;
            chooseItem(currentSwipeItem);
        });
    }

    public void chooseItem(int currentSwipeItem) {
        if (currentSwipeItem == 0) {
            leftArrow.setVisibility(View.GONE);
        } else if (currentSwipeItem == 8)
            rightArrow.setVisibility(View.GONE);
        else {
            rightArrow.setVisibility(View.VISIBLE);
            leftArrow.setVisibility(View.VISIBLE);
        }
        switch (currentSwipeItem) {
            case 0:
                phylsImage.setImageResource(R.drawable.konf);
                phylsName.setText(R.string.KonfPhylsName);
                phylsYears.setText(R.string.KonfYearsOfLife);
                phylsInfo.setText(R.string.KonfInfo);
                break;
            case 1:
                phylsImage.setImageResource(R.drawable.foma);
                phylsName.setText(R.string.FomaPhylsName);
                phylsYears.setText(R.string.FomaYearsOfLife);
                phylsInfo.setText(R.string.FomaInfo);
                break;
            case 2:
                phylsImage.setImageResource(R.drawable.mak);
                phylsName.setText(R.string.MakPhylsName);
                phylsYears.setText(R.string.MakYearsOfLife);
                phylsInfo.setText(R.string.MakInfo);
                break;
            case 3:
                phylsImage.setImageResource(R.drawable.dekart);
                phylsName.setText(R.string.DekartPhylsName);
                phylsYears.setText(R.string.DekartYearsOfLife);
                phylsInfo.setText(R.string.DekartInfo);
                break;
            case 4:
                phylsImage.setImageResource(R.drawable.russo);
                phylsName.setText(R.string.JjrussoPhylsName);
                phylsYears.setText(R.string.JjrussoYearsOfLife);
                phylsInfo.setText(R.string.JjrussoInfo);
                break;
            case 5:
                phylsImage.setImageResource(R.drawable.kant);
                phylsName.setText(R.string.KantPhylsName);
                phylsYears.setText(R.string.KantYearsOfLife);
                phylsInfo.setText(R.string.KantInfo);
                break;
            case 6:
                phylsImage.setImageResource(R.drawable.sartre);
                phylsName.setText(R.string.SartrePhylsName);
                phylsYears.setText(R.string.SartreYearsOfLife);
                phylsInfo.setText(R.string.SartreInfo);
                break;
            case 7:
                phylsImage.setImageResource(R.drawable.camu);
                phylsName.setText(R.string.CamuPhylsName);
                phylsYears.setText(R.string.CamuYearsOfLife);
                phylsInfo.setText(R.string.CamuInfo);
                break;
            case 8:
                phylsImage.setImageResource(R.drawable.nit);
                phylsName.setText(R.string.NietzschcePhylsName);
                phylsYears.setText(R.string.NietzschceYearsOfLife);
                phylsInfo.setText(R.string.NietzschceInfo);
                break;
        }
        swipes.setText(String.valueOf(currentSwipeItem));
    }
}