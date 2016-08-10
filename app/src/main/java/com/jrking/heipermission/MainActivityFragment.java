package com.jrking.heipermission;

import android.Manifest;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hei.permission.PermissionActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {

    private AppCompatButton mBtn;

    public MainActivityFragment() {
    }

    View mRootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView =  inflater.inflate(R.layout.fragment_main, container, false);
        mBtn = (AppCompatButton) mRootView.findViewById(R.id.btn_camera);
        mBtn.setOnClickListener(this);
        return mRootView;
    }


    @Override
    public void onClick(View v) {
        ((PermissionActivity)getActivity()).checkPermission(new PermissionActivity.CheckPermListener() {
            @Override
            public void superPermission() {
                ((MainActivity)getActivity()).Toast(mRootView,"相机可以用2");
            }
        },R.string.camera, Manifest.permission.CAMERA);
    }
}
