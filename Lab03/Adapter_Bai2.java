package com.example.lab03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter_Bai2 extends BaseAdapter {
    Context context;
    int layout;
    List<SanPham2> dsSanPham;

    public Adapter_Bai2(Context context, int layout, List<SanPham2> dsSanPham) {
        this.context = context;
        this.layout = layout;
        this.dsSanPham = dsSanPham;
    }

    @Override
    public int getCount() {
        return dsSanPham.size();
    }

    @Override
    public Object getItem(int position) {
        if (dsSanPham != null && position >= 0 && position < dsSanPham.size()) {
            return dsSanPham.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(layout, null);
        ImageView imgAnh = view.findViewById(R.id.imgAnh2);
        TextView tvTenSp = view.findViewById(R.id.tvTenSp);
        TextView tvGia = view.findViewById(R.id.tvGia);
        SanPham2 sp = dsSanPham.get(position);
        imgAnh.setImageResource(sp.getAnh());
        tvTenSp.setText(sp.getTenSp());
        tvGia.setText(sp.getGia() + "$");
        return view;

    }
}
