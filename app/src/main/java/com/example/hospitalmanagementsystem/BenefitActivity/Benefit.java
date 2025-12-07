package com.example.hospitalmanagementsystem.BenefitActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hospitalmanagementsystem.R;

import java.util.ArrayList;

public class Benefit extends AppCompatActivity {
RecyclerView recyclerViews;
ArrayList<BenefitModelClass> benefitModelClasses;
SearchView searchBar;
HealthBenefitAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_benefit);


        recyclerViews = findViewById(R.id.recyclerViews);
        searchBar = findViewById(R.id.searchBar);
        benefitModelClasses = new ArrayList<>();
        recyclerViews.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter  = new HealthBenefitAdapter(benefitModelClasses,getApplicationContext());
        recyclerViews.setAdapter(adapter);

        Uri data = getIntent().getData();
        if (data!=null){
            Toast.makeText(this, "Deep Link Ok"+data.toString(), Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Deep Link empty..", Toast.LENGTH_SHORT).show();
        }


        AllPackBenefit();


        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {
                SearchFilters(newText);
                return true;
            }

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void SearchFilters(String newText) {
      ArrayList<BenefitModelClass> Filters = new ArrayList<>();
      for (BenefitModelClass benefitModelClass:benefitModelClasses){
          if (benefitModelClass.getName().toLowerCase().contains(newText.toLowerCase())){
              Filters.add(benefitModelClass);
          }
      }
      if (Filters.isEmpty()){
          recyclerViews.setVisibility(View.GONE);
       }else {
          recyclerViews.setVisibility(View.VISIBLE);
          adapter.SetFilterLists(Filters);
       }
      adapter.notifyDataSetChanged();
    }

    public void AllPackBenefit(){

        benefitModelClasses.add(new BenefitModelClass("Immunity System","• Haldi milk daily.\n• Vitamin C fruits.\n• Probiotics.\n• Sleep well.\n• Walk daily.\n"));

        benefitModelClasses.add(new BenefitModelClass("Brain","• Almonds daily.\n• Meditation.\n• Omega-3 foods.\n• Good sleep.\n• No stress.\n"));

        benefitModelClasses.add(new BenefitModelClass("Heart","• Low salt.\n• 30-min walk.\n• Omega-3.\n• Avoid fried foods.\n• No stress.\n"));

        benefitModelClasses.add(new BenefitModelClass("Lungs","• Steam regularly.\n• Deep breathing.\n• Avoid pollution.\n• Ginger tea.\n• Hydrate well.\n"));

        benefitModelClasses.add(new BenefitModelClass("Liver","• Lemon water.\n• Beetroot juice.\n• Avoid alcohol.\n• Light diet.\n• Hydrate.\n"));

        benefitModelClasses.add(new BenefitModelClass("Kidneys","• Drink water.\n• Low salt.\n• Avoid soda.\n• Coconut water.\n• Light meals.\n"));

        benefitModelClasses.add(new BenefitModelClass("Stomach","• Jeera water.\n• Eat fiber.\n• Avoid spicy food.\n• Warm water.\n• Curd daily.\n"));

        benefitModelClasses.add(new BenefitModelClass("Intestines","• Fiber foods.\n• Probiotics.\n• Hydrate.\n• Avoid junk.\n• Fruits daily.\n"));

        benefitModelClasses.add(new BenefitModelClass("Pancreas","• Low sugar.\n• Green vegetables.\n• Light exercise.\n• Hydrate.\n• Avoid alcohol.\n"));

        benefitModelClasses.add(new BenefitModelClass("Gallbladder","• Low fat meals.\n• Lemon water.\n• High fiber.\n• Avoid oily food.\n• Walk daily.\n"));

        benefitModelClasses.add(new BenefitModelClass("Thyroid","• Iodine foods.\n• Avoid junk.\n• Sleep well.\n• Exercise.\n• Hydrate.\n"));

        benefitModelClasses.add(new BenefitModelClass("Skin","• Hydrate.\n• Aloe vera.\n• Sunscreen.\n• Clean face.\n• Vitamin C.\n"));

        benefitModelClasses.add(new BenefitModelClass("Hair","• Coconut oil.\n• Protein diet.\n• Mild shampoo.\n• Aloe vera.\n• Avoid hot water.\n"));

        benefitModelClasses.add(new BenefitModelClass("Nails","• Biotin foods.\n• Lemon rub.\n• Oil massage.\n• Avoid biting.\n• Keep clean.\n"));

        benefitModelClasses.add(new BenefitModelClass("Eyes","• Carrot juice.\n• 20-20-20 rule.\n• Eye wash.\n• Vitamin A.\n• Good sleep.\n"));

        benefitModelClasses.add(new BenefitModelClass("Ears","• Avoid loud music.\n• Clean lightly.\n• Use ear drops.\n• Avoid earbuds.\n• Dry properly.\n"));

        benefitModelClasses.add(new BenefitModelClass("Nose","• Steam.\n• Tulsi.\n• Hydrate.\n• Avoid dust.\n• Warm water.\n"));

        benefitModelClasses.add(new BenefitModelClass("Lips","• Ghee.\n• Scrub weekly.\n• Hydrate.\n• Avoid licking.\n• Aloe vera.\n"));

        benefitModelClasses.add(new BenefitModelClass("Teeth","• Brush twice.\n• Mouthwash.\n• Floss.\n• Avoid sweets.\n• Checkups.\n"));

        benefitModelClasses.add(new BenefitModelClass("Tongue","• Clean daily.\n• Hydrate.\n• Avoid spicy food.\n• Probiotics.\n• Salt-water rinse.\n"));

        benefitModelClasses.add(new BenefitModelClass("Back","• Stretching.\n• Warm compress.\n• Proper posture.\n• Walk daily.\n• Light exercise.\n"));

        benefitModelClasses.add(new BenefitModelClass("Spine","• Yoga.\n• Stretching.\n• Straight posture.\n• Avoid heavy lifting.\n• Sleep firm mattress.\n"));

        benefitModelClasses.add(new BenefitModelClass("Shoulders","• Stretching.\n• Massage.\n• Heat therapy.\n• Low weight exercise.\n• Good posture.\n"));

        benefitModelClasses.add(new BenefitModelClass("Arms","• Protein diet.\n• Push exercises.\n• Hydrate.\n• Massage.\n• Daily movement.\n"));

        benefitModelClasses.add(new BenefitModelClass("Hands","• Moisturizer.\n• Mild soap.\n• Gloves.\n• Scrub.\n• Sunscreen.\n"));

        benefitModelClasses.add(new BenefitModelClass("Fingers","• Oil massage.\n• Exercise.\n• Warm water soak.\n• Keep nails clean.\n• Light stretching.\n"));

        benefitModelClasses.add(new BenefitModelClass("Legs","• Walk daily.\n• Massage.\n• Stretch.\n• Hydrate.\n• Protein intake.\n"));

        benefitModelClasses.add(new BenefitModelClass("Knees","• Calcium foods.\n• Low impact exercise.\n• Warm compress.\n• Gentle stretching.\n• Omega-3.\n"));

        benefitModelClasses.add(new BenefitModelClass("Feet","• Warm soak.\n• Scrub.\n• Moisturize.\n• Wear soft shoes.\n• Keep dry.\n"));

        benefitModelClasses.add(new BenefitModelClass("Chest","• Deep breathing.\n• Steam.\n• Ginger tea.\n• Light stretching.\n• Good posture.\n"));

        benefitModelClasses.add(new BenefitModelClass("Lymph Nodes","• Hydrate.\n• Light massage.\n• Vitamin C.\n• Avoid infections.\n• Sleep well.\n"));

        benefitModelClasses.add(new BenefitModelClass("Blood","• Beetroot.\n• Iron rich foods.\n• Hydrate.\n• Exercise.\n• Green vegetables.\n"));

        benefitModelClasses.add(new BenefitModelClass("Muscles","• Protein.\n• Weight training.\n• Stretch.\n• Hydrate.\n• Rest properly.\n"));

        benefitModelClasses.add(new BenefitModelClass("Bones","• Calcium.\n• Vitamin D.\n• Sun exposure.\n• Exercise.\n• Avoid soda.\n"));

        benefitModelClasses.add(new BenefitModelClass("Joints","• Warm compress.\n• Turmeric.\n• Stretch daily.\n• Omega-3.\n• Gentle exercise.\n"));

        benefitModelClasses.add(new BenefitModelClass("Skin Pores","• Steam.\n• Scrub weekly.\n• Clay mask.\n• Hydrate.\n• Clean face.\n"));

        benefitModelClasses.add(new BenefitModelClass("Face","• Clean twice.\n• Hydrate.\n• Sunscreen.\n• Light moisturizer.\n• Vitamin C.\n"));

        benefitModelClasses.add(new BenefitModelClass("Cheeks","• Moisturizer.\n• Massage.\n• Hydrate.\n• Aloe gel.\n• Gentle scrub.\n"));

        benefitModelClasses.add(new BenefitModelClass("Neck","• Moisturize.\n• Sunscreen.\n• Massage.\n• Stretch.\n• Hydrate.\n"));

        benefitModelClasses.add(new BenefitModelClass("Jawline","• Face yoga.\n• Reduce sugar.\n• Hydrate.\n• Chewing exercise.\n• Cold water wash.\n"));

        benefitModelClasses.add(new BenefitModelClass("Forehead","• Aloe gel.\n• Massage.\n• Wash twice.\n• Avoid stress.\n• Sleep.\n"));

        benefitModelClasses.add(new BenefitModelClass("Shoulder Blades","• Stretch.\n• Heat therapy.\n• Good posture.\n• Deep breathing.\n• Light massage.\n"));

        benefitModelClasses.add(new BenefitModelClass("Ribs","• Light exercise.\n• Deep breathing.\n• Avoid heavy lifting.\n• Good posture.\n• Warm water.\n"));

        benefitModelClasses.add(new BenefitModelClass("Hips","• Hip stretches.\n• Walk daily.\n• Avoid long sitting.\n• Strength training.\n• Warm compress.\n"));

        benefitModelClasses.add(new BenefitModelClass("Pelvis","• Kegel exercises.\n• Hydrate.\n• Walk.\n• Proper posture.\n• Light yoga.\n"));

        benefitModelClasses.add(new BenefitModelClass("Reproductive System","• Hydrate.\n• Sleep.\n• Light exercise.\n• Balanced diet.\n• Avoid stress.\n"));

        benefitModelClasses.add(new BenefitModelClass("Prostate","• Hydrate.\n• Avoid alcohol.\n• Tomatoes.\n• Walk.\n• Fiber diet.\n"));

        benefitModelClasses.add(new BenefitModelClass("Uterus","• Warm water.\n• Folic acid.\n• Avoid stress.\n• Iron foods.\n• Hydrate.\n"));

        benefitModelClasses.add(new BenefitModelClass("Bladder","• Drink water.\n• Avoid caffeine.\n• Cranberry.\n• Empty fully.\n• Avoid holding urine.\n"));

        benefitModelClasses.add(new BenefitModelClass("Esophagus","• Eat slowly.\n• Avoid spicy.\n• Drink warm water.\n• No overeating.\n• Stay upright after meals.\n"));

        benefitModelClasses.add(new BenefitModelClass("Throat","• Warm water.\n• Ginger honey.\n• Steam.\n• Avoid cold items.\n• Salt-water gargle.\n"));

        benefitModelClasses.add(new BenefitModelClass("Voice Box","• Hydrate.\n• Avoid shouting.\n• Steam inhalation.\n• Warm water.\n• Honey.\n"));

        benefitModelClasses.add(new BenefitModelClass("Shoulder Joint","• Rotate daily.\n• Warm compress.\n• Light weight.\n• Good posture.\n• Stretch.\n"));

        benefitModelClasses.add(new BenefitModelClass("Ankles","• Rotate daily.\n• Warm water soak.\n• Massage.\n• Strengthen.\n• Walk carefully.\n"));

        benefitModelClasses.add(new BenefitModelClass("Heel","• Moisturize.\n• Foot soak.\n• Wear soft shoes.\n• Avoid standing long.\n• Scrub weekly.\n"));

        benefitModelClasses.add(new BenefitModelClass("Toes","• Keep clean.\n• Rectangle cut nails.\n• Foot soak.\n• Massage.\n• Dry properly.\n"));

        benefitModelClasses.add(new BenefitModelClass("Wrists","• Rotate.\n• Massage.\n• Avoid overuse.\n• Warm compress.\n• Strengthen.\n"));

        benefitModelClasses.add(new BenefitModelClass("Elbows","• Moisturize.\n• Scrub.\n• Avoid leaning.\n• Gentle stretching.\n• Vitamin E.\n"));

        benefitModelClasses.add(new BenefitModelClass("Armpits","• Clean daily.\n• Use lemon.\n• Wear cotton.\n• Avoid chemicals.\n• Hydrate.\n"));

        benefitModelClasses.add(new BenefitModelClass("Abdomen","• Light stretching.\n• Warm water.\n• Fiber diet.\n• Avoid overeating.\n• Walk after meals.\n"));

        benefitModelClasses.add(new BenefitModelClass("Lower Back","• Stretch.\n• Heat bag.\n• Good posture.\n• Walk.\n• Gentle exercise.\n"));

        benefitModelClasses.add(new BenefitModelClass("Upper Back","• Stretch.\n• Avoid slouching.\n• Massage.\n• Breathing exercises.\n• Strength training.\n"));

        benefitModelClasses.add(new BenefitModelClass("Shoulder Muscles","• Massage.\n• Stretching.\n• Avoid stress.\n• Hydrate.\n• Daily movement.\n"));

        benefitModelClasses.add(new BenefitModelClass("Hip Muscles","• Squats.\n• Stretch.\n• Walk daily.\n• Warm compress.\n• Strengthen.\n"));

        benefitModelClasses.add(new BenefitModelClass("Arm Muscles","• Protein.\n• Pushups.\n• Massage.\n• Hydrate.\n• Stretch.\n"));

        benefitModelClasses.add(new BenefitModelClass("Leg Muscles","• Walk.\n• Protein.\n• Stretch.\n• Massage.\n• Warm compress.\n"));

        benefitModelClasses.add(new BenefitModelClass("Stomach Muscles","• Core exercises.\n• Light stretching.\n• Hydrate.\n• Fiber foods.\n• Warm water.\n"));

        benefitModelClasses.add(new BenefitModelClass("Neck Muscles","• Rotate slowly.\n• Massage.\n• Proper posture.\n• Heat therapy.\n• Light stretching.\n"));

        benefitModelClasses.add(new BenefitModelClass("Forearm","• Wrist exercise.\n• Massage.\n• Stretch.\n• Proper grip.\n• Hydrate.\n"));

        benefitModelClasses.add(new BenefitModelClass("Shin Bone","• Calcium foods.\n• Exercise.\n• Warm compress.\n• Hydrate.\n• Avoid over-running.\n"));

        benefitModelClasses.add(new BenefitModelClass("Calf Muscles","• Stretch.\n• Massage.\n• Walk.\n• Hydrate.\n• Warm compress.\n"));

        benefitModelClasses.add(new BenefitModelClass("Lungs Airway","• Steam.\n• Ginger.\n• Warm water.\n• Avoid smoke.\n• Tulsi kadha.\n"));

        benefitModelClasses.add(new BenefitModelClass("Sinus","• Steam inhalation.\n• Avoid cold.\n• Ginger.\n• Salt rinse.\n• Warm water.\n"));

        benefitModelClasses.add(new BenefitModelClass("Colon","• Fiber.\n• Hydrate.\n• Fruits.\n• Probiotics.\n• Avoid junk.\n"));

        benefitModelClasses.add(new BenefitModelClass("Rectum","• Fiber foods.\n• Hydrate.\n• Avoid spicy.\n• Don’t strain.\n• Warm bath soak.\n"));

        benefitModelClasses.add(new BenefitModelClass("Anus","• Keep clean.\n• Warm bath.\n• Fiber.\n• Hydrate.\n• Avoid constipation.\n"));

        benefitModelClasses.add(new BenefitModelClass("Blood Vessels","• Omega-3.\n• Avoid sugar.\n• Hydrate.\n• Walk.\n• Fruits.\n"));

        benefitModelClasses.add(new BenefitModelClass("Cells","• Hydrate.\n• Sleep.\n• Nutrition.\n• Antioxidants.\n• Avoid junk.\n"));

        benefitModelClasses.add(new BenefitModelClass("Hormones","• Balanced diet.\n• Sleep.\n• Reduce stress.\n• No sugar.\n• Exercise.\n"));

        benefitModelClasses.add(new BenefitModelClass("Nervous System","• Meditation.\n• Almonds.\n• Good sleep.\n• Omega-3.\n• Light exercise.\n"));

        benefitModelClasses.add(new BenefitModelClass("Respiratory System","• Steam.\n• Deep breaths.\n• Avoid smoke.\n• Hydrate.\n• Ginger tea.\n"));

        benefitModelClasses.add(new BenefitModelClass("Circulatory System","• Walk.\n• Hydrate.\n• Iron foods.\n• Avoid fried.\n• Deep breathing.\n"));

        benefitModelClasses.add(new BenefitModelClass("Endocrine System","• Balanced diet.\n• Sleep.\n• Avoid stress.\n• Hydrate.\n• Light exercise.\n"));

        benefitModelClasses.add(new BenefitModelClass("Digestive System","• Fiber foods.\n• Warm water.\n• Avoid spicy.\n• Fruits.\n• Probiotics.\n"));

        benefitModelClasses.add(new BenefitModelClass("Urinary System","• Hydrate.\n• Cranberry.\n• Avoid caffeine.\n• Avoid holding urine.\n• Cleanliness.\n"));

        benefitModelClasses.add(new BenefitModelClass("Reproductive Organs","• Hydrate.\n• Sleep.\n• Balanced diet.\n• Exercise.\n• Avoid stress.\n"));

        benefitModelClasses.add(new BenefitModelClass("Cell Metabolism","• Green vegetables.\n• Hydrate.\n• Vitamins.\n• Fruits.\n• Sleep.\n"));

        benefitModelClasses.add(new BenefitModelClass("Skin Barrier","• Moisturizer.\n• Hydrate.\n• Avoid harsh soaps.\n• Vitamin E.\n• Light exfoliation.\n"));

        benefitModelClasses.add(new BenefitModelClass("Blood Pressure Control","• Low salt.\n• Walk.\n• Avoid stress.\n• Hydrate.\n• Fresh fruits.\n"));

        benefitModelClasses.add(new BenefitModelClass("Blood Sugar Control","• Zero sugar.\n• Fiber.\n• Walk.\n• Hydrate.\n• Vegetables.\n"));

        benefitModelClasses.add(new BenefitModelClass("Brain Memory","• Almonds.\n• Omega-3.\n• Meditation.\n• Sleep.\n• Avoid stress.\n"));

        benefitModelClasses.add(new BenefitModelClass("Bronchi","• Steam.\n• Ginger.\n• Avoid dust.\n• Warm water.\n• Deep breaths.\n"));

        benefitModelClasses.add(new BenefitModelClass("Windpipe","• Warm water.\n• Avoid cold.\n• Ginger honey.\n• Steam.\n• Hydrate.\n"));

        benefitModelClasses.add(new BenefitModelClass("Scalp","• Oil massage.\n• Shampoo lightly.\n• Avoid hot water.\n• Aloe vera.\n• Hydrate.\n"));

        benefitModelClasses.add(new BenefitModelClass("Tonsils","• Warm water.\n• Salt gargle.\n• Avoid cold.\n• Ginger.\n• Honey.\n"));

        benefitModelClasses.add(new BenefitModelClass("Appendix","• Fiber.\n• Avoid junk.\n• Hydrate.\n• Fruits.\n• Vegetables.\n"));

        benefitModelClasses.add(new BenefitModelClass("Small Intestine","• Fiber.\n• Hydrate.\n• Probiotics.\n• Fruits.\n• Avoid processed food.\n"));

        benefitModelClasses.add(new BenefitModelClass("Large Intestine","• Fruits.\n• Fiber.\n• Hydrate.\n• Avoid junk.\n• Exercise.\n"));

        benefitModelClasses.add(new BenefitModelClass("Spleen","• Beetroot.\n• Hydrate.\n• Iron foods.\n• Clean fruits.\n• Avoid infection.\n"));

        benefitModelClasses.add(new BenefitModelClass("Adrenal Glands","• Sleep.\n• Reduce stress.\n• Balanced diet.\n• Hydrate.\n• Magnesium foods.\n"));

    }
}