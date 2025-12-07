package com.example.hospitalmanagementsystem.AboutManage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class AboutsFragment extends Fragment {
RecyclerView recyclerViews;
ArrayList<AboutModelClass> aboutModelClassArrayList;
AboutAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_abouts, container, false);

          recyclerViews = view.findViewById(R.id.recyclerViews);
          aboutModelClassArrayList = new ArrayList<>();
          recyclerViews.setLayoutManager(new LinearLayoutManager(getContext()));
          adapter = new AboutAdapter(aboutModelClassArrayList,getContext());
          recyclerViews.setAdapter(adapter);

           GetAllInformation();

        return view;

    }

    public void GetAllInformation(){

        aboutModelClassArrayList.add(new AboutModelClass(R.drawable.student,"Introduce",
                                "Hi, I am Vivek.\n" +
                                "I am an Android & Full Stack Developer.\n" +
                                "I am passionate about Android development and building innovative mobile apps.\n" +
                                "Specializing in Kotlin and Java for Android applications.\n" +
                                "Experienced in Android Studio, Firebase, SQLite, Retrofit, and RESTful APIs.\n" +
                                "Knowledge of UI/UX design, Material Design, and responsive layouts.\n" +
                                "Familiar with version control using Git & GitHub, and agile development workflows.\n\n" +

                                "Phone\n" +
                                "9999847967\n\n" +

                                "Email:\n" +
                                "vivekchoudharyjaiswal15jan@gmail.com\n\n" +

                                "Age\n" +
                                "20\n\n" +

                                "Gender\n" +
                                "Male\n\n" +

                                "Address\n" +
                                "Uttar Pradesh, Noida\n"
                )
        );


        aboutModelClassArrayList.add(new AboutModelClass(R.drawable.education,"Education",
                "10th (CBSE) - 2021\n" +
                        "12th (CBSE) - Commerce - 2023\n" +
                        "School: Rajkiya Sarvodaya Bal Vidyalaya\n" +
                        "BCA - 5th Semester\n" +
                        "MCA\n" +
                        "Android Development with AI Developer focus"));



        aboutModelClassArrayList.add(new AboutModelClass(R.drawable.skill,"Skills",
                        "Java\n" +
                                "Kotlin\n" +
                                "Android Studio\n" +
                                "Firebase\n" +
                                "PHP\n" +
                                "MySQL\n" +
                                "SQLite\n" +
                                "Git\n" +
                                "Volley\n" +
                                "Retrofit\n" +
                                "Postman\n" +
                                "RESTful API\n" +
                                "SDK\n" +
                                "MVC\n"+
                                 "XML"));

        aboutModelClassArrayList.add(new AboutModelClass(R.drawable.experience, "Practical Experience",
                "Self-learned Android development, hands-on apps\n" +
                        "Built projects: Aarogya App, Login System, Dashboard UI\n" +
                        "Skills applied: Java, XML layouts, RecyclerView, Intents, GitHub\n" +
                        "Practiced UI/UX design and navigation flows\n" +
                        "Version control using GitHub for project management\n" +
                        "Familiar with testing apps on different devices/emulators\n" +
                        "Continuously exploring new Android libraries and APIs"
        ));


        aboutModelClassArrayList.add(new AboutModelClass(R.drawable.hobbies,"Hobbies",
                                "Learning new skills\n" +
                                "Listening to music\n" +
                                "Playing cricket\n" +
                                "Implementing new features\n" +
                                "Exploring new programming languages\n" +
                                "Watching tutorials / coding videos\n" +
                                "Traveling and exploring new places\n" +
                                "Contributing to open-source projects\n"));


        aboutModelClassArrayList.add(new AboutModelClass(R.drawable.career,"Career Goals",
                "Become a skilled Android Developer\n" +
                        "Work on innovative mobile app projects\n" +
                        "Learn advanced frameworks and technologies (AWS, MicroSoft Azure,Flutter, )\n" +
                        "Contribute to open-source projects\n" +
                        "Continuously improve programming and \n problem-solving skills"));


        aboutModelClassArrayList.add(new AboutModelClass(R.drawable.aarogyamgrremovebgpreview,
                        "Aarogyam – Project 1 Details",
                        "Aarogyam is a complete healthcare management mobile application designed to simulate real hospital operations. The project includes both User and Admin sides with multiple integrated modules.\n\n" +

                                "Key Modules Included:\n" +
                                ". *User Module* – Login/Signup, Profile, Appointments, HealDiet, Call Doctor, Medicine Reminder (Notification + Alarm), Billing Check, Pharmacy Info, Blood Request, Canteen Services, Lab & Medical Reports.\n\n" +

                                "• *Admin Module* – Hospital management, Add Doctor, Add Nurse, Add Staff, Pharmacy management, Medicine Orders, Medicine Return Policy, Delivery Staff, Canteen management, Billing/Cost management, Insurance Claim check.\n\n" +

                                "• *Ambulance / MediRide Module* – Add MediRide details, ambulance management, booking control.\n\n" +

                                "• *Blood Bank Module* – Add blood details, manage blood requests.\n\n" +

                                "• *Reports Module* – Add/View Medical Reports, Lab Reports, patient report tracking.\n\n" +

                                "• *UI & Navigation Layer* – Drawer Layout, Bottom Navigation Bar, Grid dashboard UI, material components, responsive XML layouts.\n\n" +

                                "• *Database Layer* – SQLite based dynamic storage for hospital, doctor, user, medicine, reports, billing, pharmacy, and emergency data.\n\n" +

                                "• *Extra Features* – Filter system, clean icons, smooth transitions, role-based access (Admin/User), GitHub profile link via Intent.\n\n" +

                                "This project is built for practical understanding of hospital workflow, admin operations, user services, and real-life Android app architecture.\n"
                ));

        aboutModelClassArrayList.add(new AboutModelClass(R.drawable.vidya,
                        "VidyaSetu – Project 2 Details",
                        "CampusHub is a complete College Management Android Application designed to simplify communication, student services, and administrative tasks. The system contains both Student and Admin modules with multiple interconnected services.\n\n" +

                                " Key Modules Included:\n" +

                                ". *Student Module* – Enter student number, student Gmail, check attendance, exam timetable, submit complaints, apply for leave, event updates (Sports Day), assignment details, notes section, and safety options.\n\n" +

                                "• *Teacher Module* – Teacher call feature, enter teacher details, enter teacher contact, teacher list, communication interface, and review management.\n\n" +

                                "• *Admin Module* – Add college details, add teacher details, add course details, add semester details, manage enquiry details for online admission, manage student details, manage complaints, attendance management, exam schedule updates.\n\n" +

                                "• *Academic Module* – Semester management, course management, attendance records, exam timetable updates, assignment upload & overview.\n\n" +

                                "• *Enquiry & Admission Module* – Online admission enquiry, enquiry status check, student data entry, and communication via call/email.\n\n" +

                                "• *Information & Review Module* – College review, student feedback, complaint application, event details, announcements.\n\n" +

                                "• *Communication Layer* – Direct call to teacher, send student Gmail via Intent, contact sharing, in-app communication functions.\n\n" +

                                "• *UI & Navigation Layer* – Modern grid dashboard UI, Bottom Navigation Bar (Home, Teacher Call, Notes, Safety), Drawer Navigation, material design layouts, colorful card components, responsive design.\n\n" +

                                "• *Database Layer* – SQLite database for managing students, teachers, courses, semesters, complaints, attendance, exams, and enquiry records.\n\n" +

                                "This project is developed to simulate the real working structure of a college, focusing on student services, teacher interaction, academic management, and administrative control.\n"
                ));



        aboutModelClassArrayList.add(new AboutModelClass(R.drawable.github,
                "GitHub Profile Click",
                "• Android Projects\n" +
                        "• Practice Applications\n" +
                        "• Source Code & Version Control\n" +
                        "• UI/UX Layout Designs\n" +
                        "• Learning Progress & Experiments\n\n" +
                        "Click to view my GitHub profile."));


        aboutModelClassArrayList.add(new AboutModelClass(R.drawable.linkedin,
                "LinkedIn Profile Click",
                "Checkout my professional profile, skills,\n" +
                        "education background and career goals.\n" +
                        "Let's connect on LinkedIn!"));


        aboutModelClassArrayList.add(new AboutModelClass(R.drawable.cv,
                "Resume Check",
                "Access my complete resume to explore my\n" +
                        "education, technical skills and project work."
        ));


    }

}