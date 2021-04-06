package com.example.exercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {
    //Deklarasi variabel dengan jenis data context
    Context mContext;
    //Deklarasi variabel dengan jenis data Layout inflater
    LayoutInflater inflater;
    //Deklarasi variabel dengan jenis data arrayList
    private ArrayList<Nama> arrayList;

    @Override
    public int getCount() {
        return Page2.classNamaArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return Page2.classNamaArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;

        if (view == null) {
            holder = new ViewHolder();

            view = inflater.inflate(R.layout.item_listview, null);

            holder.name = (TextView) view.findViewById(R.id.tvnama_item);

            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.name.setText(Page2.classNamaArrayList.get(i).getNama());

        return view;
    }

    //Membuat konstruktor Listviewadapter
    public ListViewAdapter(Context context) {
        //Memberi nilai mContext dengan context
        mContext = context;

        //Mengatur Layoutinflater dari context yang diberikan
        inflater = LayoutInflater.from(mContext);

        //Memberikan nilai arrayList dari class ClassNama
        this.arrayList = new ArrayList<Nama>();

        //Menambahkan semua elemen ke arraylist
        this.arrayList.addAll(Page2.classNamaArrayList);
    }

    public void filter(String s) {
        String charText2 = s.toLowerCase(Locale.getDefault());
        Page2.classNamaArrayList.clear();
        if (charText2.length() == 0) {
            Page2.classNamaArrayList.addAll(this.arrayList);
        } else {
            Iterator<Nama> it = this.arrayList.iterator();
            while (it.hasNext()) {
                Nama cn = it.next();
                if (cn.getNama().toLowerCase(Locale.getDefault()).contains(charText2)) {
                    Page2.classNamaArrayList.add(cn);
                }
            }
        }
        notifyDataSetChanged();
    }

    public class ViewHolder {
        //mendeklarasikan  variabel dengan jenis TextView
        TextView name;
    }
}
