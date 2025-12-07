package com.example.hospitalmanagementsystem.InsuranceModule;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class ReadInsuranceClaimFragment extends Fragment {
RecyclerView RecyclerViews;
ArrayList<ModelClass> modelClassArrayList;
ClaimInsuranceAdapter claimInsuranceAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_check_claim, container, false);

           RecyclerViews = view.findViewById(R.id.RecyclerViews);
           modelClassArrayList = new ArrayList<>();
           RecyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));


          modelClassArrayList.add(new ModelClass(1,"1. Cashless Claim Process\n" +
                  "\n" +
                  "Definition:\n" +
                  "The insurance company settles the hospital bill directly if the hospital is in the insurer’s network.\n" +
                  "\n" +
                  "Steps:\n" +
                  "\n" +
                  "Step 1: Show your Health Insurance Card/Policy to the hospital’s TPA (Third Party Administrator) desk.\n" +
                  "\n" +
                  "Step 2: Fill out the pre-authorization form with the help of the hospital.\n" +
                  "\n" +
                  "Step 3: The hospital sends this form to the insurance company for approval.\n" +
                  "\n" +
                  "Step 4: Once approved, treatment begins without any payment from your side.\n" +
                  "\n" +
                  "Step 5: At the time of discharge, the insurer directly settles the bill with the hospital.\n" +
                  "\n" +
                  "Step 6: Any non-covered expenses (e.g., food, toiletries, etc.) must be paid by the patient."));

          modelClassArrayList.add(new ModelClass(2,"Reimbursement Claim Process\n" +
                  "\n" +
                  "Definition:\n" +
                  "If the hospital is not in the insurance company’s network, you pay first and get the money back later.\n" +
                  "\n" +
                  "Steps:\n" +
                  "\n" +
                  "Step 1: Take treatment and pay hospital bills yourself.\n" +
                  "\n" +
                  "Step 2: Collect all original documents (bills, reports, prescriptions, discharge summary).\n" +
                  "\n" +
                  "Step 3: Fill the reimbursement claim form from your insurer.\n" +
                  "\n" +
                  "Step 4: Submit all documents to the insurance company within the time frame (usually 7–30 days).\n" +
                  "\n" +
                  "Step 5: The insurance company reviews and processes your claim.\n" +
                  "\n" +
                  "Step 6: Approved amount is credited to your bank account."));

          modelClassArrayList.add(new ModelClass(3,"Documents Required for Insurance Claim\n" +
                  "\n" +
                  "For both cashless and reimbursement claims:\n" +
                  "\n" +
                  "Insurance Policy Copy / Health Card\n" +
                  "\n" +
                  "Doctor’s prescription and consultation notes\n" +
                  "\n" +
                  "Pharmacy bills and prescriptions\n" +
                  "\n" +
                  "Cancelled cheque (for reimbursement)\n" +
                  "\n" +
                  "Aadhar card / PAN card (for identification)\n" +
                  "\n" +
                  "FIR or Medico-Legal Case (MLC) report (if accident-related)"));

          modelClassArrayList.add(new ModelClass(4,"Rules and Important Guidelines\n" +
                  "\n" +
                  "Hospitalization must generally be for at least 24 hours (except for listed daycare procedures).\n" +
                  "\n" +
                  "Claim submission must be within the specified time limit (usually 7–30 days for reimbursement).\n" +
                  "\n" +
                  "Pre-authorization is mandatory for cashless treatment.\n" +
                  "\n" +
                  "Coverage is limited to the sum insured under the policy.\n" +
                  "\n" +
                  "Some illnesses have waiting periods (e.g., pre-existing diseases, maternity).\n" +
                  "\n" +
                  "Cosmetic surgery, dental treatment (unless accidental), and non-medical items (e.g., toiletries, gloves, sanitizers) are not covered.\n" +
                  "\n" +
                  "Submitting fake or manipulated bills can lead to claim rejection."));

          modelClassArrayList.add(new ModelClass(5,"Tips for Smooth Claim Processing\n" +
                  "\n" +
                  "Always read your policy terms and conditions carefully.\n" +
                  "\n" +
                  "Keep copies of all documents submitted to the insurance company.\n" +
                  "\n" +
                  "Contact your insurer’s helpline for any clarification."));

           claimInsuranceAdapter = new ClaimInsuranceAdapter(modelClassArrayList,getContext());
           RecyclerViews.setAdapter(claimInsuranceAdapter);


        return view;
    }
}