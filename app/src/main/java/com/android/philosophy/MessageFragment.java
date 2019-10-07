package com.android.philosophy;

import android.annotation.SuppressLint;
import android.content.Context;
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
import android.widget.ListView;


public class MessageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.message, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        LinearLayout ly1 = (LinearLayout) getView().findViewById(R.id.quiz);
        // or  (ImageView) view.findViewById(R.id.foo);
        ly1.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                openQuiz("fantastic.philosophyQuiz");

            }

        });

        LinearLayout ly2 = (LinearLayout) getView().findViewById(R.id.puzzle);
        // or  (ImageView) view.findViewById(R.id.foo);
        ly2.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                openPuzzle("com.puzzle.philosophy");

            }

        });

        LinearLayout ly3 = (LinearLayout) getView().findViewById(R.id.match);
        // or  (ImageView) view.findViewById(R.id.foo);
        ly3.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                openMatch("com.onpu.PhGame");

            }

        });

    }


    @SuppressLint("NewApi")
    private void openQuiz(String path){
        Intent launchIntent = null;

        try{
            launchIntent = getActivity().getApplicationContext().getPackageManager().getLeanbackLaunchIntentForPackage(path);
        } catch (java.lang.NoSuchMethodError e){
        }

        if (launchIntent == null) launchIntent =  getActivity().getApplicationContext().getPackageManager().getLaunchIntentForPackage(path);

        if (launchIntent != null)  {
            launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getActivity().getApplicationContext().startActivity(launchIntent);
        } else {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://drive.google.com/open?id=16Qxv-qzcPbrjsdT3pPiSq2CV8MQNLh-x"));
            startActivity(intent);
        }

    }
    @SuppressLint("NewApi")
    private void openPuzzle(String path){
        Intent launchIntent = null;

        try{
            launchIntent = getActivity().getApplicationContext().getPackageManager().getLeanbackLaunchIntentForPackage(path);
        } catch (java.lang.NoSuchMethodError e){
        }

        if (launchIntent == null) launchIntent =  getActivity().getApplicationContext().getPackageManager().getLaunchIntentForPackage(path);

        if (launchIntent != null)  {
            launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getActivity().getApplicationContext().startActivity(launchIntent);
        } else {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://drive.google.com/open?id=1lSLdVh3CWwwcKOlNOhN3Fd2Wxcw0QFZ0"));
            startActivity(intent);
        }

    }
    @SuppressLint("NewApi")
    private void openMatch(String path){
        Intent launchIntent = null;

        try{
            launchIntent = getActivity().getApplicationContext().getPackageManager().getLeanbackLaunchIntentForPackage(path);
        } catch (java.lang.NoSuchMethodError e){
        }

        if (launchIntent == null) launchIntent =  getActivity().getApplicationContext().getPackageManager().getLaunchIntentForPackage(path);

        if (launchIntent != null)  {
            launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getActivity().getApplicationContext().startActivity(launchIntent);
        } else {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://drive.google.com/open?id=1eWEb1l2zwejgDWLslDFKJ1yiQRoDXVjz"));
            startActivity(intent);
        }

    }
}
