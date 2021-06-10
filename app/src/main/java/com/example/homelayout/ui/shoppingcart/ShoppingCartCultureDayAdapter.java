package com.example.homelayout.ui.shoppingcart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homelayout.R;
import com.example.homelayout.domain.CultureDayBooking;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

public class ShoppingCartCultureDayAdapter extends RecyclerView.Adapter<ShoppingCartCultureDayAdapter.CultureDayViewHolder> implements Serializable {
    private List cultureDayData;

    public ShoppingCartCultureDayAdapter(List cultureDayData) {
        this.cultureDayData = cultureDayData;
    }

    @Override
    public CultureDayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.fragment_shopping_cart_cultureday;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, false);
        return new CultureDayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CultureDayViewHolder holder, int position) {
        final int pos = position;
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        CultureDayBooking cultureDayBooking = (CultureDayBooking) cultureDayData.get(pos);
        String prijs = decimalFormat.format(cultureDayBooking.getPrijs());
        holder.mRondes.setText(String.valueOf(cultureDayBooking.getRondes()));
        holder.mMinuten.setText(String.valueOf(cultureDayBooking.getMinutenPerRonde()));
        holder.mTotaleMinuten.setText(String.valueOf(cultureDayBooking.getTotaleMinuten()));
        holder.mTijdschema.setText(String.valueOf(cultureDayBooking.getTijdschema()));
        holder.mLeerniveau.setText(String.valueOf(cultureDayBooking.getLeerniveau()));
        holder.mDatum.setText(String.valueOf(cultureDayBooking.getDatum()));
        holder.mPrijs.setText("€" + prijs);
    }

    public class CultureDayViewHolder extends RecyclerView.ViewHolder {
        private TextView mRondes;
        private TextView mMinuten;
        private TextView mTotaleMinuten;
        private TextView mTijdschema;
        private TextView mLeerniveau;
        private TextView mDatum;
        private TextView mPrijs;

        public CultureDayViewHolder(@NonNull View view) {
            super(view);
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
        if (cultureDayData == null) {
            return 0;
        }
        return cultureDayData.size();
    }
}
