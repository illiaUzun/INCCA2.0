package com.android.philosophy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FullInfoActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_info);

        Intent i = getIntent();
        int position = i.getExtras().getInt("id");

        ImageAdapter imageAdapter = new ImageAdapter(this);
        GridElement gridElement = (GridElement)imageAdapter.getItem(position);

        ImageView imageView = (ImageView) findViewById(R.id.full_image);
        TextView textView = (TextView) findViewById(R.id.full_text);
        imageView.setImageResource(gridElement.getImage());
        textView.setText(R.string.grid_onpu);
        //textView.setText()

    }

}
