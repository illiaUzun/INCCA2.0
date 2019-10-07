package com.android.philosophy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


public class HomeFragment extends Fragment {

    private View parentView;
    private ResideMenu resideMenu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.home, container, false);

        return parentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        LinearLayout ly1 = (LinearLayout) getView().findViewById(R.id.onpu);
        // or  (ImageView) view.findViewById(R.id.foo);
        ly1.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://ac.opu.ua/ru"));
                startActivity(intent);

            }

        });

        LinearLayout ly2 = (LinearLayout) getView().findViewById(R.id.gum);
        // or  (ImageView) view.findViewById(R.id.foo);
        ly2.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://hsf.opu.ua"));
                startActivity(intent);

            }

        });

        LinearLayout ly3 = (LinearLayout) getView().findViewById(R.id.kfafil);
        // or  (ImageView) view.findViewById(R.id.foo);
        ly3.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://philosophy.ucoz.ru"));
                startActivity(intent);

            }

        });

        LinearLayout ly4 = (LinearLayout) getView().findViewById(R.id.facebook);
        // or  (ImageView) view.findViewById(R.id.foo);
        ly4.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.facebook.com/groups/171082996673952"));
                startActivity(intent);

            }

        });
    }

}
