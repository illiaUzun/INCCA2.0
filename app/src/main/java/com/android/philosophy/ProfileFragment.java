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
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * User: special
 * Date: 13-12-22
 * Time: 下午1:31
 * Mail: specialcyci@gmail.com
 */
public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.profile, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        LinearLayout ly1 = (LinearLayout) getView().findViewById(R.id.journal);
        // or  (ImageView) view.findViewById(R.id.foo);
        ly1.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://philhum.000webhostapp.com"));
                startActivity(intent);

            }

        });

        LinearLayout ly2 = (LinearLayout) getView().findViewById(R.id.folder);
        // or  (ImageView) view.findViewById(R.id.foo);
        ly2.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://drive.google.com/drive/folders/16IOit-IuXJcMBdW1IuGI3FdbzHqjzyRM?usp=sharing"));
                startActivity(intent);

            }

        });

        LinearLayout ly3 = (LinearLayout) getView().findViewById(R.id.document);
        // or  (ImageView) view.findViewById(R.id.foo);
        ly3.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://docs.google.com/document/d/1cHiRDAXwf9exmVPOxUocKDknV4K-qHmLIom093QAp-c/edit?usp=sharing"));
                startActivity(intent);

            }

        });
    }
}
