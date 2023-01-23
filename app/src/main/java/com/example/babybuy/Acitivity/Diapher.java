package com.example.babybuy.Acitivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.babybuy.Adapters.FirestoreProduct;
import com.example.babybuy.Helperclass.FetchdataFirestore;
import com.example.babybuy.R;
import com.example.babybuy.models.Firestoreproduct;

import java.util.ArrayList;

public class Diapher extends AppCompatActivity {
    private static ArrayList<Firestoreproduct> mArrayList = new ArrayList<>();
    FirestoreProduct firestoreProductadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diapher);

        RecyclerView recyclerView = findViewById(R.id.recyclerProductDiapher);
        recyclerView.hasFixedSize();
        //setting layout inside recycle view
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        firestoreProductadapter = new FirestoreProduct(Diapher.this, mArrayList);
        recyclerView.setAdapter(firestoreProductadapter);
        FetchdataFirestore fetchdataFirestore = new FetchdataFirestore();
        fetchdataFirestore.fetchdatafromfirestore(this,"diapherItems",firestoreProductadapter,mArrayList);


    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
        mArrayList.clear();
    }
}