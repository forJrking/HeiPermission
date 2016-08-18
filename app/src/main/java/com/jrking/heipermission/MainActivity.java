package com.jrking.heipermission;

import android.Manifest;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import hei.permission.PermissionActivity;


public class MainActivity extends PermissionActivity implements View.OnClickListener {

    private AppCompatButton mBtnCam, mBtnFra;
    FrameLayout fl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initStatusBar("#303F9F");//状态栏变色

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mBtnCam = (AppCompatButton) findViewById(R.id.btn_camera);
        mBtnFra = (AppCompatButton) findViewById(R.id.btn_fragment);
        fl = (FrameLayout) findViewById(R.id.fragment);
        mBtnCam.setOnClickListener(this);
        mBtnFra.setOnClickListener(this);
    }

    private void Toast(View view, int reSting) {
        Snackbar.make(view, getString(reSting), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
    public void Toast(View view, String reSting) {
        Snackbar.make(view, reSting, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_camera:

                checkPermission(new CheckPermListener() {
                    @Override
                    public void superPermission() {
                        Toast(mBtnCam,"相机可用");
                    }
                },R.string.camera, Manifest.permission.CAMERA);

                break;
            case R.id.btn_fragment:
                fl.removeAllViews();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new MainActivityFragment()).commit();
                break;

            default:
                break;
        }
    }
}
