package com.android.philosophy;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;


public class Slide_Navigation_Main extends FragmentActivity implements View.OnClickListener{

    private ResideMenu resideMenu;
    private Slide_Navigation_Main mContext;
    private ResideMenuItem itemHome;
    private ResideMenuItem itemProfile;
    private ResideMenuItem itemCalendar;
    private ResideMenuItem itemSettings;
    private ResideMenuItem itemMessage;
    private ResideMenuItem itemFriends;
    private ResideMenuItem itemMainBuildingsInfo;
    private ResideMenuItem itemEvents;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_navigation_main);
        mContext = this;
        setUpMenu();
        if( savedInstanceState == null )
            changeFragment(new HomeFragment());
    }

    private void setUpMenu() {

        // attach to current activity;
        resideMenu = new ResideMenu(this);
       resideMenu.setUse3D(true);resideMenu.setBackground(R.drawable.philosophy);
        resideMenu.attachToActivity(this);
        resideMenu.setMenuListener(menuListener);
        //valid scale factor is between 0.0f and 1.0f. leftmenu'width is 150dip. 
       // resideMenu.setScaleValue(0.6f);

        // create menu items;
        itemHome     = new ResideMenuItem(this, R.drawable.ic_home_dark,     "Головна сторінка");
        itemProfile  = new ResideMenuItem(this, R.drawable.ic_dark_profile,  "Корисні ресурси");
        itemProfile  = new ResideMenuItem(this, R.drawable.ic_dark_profile,  "Корисні ресурси");
        itemCalendar = new ResideMenuItem(this, R.drawable.ic_videogame_asset_black_24dp, "Ігри");
        itemSettings = new ResideMenuItem(this, R.drawable.ic_camera_alt_black_24dp, "AR-Візитка");
        itemMessage  = new ResideMenuItem(this, R.drawable.ic_videogame_asset_black_24dp,  "Ігри");
        itemFriends  = new ResideMenuItem(this, R.drawable.ic_camera_alt_black_24dp,  "AR-Візитка");
        itemMainBuildingsInfo  = new ResideMenuItem(this, R.drawable.ic_menu_1,  "Главная инфа");
//        itemEvents  = new ResideMenuItem(this, R.drawable.ic_dark_events,  "Events");

        itemHome.setOnClickListener(this);
        itemProfile.setOnClickListener(this);
        itemCalendar.setOnClickListener(this);
        itemSettings.setOnClickListener(this);
        itemMessage.setOnClickListener(this);
        itemFriends.setOnClickListener(this);
        itemMainBuildingsInfo.setOnClickListener(this);



//        itemEvents.setOnClickListener(this);


        resideMenu.addMenuItem(itemHome, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemProfile, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemMessage, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemFriends, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemMainBuildingsInfo, ResideMenu.DIRECTION_LEFT);
//        resideMenu.addMenuItem(itemEvents, ResideMenu.DIRECTION_LEFT);

        // You can disable a direction by setting ->
        // resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);

        findViewById(R.id.title_bar_left_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });
//        findViewById(R.id.title_bar_right_menu).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                resideMenu.openMenu(ResideMenu.DIRECTION_RIGHT);
//            }
//        });
    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        return resideMenu.dispatchTouchEvent(ev);
//    }

    @Override
    public void onClick(View view) {

        if (view == itemHome){
            changeFragment(new HomeFragment());
        }else if (view == itemProfile){
            changeFragment(new ProfileFragment());
        }else if (view == itemMessage){
            changeFragment(new MessageFragment());
        }else if (view == itemFriends){
            open();
        }else if (view == itemMainBuildingsInfo){
            changeFragment(new BuildingMainInfoFragment());
        }

        resideMenu.closeMenu();
    }
    @SuppressLint("NewApi")
    private void open(){
        Intent launchIntent = null;

        try{
            launchIntent = getApplicationContext().getPackageManager().getLeanbackLaunchIntentForPackage("com.vuforia.engine.CoreSamples");
        } catch (java.lang.NoSuchMethodError e){
        }

        if (launchIntent == null) launchIntent = getApplicationContext().getPackageManager().getLaunchIntentForPackage("com.vuforia.engine.CoreSamples");

        if (launchIntent != null)  {
            launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplicationContext().startActivity(launchIntent);
        } else {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://drive.google.com/open?id=1NFpsCCeSCdD5vd5AKHgztqZnl2uZKJbo"));
            startActivity(intent);
        }

    }
    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
            //Toast.makeText(mContext, "Menu is opened!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void closeMenu() {
            //Toast.makeText(mContext, "Menu is closed!", Toast.LENGTH_SHORT).show();
        }
    };

    private void changeFragment(Fragment targetFragment){
        resideMenu.clearIgnoredViewList();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, targetFragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    // What good method is to access resideMenu？
    public ResideMenu getResideMenu(){
        return resideMenu;
    }
}
