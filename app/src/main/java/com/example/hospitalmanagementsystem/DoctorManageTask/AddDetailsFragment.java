package com.example.hospitalmanagementsystem.DoctorManageTask;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class AddDetailsFragment extends Fragment {
    EditText EdName,EdEmail,EdPhone;
    Button BtnSubmit;
    Spinner SpinExperience,SpinAvailable,SpinAvailableTime,SpinSpecial,SpinQualification;
    DoctorDataBase doctorDataBase;
    String Qualification,AvailableDay,AvailableTime,Specialist,YearExperiences;
    String name,email,phone;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
          View view = inflater.inflate(R.layout.fragment_add_doctor_details, container, false);


        EdName = view.findViewById(R.id.EdName);
        EdEmail = view.findViewById(R.id.EdEmail);
        SpinQualification = view.findViewById(R.id.SpinQualification);
        SpinExperience = view.findViewById(R.id.SpinExperience);
        SpinSpecial = view.findViewById(R.id.SpinSpecial);
        SpinAvailable = view.findViewById(R.id.SpinAvailable);
        SpinAvailableTime = view.findViewById(R.id.SpinAvailableTime);
        EdPhone = view.findViewById(R.id.EdPhone);
        BtnSubmit = view.findViewById(R.id.BtnSubmit);
        doctorDataBase = new DoctorDataBase(getContext());

        SelectSpecial();
        SelectDoctorExperience();
        SelectAvailableDay();
        SelectAvailableTime();
        SelectQualification();


        BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertDoctorData();
            }
        });

        SpinQualification.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Qualification = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SpinExperience.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                YearExperiences = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SpinSpecial.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Specialist = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SpinAvailable.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AvailableDay = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SpinAvailableTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AvailableTime = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return view;
    }
    public void SelectQualification(){
        ArrayList<String> quals = new ArrayList<>();

        // Simple abbreviations (some users like short form)
        quals.add("Please Select Qualification");
        quals.add("MBBS");
        quals.add("MD");
        quals.add("MS");
        quals.add("DNB");
        quals.add("DM");
        quals.add("MCh");
        quals.add("MDS");
        quals.add("PhD");

        // Undergraduate / basic
        quals.add("MBBS (Bachelor of Medicine, Bachelor of Surgery)");
        quals.add("BDS (Bachelor of Dental Surgery)");
        quals.add("BHMS (Bachelor of Homeopathic Medicine & Surgery)");
        quals.add("BAMS (Bachelor of Ayurvedic Medicine & Surgery)");
        quals.add("BUMS (Unani Medicine)");
        quals.add("BPTh / BPT (Bachelor of Physiotherapy)");

        // Postgraduate / specialist
        quals.add("MD (Doctor of Medicine)");
        quals.add("MS (Master of Surgery)");
        quals.add("MCh (Magister Chirurgiae / Super-speciality Surgery)");
        quals.add("DM (Doctorate of Medicine / Super-speciality)");
        quals.add("MDS (Master of Dental Surgery)");
        quals.add("MSc (Medical Sciences)");
        quals.add("MPharm / PharmD");

        // Diplomas & Certificates
        quals.add("Diploma (e.g., DGO, DCH, DCP, DNB Diploma)");
        quals.add("Postgraduate Diploma (PG Diploma in various specialities)");
        quals.add("Fellowship (Clinical Fellowship / Observership)");
        quals.add("Certificate Course");

        // National Board / equivalents
        quals.add("DNB (Diplomate of National Board)");
        quals.add("DrNB (Doctorate by National Board)");

        // International / professional memberships
        quals.add("FRCS (Fellow of the Royal College of Surgeons)");
        quals.add("MRCP (Member of the Royal College of Physicians)");
        quals.add("MRCS (Member of the Royal College of Surgeons)");
        quals.add("FACP / FCCP (Fellowship - US / Intl)");
        quals.add("PhD (Doctor of Philosophy)");

        // Others / allied
        quals.add("MD(Res) / MPhil (Research degrees)");
        quals.add("ED (Emergency Medicine specific certificates)");
        quals.add("MBA (Hospital Management / Health Management)");
        quals.add("PG Diploma in Hospital Administration");
        quals.add("Clinical Instructor / Professor / Consultant (titles)");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,quals);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        SpinQualification.setAdapter(arrayAdapter);

    }
    public void SelectSpecial(){
        ArrayList<String> SelectSpecial = new ArrayList<>();
        // 🔹 Basic Days
        SelectSpecial.add("Please Select Specialist");
        SelectSpecial.add("Allopathy");
        SelectSpecial.add("Homeopathy");
        SelectSpecial.add("Ayurveda");
        SelectSpecial.add("Unani");
        SelectSpecial.add("Naturopathy");
        SelectSpecial.add("Physiotherapy");
        SelectSpecial.add("Dentistry / BDS");
        SelectSpecial.add("Cardiology");
        SelectSpecial.add("Interventional Cardiology");
        SelectSpecial.add("Neurology");
        SelectSpecial.add("Neurosurgery");
        SelectSpecial.add("Orthopedics");
        SelectSpecial.add("Spine Surgery");
        SelectSpecial.add("Gastroenterology");
        SelectSpecial.add("Hepatology");
        SelectSpecial.add("Dermatology");
        SelectSpecial.add("Cosmetic Dermatology");
        SelectSpecial.add("Endocrinology");
        SelectSpecial.add("Diabetology");
        SelectSpecial.add("ENT / Otolaryngology");
        SelectSpecial.add("Ophthalmology");
        SelectSpecial.add("Retina Specialist");
        SelectSpecial.add("Obstetrics & Gynecology");
        SelectSpecial.add("Pediatrics");
        SelectSpecial.add("Neonatology");
        SelectSpecial.add("Pulmonology / Respiratory");
        SelectSpecial.add("Sleep Medicine");
        SelectSpecial.add("Psychiatry / Mental Health");
        SelectSpecial.add("Child & Adolescent Psychiatry");
        SelectSpecial.add("Urology");
        SelectSpecial.add("Nephrology");
        SelectSpecial.add("Oncology / Cancer Specialist");
        SelectSpecial.add("Radiation Oncology");
        SelectSpecial.add("Rheumatology");
        SelectSpecial.add("General Surgery");
        SelectSpecial.add("Plastic Surgery / Cosmetic");
        SelectSpecial.add("Vascular Surgery");
        SelectSpecial.add("Anesthesiology");
        SelectSpecial.add("Emergency / Critical Care");
        SelectSpecial.add("Pathology / Lab Medicine");
        SelectSpecial.add("Histopathology");
        SelectSpecial.add("Radiology / Imaging");
        SelectSpecial.add("Interventional Radiology");
        SelectSpecial.add("Physician / General Medicine");
        SelectSpecial.add("Geriatrics / Elderly Care");
        SelectSpecial.add("Sports Medicine");
        SelectSpecial.add("Palliative Care / Pain Management");
        SelectSpecial.add("Infectious Diseases");
        SelectSpecial.add("Allergy & Immunology");
        SelectSpecial.add("Occupational Medicine");
        SelectSpecial.add("Clinical Pharmacology");
        SelectSpecial.add("Medical Genetics");
        SelectSpecial.add("Preventive Medicine");
        SelectSpecial.add("Clinical Nutrition");
        SelectSpecial.add("Diabetes & Endocrine Surgery");
        SelectSpecial.add("Hematology");
        SelectSpecial.add("Bone Marrow Transplant");
        SelectSpecial.add("Cardiothoracic Surgery");
        SelectSpecial.add("Pediatric Surgery");
        SelectSpecial.add("Neonatal Surgery");
        SelectSpecial.add("Thoracic Surgery");
        SelectSpecial.add("Hand Surgery");
        SelectSpecial.add("Maxillofacial Surgery");
        SelectSpecial.add("Audiology / Speech Therapy");
        SelectSpecial.add("Rehabilitation Medicine");
        SelectSpecial.add("Obstetric Anesthesia");
        SelectSpecial.add("Intensive Care / ICU");
        SelectSpecial.add("Sleep Disorder Specialist");
        SelectSpecial.add("Clinical Psychology");
        SelectSpecial.add("Addiction Medicine");
        SelectSpecial.add("Emergency Medicine");
        SelectSpecial.add("Transplant Surgery");
        SelectSpecial.add("Endovascular Surgery");
        SelectSpecial.add("Neurointervention");
        SelectSpecial.add("Ophthalmic Surgery");
        SelectSpecial.add("Cardiac Electrophysiology");
        SelectSpecial.add("Pediatric Cardiology");
        SelectSpecial.add("Interventional Pulmonology");
        SelectSpecial.add("Gastrointestinal Surgery");
        SelectSpecial.add("Liver Transplant Specialist");
        SelectSpecial.add("Kidney Transplant Specialist");
        SelectSpecial.add("Dermatosurgery");
        SelectSpecial.add("Cosmetic Surgery / Aesthetic Medicine");
        SelectSpecial.add("Reproductive Medicine / IVF");
        SelectSpecial.add("Maternal Fetal Medicine");
        SelectSpecial.add("Neurorehabilitation");


        ArrayAdapter<String> arrayAdapterSpecial = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,SelectSpecial);
        arrayAdapterSpecial.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        SpinSpecial.setAdapter(arrayAdapterSpecial);


    }
    public void SelectDoctorExperience(){

        ArrayList<String> SelectExperience = new ArrayList<>();

        SelectExperience.add("Please Select Experience");
        SelectExperience.add("1 Year Of Experience");
        SelectExperience.add("2 Years Of Experience");
        SelectExperience.add("3 Years Of Experience");
        SelectExperience.add("4 Years Of Experience");
        SelectExperience.add("5 Years Of Experience");
        SelectExperience.add("6 Years Of Experience");
        SelectExperience.add("7 Years Of Experience");
        SelectExperience.add("8 Years Of Experience");
        SelectExperience.add("9 Years Of Experience");
        SelectExperience.add("10 Years Of Experience");
        SelectExperience.add("11 Years Of Experience");
        SelectExperience.add("12 Years Of Experience");
        SelectExperience.add("13 Years Of Experience");
        SelectExperience.add("14 Years Of Experience");
        SelectExperience.add("15 Years Of Experience");
        SelectExperience.add("16 Years Of Experience");
        SelectExperience.add("17 Years Of Experience");
        SelectExperience.add("18 Years Of Experience");
        SelectExperience.add("19 Years Of Experience");
        SelectExperience.add("20 Years Of Experience");
        SelectExperience.add("21 Years Of Experience");
        SelectExperience.add("22 Years Of Experience");
        SelectExperience.add("23 Years Of Experience");
        SelectExperience.add("24 Years Of Experience");
        SelectExperience.add("25 Years Of Experience");
        SelectExperience.add("26 Years Of Experience");
        SelectExperience.add("27 Years Of Experience");
        SelectExperience.add("28 Years Of Experience");
        SelectExperience.add("29 Years Of Experience");
        SelectExperience.add("30 Years Of Experience");
        SelectExperience.add("31 Years Of Experience");
        SelectExperience.add("32 Years Of Experience");
        SelectExperience.add("33 Years Of Experience");
        SelectExperience.add("34 Years Of Experience");
        SelectExperience.add("35 Years Of Experience");
        SelectExperience.add("36 Years Of Experience");
        SelectExperience.add("37 Years Of Experience");
        SelectExperience.add("38 Years Of Experience");
        SelectExperience.add("39 Years Of Experience");
        SelectExperience.add("40 Years Of Experience");
        SelectExperience.add("41 Years Of Experience");
        SelectExperience.add("42 Years Of Experience");
        SelectExperience.add("43 Years Of Experience");
        SelectExperience.add("44 Years Of Experience");
        SelectExperience.add("45 Years Of Experience");
        SelectExperience.add("46 Years Of Experience");
        SelectExperience.add("47 Years Of Experience");
        SelectExperience.add("48 Years Of Experience");
        SelectExperience.add("49 Years Of Experience");
        SelectExperience.add("50 Years Of Experience");


        ArrayAdapter<String>   arrayAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,SelectExperience);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        SpinExperience.setAdapter(arrayAdapter);
    }
    public void SelectAvailableDay(){
        ArrayList<String> SelectDay = new ArrayList<>();
        // 🔹 Basic Days
        SelectDay.add("Please Select Available Day");
        SelectDay.add("All Days");
        SelectDay.add("Sun");
        SelectDay.add("Mon");
        SelectDay.add("Tue");
        SelectDay.add("Wed");
        SelectDay.add("Thu");
        SelectDay.add("Fri");
        SelectDay.add("Sat");

// 🔹 Common Combinations
        SelectDay.add("Mon,Wed,Fri");
        SelectDay.add("Tue,Thu,Sat");
        SelectDay.add("Sat,Sun");
        SelectDay.add("Sun,Mon");
        SelectDay.add("Mon,Tue,Wed,Thu,Fri");
        SelectDay.add("Mon,Tue,Wed,Thu,Fri,Sat");
        SelectDay.add("Mon,Wed");
        SelectDay.add("Tue,Thu");
        SelectDay.add("Sun,Fri");
        SelectDay.add("Sun,Wed");
        SelectDay.add("Sun,Thu");
        SelectDay.add("Weekends (Sat,Sun)");

// 🔹 All 3-Day Combinations (Total 35)
        SelectDay.add("Sun,Mon,Tue");
        SelectDay.add("Sun,Mon,Wed");
        SelectDay.add("Sun,Mon,Thu");
        SelectDay.add("Sun,Mon,Fri");
        SelectDay.add("Sun,Mon,Sat");
        SelectDay.add("Sun,Tue,Wed");
        SelectDay.add("Sun,Tue,Thu");
        SelectDay.add("Sun,Tue,Fri");
        SelectDay.add("Sun,Tue,Sat");
        SelectDay.add("Sun,Wed,Thu");
        SelectDay.add("Sun,Wed,Fri");
        SelectDay.add("Sun,Wed,Sat");
        SelectDay.add("Sun,Thu,Fri");
        SelectDay.add("Sun,Thu,Sat");
        SelectDay.add("Sun,Fri,Sat");
        SelectDay.add("Mon,Tue,Wed");
        SelectDay.add("Mon,Tue,Thu");
        SelectDay.add("Mon,Tue,Fri");
        SelectDay.add("Mon,Tue,Sat");
        SelectDay.add("Mon,Wed,Thu");
        SelectDay.add("Mon,Wed,Fri");
        SelectDay.add("Mon,Wed,Sat");
        SelectDay.add("Mon,Thu,Fri");
        SelectDay.add("Mon,Thu,Sat");
        SelectDay.add("Mon,Fri,Sat");
        SelectDay.add("Tue,Wed,Thu");
        SelectDay.add("Tue,Wed,Fri");
        SelectDay.add("Tue,Wed,Sat");
        SelectDay.add("Tue,Thu,Fri");
        SelectDay.add("Tue,Thu,Sat");
        SelectDay.add("Tue,Fri,Sat");
        SelectDay.add("Wed,Thu,Fri");
        SelectDay.add("Wed,Thu,Sat");
        SelectDay.add("Wed,Fri,Sat");
        SelectDay.add("Thu,Fri,Sat");

// 🔹 All 4-Day Combinations (Total 35)
        SelectDay.add("Sun,Mon,Tue,Wed");
        SelectDay.add("Sun,Mon,Tue,Thu");
        SelectDay.add("Sun,Mon,Tue,Fri");
        SelectDay.add("Sun,Mon,Tue,Sat");
        SelectDay.add("Sun,Mon,Wed,Thu");
        SelectDay.add("Sun,Mon,Wed,Fri");
        SelectDay.add("Sun,Mon,Wed,Sat");
        SelectDay.add("Sun,Mon,Thu,Fri");
        SelectDay.add("Sun,Mon,Thu,Sat");
        SelectDay.add("Sun,Mon,Fri,Sat");
        SelectDay.add("Sun,Tue,Wed,Thu");
        SelectDay.add("Sun,Tue,Wed,Fri");
        SelectDay.add("Sun,Tue,Wed,Sat");
        SelectDay.add("Sun,Tue,Thu,Fri");
        SelectDay.add("Sun,Tue,Thu,Sat");
        SelectDay.add("Sun,Tue,Fri,Sat");
        SelectDay.add("Sun,Wed,Thu,Fri");
        SelectDay.add("Sun,Wed,Thu,Sat");
        SelectDay.add("Sun,Wed,Fri,Sat");
        SelectDay.add("Sun,Thu,Fri,Sat");
        SelectDay.add("Mon,Tue,Wed,Thu");
        SelectDay.add("Mon,Tue,Wed,Fri");
        SelectDay.add("Mon,Tue,Wed,Sat");
        SelectDay.add("Mon,Tue,Thu,Fri");
        SelectDay.add("Mon,Tue,Thu,Sat");
        SelectDay.add("Mon,Tue,Fri,Sat");
        SelectDay.add("Mon,Wed,Thu,Fri");
        SelectDay.add("Mon,Wed,Thu,Sat");
        SelectDay.add("Mon,Wed,Fri,Sat");
        SelectDay.add("Mon,Thu,Fri,Sat");
        SelectDay.add("Tue,Wed,Thu,Fri");
        SelectDay.add("Tue,Wed,Thu,Sat");
        SelectDay.add("Tue,Wed,Fri,Sat");
        SelectDay.add("Tue,Thu,Fri,Sat");
        SelectDay.add("Wed,Thu,Fri,Sat");

        ArrayAdapter<String> arrayAdapterDay = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,SelectDay);
        arrayAdapterDay.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        SpinAvailable.setAdapter(arrayAdapterDay);


    }
    public void SelectAvailableTime(){
        ArrayList<String> SelectTime = new ArrayList<>();

        SelectTime.add("Please Select Available Time");
        SelectTime.add("Morning (medium): 06:00 - 09:00");
        SelectTime.add("Morning (medium): 07:00 - 10:00");
        SelectTime.add("Morning (early): 08:00 - 11:00");
        SelectTime.add("Morning (standard): 09:00 - 12:00");
        SelectTime.add("Morning (most common): 10:00 - 13:00");
        SelectTime.add("Noon (medium): 11:00 - 14:00");

        SelectTime.add("Noon (medium): 12:00 - 15:00");
        SelectTime.add("Afternoon (medium): 13:00 - 16:00");
        SelectTime.add("Afternoon (common): 14:00 - 17:00");
        SelectTime.add("Afternoon (medium): 15:00 - 18:00");
        SelectTime.add("Evening (standard): 16:00 - 19:00");

        SelectTime.add("Evening (very common): 17:00 - 20:00");
        SelectTime.add("Evening (common): 18:00 - 21:00");
        SelectTime.add("Late Evening (rare): 19:00 - 22:00");
        SelectTime.add("Night (medium): 20:00 - 23:00");

        SelectTime.add("Night (rare): 21:00 - 24:00");
        SelectTime.add("Night (rare): 22:00 - 01:00");
        SelectTime.add("Emergency (rare): 23:00 - 02:00");
        SelectTime.add("24x7 Emergency: Continuous");


        ArrayAdapter<String> arrayAdapterTime = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,SelectTime);
        arrayAdapterTime.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        SpinAvailableTime.setAdapter(arrayAdapterTime);

    }
    public void InsertDoctorData(){
        name = EdName.getText().toString();
        email = EdEmail.getText().toString();
        phone = EdPhone.getText().toString();

        if (name.isEmpty()){
            EdName.requestFocus();
            EdName.setError("Name Can't Empty...");
            return;
        } else if (!name.matches("[a-zA-Z ]+")) {
            EdName.requestFocus();
            EdName.setError("Invalid Name Try Again...");
            return;
        } else if (email.isEmpty()) {
            EdEmail.requestFocus();
            EdEmail.setError("Email Id Can't Empty...");
            return;
        } else if (!email.matches("[a-zA-Z0-9]+[@][a-z]+[.][a-z]+")) {
            EdEmail.requestFocus();
            EdEmail.setError("Invalid Email Try Again...");
            return;
        } else if (phone.isEmpty()) {
            EdPhone.requestFocus();
            EdPhone.setError("Phone Number Can't Empty");
            return;
        } else if (!phone.matches("[0-9]+\\d{9}")) {
            EdPhone.requestFocus();
            EdPhone.setError("Invalid Try Again...");
            return;
        } if (Qualification.equals("Please Select Qualification")){
            Toast.makeText(getContext(), "Please Select Valid Option", Toast.LENGTH_SHORT).show();
            return;
        } if (YearExperiences.equals("Please Select Experience")){
            Toast.makeText(getContext(), "Please Select Valid Option", Toast.LENGTH_SHORT).show();
            return;
        } if (Specialist.equals("Please Select Specialist")){
            Toast.makeText(getContext(), "Please Select Valid Option", Toast.LENGTH_SHORT).show();
            return;
        } if (AvailableDay.equals("Please Select Available Day")){
            Toast.makeText(getContext(), "Please Select Valid Option", Toast.LENGTH_SHORT).show();
            return;
        } if (AvailableTime.equals("Please Select Available Time")){
            Toast.makeText(getContext(), "Please Select Valid Option", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean b = doctorDataBase.InsertDoctorData(name,email,Qualification,YearExperiences,Specialist,AvailableDay,AvailableTime,phone);
        if (b==true){
            Toast.makeText(getContext(), "Insert SuccessFully...", Toast.LENGTH_SHORT).show();
            EdName.setText("");
            EdEmail.setText("");
            EdPhone.setText("");
            SpinQualification.setSelection(0);
            SpinExperience.setSelection(0);
            SpinSpecial.setSelection(0);
            SpinAvailable.setSelection(0);
            SpinAvailableTime.setSelection(0);
        } else {
            Toast.makeText(getContext(), "Insert Data Failed...", Toast.LENGTH_SHORT).show();
        }
    }
}