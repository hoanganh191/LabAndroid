package com.example.lab03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter_Bai1 extends BaseAdapter {
    private Context context;
    private int layout;
    private List<SanPham> dsSanPham;

    public Adapter_Bai1(Context context, int layout, List<SanPham> dsSanPham) {
        this.context = context;
        this.layout = layout;
        this.dsSanPham = dsSanPham;
    }

    @Override
    public int getCount() {
        if (dsSanPham != null) {
            return dsSanPham.size(); // QUAN TRỌNG: Trả về số lượng item thực tế
        }
        return 0;
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
        return position; // Trả về vị trí làm ID
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(layout, null);
        ImageView imgAnh = view.findViewById(R.id.imgAnh);
        TextView tvTenSp = view.findViewById(R.id.tvTenSp);
        TextView tvMoTa = view.findViewById(R.id.tvMoTa);
        TextView tvGia = view.findViewById(R.id.tvGia);
        SanPham sp = dsSanPham.get(position);
        imgAnh.setImageResource(sp.getAnh());
        tvTenSp.setText(sp.getTenSp());
        tvMoTa.setText(sp.getMoTa());
        tvGia.setText(sp.getGia() + "$");
        return view;
    }
}
