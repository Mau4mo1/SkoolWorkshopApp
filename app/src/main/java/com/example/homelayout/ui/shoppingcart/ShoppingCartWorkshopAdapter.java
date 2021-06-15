package com.example.homelayout.ui.shoppingcart;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homelayout.R;
import com.example.homelayout.domain.WorkshopBooking;
import com.example.homelayout.repositories.TinyDB;
import com.example.homelayout.ui.workshops.WorkshopsFragment;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartWorkshopAdapter extends RecyclerView.Adapter<ShoppingCartWorkshopAdapter.WorkshopViewHolder> implements Serializable {
    private ArrayList<Object> workshopData = new ArrayList<>();
    private TinyDB tinyDB;

    public ShoppingCartWorkshopAdapter(ArrayList<Object> workshopData) {
        this.workshopData = workshopData;

    }

    @Override
    public WorkshopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        tinyDB = new TinyDB(context);
        int layoutIdForListItem = R.layout.fragment_shopping_cart_workshop;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, false);
        return new WorkshopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkshopViewHolder holder, int position) {
        DecimalFormat decimalFormat = new DecimalFormat("#,00");
        WorkshopBooking workshopBooking = (WorkshopBooking) workshopData.get(position);
        String prijs = decimalFormat.format(workshopBooking.getPrijs());
        holder.mDienst.setText(String.valueOf(workshopBooking.getDienst()));
        holder.mRondes.setText(String.valueOf(workshopBooking.getRondes()));
        holder.mMinuten.setText(String.valueOf(workshopBooking.getMinuten()));
        holder.mTotaleMinuten.setText(String.valueOf(workshopBooking.getTotaleMinuten()));
        holder.mTijdschema.setText(String.valueOf(workshopBooking.getTijdschema()));
        holder.mLeerniveau.setText(String.valueOf(workshopBooking.getLeerniveau()));
        holder.mDatum.setText(String.valueOf(workshopBooking.getDatum()));
        holder.mPrijs.setText("€" + prijs);
        holder.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workshopData.remove(workshopData.get(position));
                tinyDB.putListObject("Carditems", workshopData);
                notifyDataSetChanged();

            }
        });
    }

    public class WorkshopViewHolder extends RecyclerView.ViewHolder {
        private TextView mDienst;
        private TextView mRondes;
        private TextView mMinuten;
        private TextView mTotaleMinuten;
        private TextView mTijdschema;
        private TextView mLeerniveau;
        private TextView mDatum;
        private TextView mPrijs;
        private ImageButton mButton;
        public WorkshopViewHolder(@NonNull View view) {
            super(view);
            mDienst = (TextView) itemView.findViewById(R.id.shopping_cart_dienst);
            mRondes = (TextView) itemView.findViewById(R.id.shopping_cart_rondes);
            mMinuten = (TextView) itemView.findViewById(R.id.shopping_cart_minuten);
            mTotaleMinuten = (TextView) itemView.findViewById(R.id.shopping_cart_totale_minuten);
            mTijdschema = (TextView) itemView.findViewById(R.id.shopping_cart_tijdschema);
            mLeerniveau = (TextView) itemView.findViewById(R.id.shopping_cart_leerniveau);
            mDatum = (TextView) itemView.findViewById(R.id.shopping_cart_datum);
            mPrijs = (TextView) itemView.findViewById(R.id.shopping_cart_prijs);
            mButton = (ImageButton) itemView.findViewById(R.id.btn_delete_workshop);
        }
    }

    @Override
        public int getItemCount() {
            if (workshopData == null) {
                return 0;
            }
            return workshopData.size();
        }
}
