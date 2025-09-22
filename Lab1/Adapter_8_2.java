package com.example.lab01;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter_8_2 extends BaseAdapter {
    Context context;
    int layout;
    List<NhanVien2> listOfAdapter;

    public Adapter_8_2(Context context, int layout, List<NhanVien2> listOfAdapter) {
        this.context = context;
        this.layout = layout;
        this.listOfAdapter = listOfAdapter;
    }


    @Override
    public int getCount() {
        return listOfAdapter.size();
    }

    @Override
    public Object getItem(int position) {
        // Giữ nguyên code gốc của bạn
        return null;
    }

    @Override
    public long getItemId(int position) {
        // Giữ nguyên code gốc của bạn
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(layout, null);
        ImageView imgNhanVien = view.findViewById(R.id.imgNhanVien);
        TextView tvHoTen = view.findViewById(R.id.tvHoTen);
        TextView tvMoTa = view.findViewById(R.id.tvMoTa);

        NhanVien2 nv = listOfAdapter.get(position);
        imgNhanVien.setImageURI(Uri.parse(nv.getImageUri()));
        tvHoTen.setText(nv.getHoten());
        String gt = "";
        if (nv.isGioitinh() == true) {
            gt = "Nam";
        } else {
            gt = "Nữ";
        }
        tvMoTa.setText("Quê quán: " + nv.getQuequan() + " Giới tính: " + gt);
        return view;
    }
}
