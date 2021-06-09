package com.example.homelayout.ui.shoppingcart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homelayout.R;
import com.example.homelayout.domain.Payment;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;
import java.util.zip.Inflater;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PaymentViewHolder> implements Serializable {
    private List paymentData;

    public RecyclerAdapter(List paymentData) {
        this.paymentData = paymentData;
    }

    @Override
    public PaymentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.fragment_shopping_cart_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, false);
        return new PaymentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.PaymentViewHolder holder, int position) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        Payment payment = (Payment) paymentData.get(position);
        holder.mDienst.setText(String.valueOf(payment.getDienst()));
        holder.mRondes.setText(String.valueOf(payment.getRondes()));
        holder.mMinuten.setText(String.valueOf(payment.getMinuten()));
        holder.mTotaleMinuten.setText(String.valueOf(payment.getTotaleMinuten()));
        holder.mTijdschema.setText(String.valueOf(payment.getTijdschema()));
        holder.mLeerniveau.setText(String.valueOf(payment.getLeerniveau()));
        holder.mDatum.setText(String.valueOf(payment.getDatum()));
        holder.mPrijs.setText("€" + String.valueOf(decimalFormat.format(payment.getPrijs())));
    }

    public class PaymentViewHolder extends RecyclerView.ViewHolder {
        private TextView mDienst;
        private TextView mRondes;
        private TextView mMinuten;
        private TextView mTotaleMinuten;
        private TextView mTijdschema;
        private TextView mLeerniveau;
        private TextView mDatum;
        private TextView mPrijs;

        public PaymentViewHolder(@NonNull View view) {
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
            if (paymentData == null) {
                return 0;
            }
            return paymentData.size();
        }
}
