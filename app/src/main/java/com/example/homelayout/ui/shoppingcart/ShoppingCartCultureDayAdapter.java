package com.example.homelayout.ui.shoppingcart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homelayout.R;
import com.example.homelayout.domain.Workshops;
import com.example.homelayout.logic.CulturedayBookingInfo;
import com.example.homelayout.repositories.TinyDB;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ShoppingCartCultureDayAdapter extends RecyclerView.Adapter<ShoppingCartCultureDayAdapter.CultureDayViewHolder> implements Serializable {
    private ArrayList<Object> cultureDayData;
    private TinyDB tinyDB;
    public ShoppingCartCultureDayAdapter(ArrayList cultureDayData) {
        this.cultureDayData = cultureDayData;
    }

    @Override
    public CultureDayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        tinyDB = new TinyDB(context);
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
        String price = decimalFormat.format(cultureDayBooking.getPrice());
        ArrayList<Workshops> workshoplist = cultureDayBooking.getWorkshops();
        String workshops = "";
        for (int i = 0; i < workshoplist.size(); i++) {
            if (i == workshoplist.size() - 1) {
                workshops += workshoplist.get(i);
            } else {
                workshops += workshoplist.get(i) + "\n";
            }
        }

        holder.mRounds.setText(String.valueOf(cultureDayBooking.getRounds()));
        holder.mMinutes.setText(String.valueOf(cultureDayBooking.getWorkshops_per_round()));
        holder.mTotalMinutes.setText(String.valueOf(cultureDayBooking.getWorkshop_minutes()));
        holder.mParticipants.setText(String.valueOf(cultureDayBooking.getParticepants()));
        holder.mWorkshops.setText(workshops.toString());
        holder.mTimeTable.setText(String.valueOf(cultureDayBooking.getTimescheme()));
        holder.mLearningLevel.setText(String.valueOf(cultureDayBooking.getLearninglevel()));
        holder.mDate.setText(String.valueOf(cultureDayBooking.getDate()));
        holder.mPrice.setText("€" + price);
        holder.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cultureDayData.remove(cultureDayData.get(position));
                tinyDB.putListObject("CultureItems", cultureDayData);
                notifyDataSetChanged();

            }
        });
    }

    public class CultureDayViewHolder extends RecyclerView.ViewHolder {
        private TextView mRounds;
        private TextView mMinutes;
        private TextView mTotalMinutes;
        private TextView mParticipants;
        private TextView mWorkshops;
        private TextView mTimeTable;
        private TextView mLearningLevel;
        private TextView mDate;
        private TextView mPrice;
        private ImageButton mButton;

        public CultureDayViewHolder(@NonNull View view) {
            super(view);
            mRounds = (TextView) itemView.findViewById(R.id.shopping_cart_rounds);
            mMinutes = (TextView) itemView.findViewById(R.id.shopping_cart_minutes);
            mTotalMinutes = (TextView) itemView.findViewById(R.id.shopping_cart_total_minutes);
            mParticipants = (TextView) itemView.findViewById(R.id.shopping_cart_participants);
            mWorkshops = (TextView) itemView.findViewById(R.id.shopping_cart_workshops);
            mTimeTable = (TextView) itemView.findViewById(R.id.shopping_cart_timetable);
            mLearningLevel = (TextView) itemView.findViewById(R.id.shopping_cart_learninglevel);
            mDate = (TextView) itemView.findViewById(R.id.shopping_cart_date);
            mPrice = (TextView) itemView.findViewById(R.id.shopping_cart_price);
            mButton = (ImageButton) itemView.findViewById(R.id.btn_delete_cultureday);
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
