package com.example.homelayout.ui.shoppingcart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homelayout.R;
import com.example.homelayout.domain.WorkshopBooking;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

public class ShoppingCartWorkshopAdapter extends RecyclerView.Adapter<ShoppingCartWorkshopAdapter.WorkshopViewHolder> implements Serializable {
    private List workshopData;

    public ShoppingCartWorkshopAdapter(List workshopData) {
        this.workshopData = workshopData;
    }

    @Override
    public WorkshopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.fragment_shopping_cart_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, false);
        return new WorkshopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkshopViewHolder holder, int position) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        WorkshopBooking workshopBooking = (WorkshopBooking) workshopData.get(position);
        holder.mDienst.setText(String.valueOf(workshopBooking.getDienst()));
        holder.mRondes.setText(String.valueOf(workshopBooking.getRondes()));
        holder.mMinuten.setText(String.valueOf(workshopBooking.getMinuten()));
        holder.mTotaleMinuten.setText(String.valueOf(workshopBooking.getTotaleMinuten()));
        holder.mTijdschema.setText(String.valueOf(workshopBooking.getTijdschema()));
        holder.mLeerniveau.setText(String.valueOf(workshopBooking.getLeerniveau()));
        holder.mDatum.setText(String.valueOf(workshopBooking.getDatum()));
        holder.mPrijs.setText("€" + String.valueOf(decimalFormat.format(workshopBooking.getPrijs())));
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
