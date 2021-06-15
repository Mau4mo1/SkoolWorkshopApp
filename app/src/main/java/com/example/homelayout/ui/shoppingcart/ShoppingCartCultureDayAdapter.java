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
import com.example.homelayout.domain.Workshops;
import com.example.homelayout.logic.CulturedayBookingInfo;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
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
        DecimalFormat decimalFormat = new DecimalFormat("#.##0,00");
        CulturedayBookingInfo cultureDayBooking = (CulturedayBookingInfo) cultureDayData.get(pos);
        String prijs = decimalFormat.format(cultureDayBooking.getPrice());
        ArrayList<Workshops> workshoplist = cultureDayBooking.getWorkshops();
        String workshops = "";
        for (int i = 0; i < workshoplist.size(); i++) {
            if (i == workshoplist.size() - 1) {
                workshops += workshoplist.get(i);
            } else {
                workshops += workshoplist.get(i) + "\n";
            }
        }

        holder.mRondes.setText(String.valueOf(cultureDayBooking.getRounds()));
        holder.mMinuten.setText(String.valueOf(cultureDayBooking.getWorkshops_per_round()));
        holder.mTotaleMinuten.setText(String.valueOf(cultureDayBooking.getWorkshop_minutes()));
        holder.mDeelnemers.setText(String.valueOf(cultureDayBooking.getParticepants()));
        holder.mWorkshops.setText(workshops.toString());
        holder.mTijdschema.setText(String.valueOf(cultureDayBooking.getTimescheme()));
        holder.mLeerniveau.setText(String.valueOf(cultureDayBooking.getLearninglevel()));
        holder.mDatum.setText(String.valueOf(cultureDayBooking.getDate()));
        holder.mPrijs.setText("€" + prijs);
    }

    public class CultureDayViewHolder extends RecyclerView.ViewHolder {
        private TextView mRondes;
        private TextView mMinuten;
        private TextView mTotaleMinuten;
        private TextView mDeelnemers;
        private TextView mWorkshops;
        private TextView mTijdschema;
        private TextView mLeerniveau;
        private TextView mDatum;
        private TextView mPrijs;

        public CultureDayViewHolder(@NonNull View view) {
            super(view);
            mRondes = (TextView) itemView.findViewById(R.id.shopping_cart_rondes);
            mMinuten = (TextView) itemView.findViewById(R.id.shopping_cart_minuten);
            mTotaleMinuten = (TextView) itemView.findViewById(R.id.shopping_cart_totale_minuten);
            mDeelnemers = (TextView) itemView.findViewById(R.id.shopping_cart_deelnemers);
            mWorkshops = (TextView) itemView.findViewById(R.id.shopping_cart_workshops);
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
