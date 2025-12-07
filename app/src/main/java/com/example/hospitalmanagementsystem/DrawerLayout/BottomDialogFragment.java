package com.example.hospitalmanagementsystem.DrawerLayout;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hospitalmanagementsystem.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;


public class BottomDialogFragment extends BottomSheetDialogFragment {
ImageView imgViewBarCode;
    String Data = "com.example.hospitalmanagementsystem://example.com/open";



    public BottomDialogFragment() {
       }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom_dialog_fragemnt, container, false);

          imgViewBarCode = view.findViewById(R.id.imgViewBarCode);


          try {
              BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
              Bitmap bitmap  = barcodeEncoder.encodeBitmap(Data, BarcodeFormat.QR_CODE,300,300);
              imgViewBarCode.setImageBitmap(bitmap);
          } catch (Exception e) {
              e.getMessage();
          }


        return view;
    }
}