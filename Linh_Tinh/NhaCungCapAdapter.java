package com.example.thi_nghiem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter; // Đã thay đổi import
import android.widget.TextView;

import java.util.List;

public class NhaCungCapAdapter extends BaseAdapter { // Đã thay đổi kế thừa

    private Context context;
    private List<NhaCungCap> listNhaCungCap;
    private LayoutInflater inflater;

    public NhaCungCapAdapter(Context context, List<NhaCungCap> listNhaCungCap) {
        this.context = context;
        this.listNhaCungCap = listNhaCungCap;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (listNhaCungCap != null) {
            return listNhaCungCap.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (listNhaCungCap != null && position >= 0 && position < listNhaCungCap.size()) {
            return listNhaCungCap.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position; // Hoặc một ID duy nhất hơn nếu có
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        ViewHolder holder;

        if (listItemView == null) {
            listItemView = inflater.inflate(R.layout.grid_item_nhacungcap, parent, false);
            holder = new ViewHolder();
            holder.tvTenCongTy = listItemView.findViewById(R.id.tvTenCongTy);
            holder.tvDiaChi = listItemView.findViewById(R.id.tvDiaChi);
            holder.tvDienThoai = listItemView.findViewById(R.id.tvDienThoai);
            listItemView.setTag(holder);
        } else {
            holder = (ViewHolder) listItemView.getTag();
        }

        NhaCungCap currentNhaCungCap = (NhaCungCap) getItem(position);

        if (currentNhaCungCap != null) {
            holder.tvTenCongTy.setText(currentNhaCungCap.getTenCongTy());
            holder.tvDiaChi.setText("Địa chỉ: " + currentNhaCungCap.getDiaChi());
            holder.tvDienThoai.setText("ĐT: " + currentNhaCungCap.getDienThoai());
        }

        return listItemView;
    }

    // ViewHolder pattern để tối ưu hiệu suất
    static class ViewHolder {
        TextView tvTenCongTy;
        TextView tvDiaChi;
        TextView tvDienThoai;
    }
}
