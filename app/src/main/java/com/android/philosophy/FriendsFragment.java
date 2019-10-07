package com.android.philosophy;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class FriendsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        ImageView imageView = (ImageView) getView().findViewById(R.id.imageView);
//        ImageView imageView2 = (ImageView) getView().findViewById(R.id.imageView2);
//        ImageView imageView3 = (ImageView) getView().findViewById(R.id.imageView3);

        return inflater.inflate(R.layout.friends, container, false);
    }

}
