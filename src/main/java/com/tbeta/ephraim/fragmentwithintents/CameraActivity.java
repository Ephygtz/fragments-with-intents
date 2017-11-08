package com.tbeta.ephraim.fragmentwithintents;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CameraActivity extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static  final int CAMERA_REQUEST = 1888;

    Button cam;
    ImageView imageSet;

    public CameraActivity() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static MainActivity.PlaceholderFragment newInstance(int sectionNumber) {
        MainActivity.PlaceholderFragment fragment = new MainActivity.PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_camera, container, false);




        imageSet = (ImageView) rootView.findViewById(R.id.imageView) ;
        cam = (Button) rootView.findViewById(R.id.takePic);
        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getActivity(), "Yeay! Button works!!", Toast.LENGTH_SHORT).show();
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

        return rootView;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
        Bitmap photo = (Bitmap) data.getExtras().get("data");
        imageSet.setImageBitmap(photo);
        }}










}