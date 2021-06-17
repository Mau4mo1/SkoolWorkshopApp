package com.example.homelayout.ui.account.reservation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homelayout.R;
import com.example.homelayout.domain.CultureDayBooking;
import com.example.homelayout.repositories.TinyDB;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ReservationAdapterCultureDay extends RecyclerView.Adapter<ReservationAdapterCultureDay.ReservationViewHolder> implements Serializable {
    private ArrayList<Object> cultureDayData;
    private TinyDB tinydb;

    public ReservationAdapterCultureDay(ArrayList<Object> cultureDayData) {
        this.cultureDayData = cultureDayData;
    }
    @NonNull
    @Override
    public ReservationAdapterCultureDay.ReservationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();

        int layoutIdForListItem = R.layout.fragment_my_reservation_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        return new ReservationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReservationAdapterCultureDay.ReservationViewHolder holder, int position) {
        final int pos = position;
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        CultureDayBooking cultureDayBooking = (CultureDayBooking) cultureDayData.get(pos);
        String prijs = decimalFormat.format(cultureDayBooking.getPrijs());
        List<String> workshoplist = cultureDayBooking.getWorkshops();
        String workshops = "";
        for (int i = 0; i < workshoplist.size(); i++) {
            if (i == workshoplist.size() - 1) {
                workshops += workshoplist.get(i);
            } else {
                workshops += workshoplist.get(i) + "\n";
            }
        }

        holder.id.setText(String.valueOf(cultureDayBooking.getRondes()));
        holder.date.setText(String.valueOf(cultureDayBooking.getMinutenPerRonde()));
        holder.status.setText(String.valueOf(cultureDayBooking.getTotaleMinuten()));
        holder.kost.setText(String.valueOf(cultureDayBooking.getDeelnemers()));
        holder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cultureDayData.remove(cultureDayData.get(position));
                tinydb.putListObject("Carditems", cultureDayData);
                notifyDataSetChanged();

            }
        });
    }

    @Override
    public int getItemCount() {
        if (cultureDayData == null) {
            return 0;
        }
        return cultureDayData.size();
    }

    public class ReservationViewHolder extends RecyclerView.ViewHolder{
        private TextView id;
        private TextView date;
        private TextView status;
        private TextView kost;
        private Button detail;

        public ReservationViewHolder(@NonNull View view){
            super(view);
            id = view.findViewById(R.id.tv_my_reservation_id);
            date = view.findViewById(R.id.tv_my_reservation_date);
            status = view.findViewById(R.id.tv_my_reservation_status);
            kost = view.findViewById(R.id.tv_my_reservation_total_kost);
            detail = view.findViewById(R.id.button_my_reservation_info);
        }
    }
}
