package com.example.homelayout.ui.shoppingcart;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.homelayout.R;
import com.example.homelayout.service.MollieAPI;
import com.example.homelayout.logic.Validation;

import java.util.concurrent.ExecutionException;

public class PaymentFragment extends Fragment {

    private String payment;
    private Button sendPaymentButton;
    private String link;
    private String description;
    private Validation validation;

    private EditText firstname;
    private EditText lastname;
    private EditText companyName;
    private EditText adres;
    private EditText location;
    private EditText postalCode;
    private EditText phonenumber;
    private EditText email;
    private EditText cjp;


    public PaymentFragment(String payment) {
        this.payment = payment;
        description = "Is ie betaald";
        validation = new Validation();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_payment_screen, container, false);
        initializeElements(root);

        sendPaymentButton = root.findViewById(R.id.btn_payment);
        sendPaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(checkForm(container)){
                        link = new MollieAPI(payment,description).execute().get();
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(link));
                        startActivity(i);
                    }else{
                        throw new Exception("niet genoeg informatie");
                    }
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        return root;
    }

    private void initializeElements(View root){
        firstname = (EditText) root.findViewById(R.id.et_payment_firstname);
        lastname = (EditText) root.findViewById(R.id.et_payment_lastname);
        companyName = (EditText) root.findViewById(R.id.et_payment_company_name);
        adres = (EditText) root.findViewById(R.id.et_payment_adres);
        location = (EditText) root.findViewById(R.id.et_payment_place);
        postalCode = (EditText) root.findViewById(R.id.et_payment_postalcode);
        phonenumber = (EditText) root.findViewById(R.id.et_payment_phone);
        email = (EditText) root.findViewById(R.id.et_payment_email);
        cjp = (EditText) root.findViewById(R.id.et_payment_cjp);
    }

    private boolean checkForm(ViewGroup container){
        if (firstname.getText().toString().length() == 0 || !(validation.validateName(firstname.getText().toString()))) {
            showpopup(container);
            return false;
        } else if (lastname.getText().toString().length() == 0 || !(validation.validateName(lastname.getText().toString()))) {
            showpopup(container);
            return false;
        } else if (adres.getText().toString().length() == 0) {
            showpopup(container);
            return false;
        } else if (location.getText().toString().length() == 0 || !(validation.validateName(location.getText().toString()))) {
            showpopup(container);
            return false;
        } else if (postalCode.getText().toString().length() == 0 || !(validation.validatePostalCode(postalCode.getText().toString()))) {
            showpopup(container);
            return false;
        } else if (phonenumber.getText().toString().length() == 0 || !(validation.validatePhonenumber(phonenumber.getText().toString()))) {
            showpopup(container);
            return false;
        } else if (email.getText().toString().length() == 0 || !(validation.validateEmail(email.getText().toString()))) {
            showpopup(container);
            return false;
        }else {
            return true;
        }
    }

    private void showpopup(ViewGroup container){
        Context con = container.getContext();
        AlertDialog.Builder infopopup = new AlertDialog.Builder(con);
        infopopup.setCancelable(true);
        infopopup.setTitle("Niet alles juist ingevuld!");
        infopopup.setMessage("Niet alles juist ingevuld");
        infopopup.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        infopopup.show();
    }
}
