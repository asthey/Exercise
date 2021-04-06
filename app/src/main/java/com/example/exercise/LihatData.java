package com.example.exercise;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LihatData extends AppCompatActivity {
    TextView tvnama;
    TextView tvnomor;
    String nama;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        Bundle b = getIntent().getExtras();
        nama = b.getString("a");

        tvnama = (TextView) findViewById(R.id.tvNamaKontak);
        tvnomor = (TextView) findViewById(R.id.tvNomorTelepon);

        switch (nama)
        {
            case "Yasmina":
                tvnama.setText("Yasmina Azzahra");
                tvnomor.setText("666");
                break;
            case "Sekar":
                tvnama.setText("Sekar Putri");
                tvnomor.setText("666");
                break;
            case "Fadhil":
                tvnama.setText("Fadhillah Rizky");
                tvnomor.setText("666");
                break;
            case "Rio":
                tvnama.setText("Rio Anggara");
                tvnomor.setText("666");
                break;
            case "Arif":
                tvnama.setText("M Arif");
                tvnomor.setText("666");
                break;
            case "Adel":
                tvnama.setText("Adellia Pingkan");
                tvnomor.setText("666");
                break;
            case "Indah":
                tvnama.setText("Sisilia Indah");
                tvnomor.setText("666");
                break;
        }
    }
}