package com.example.netclanexplorerapp

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.netclanexplorerapp.models.PurposeModel
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.slider.LabelFormatter
import com.google.android.material.slider.Slider
import com.google.android.material.textfield.TextInputLayout

class RefineActivity : AppCompatActivity() {

    private val selectedChips = ArrayList<Chip>()
    private lateinit var currentAvailability: String
    private lateinit var currentStatus: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_refine)

        //chips
        val coffee: Chip = findViewById(R.id.chipCoffee)
        val business: Chip = findViewById(R.id.chipBusiness)
        val hobbies: Chip = findViewById(R.id.chipHobbies)
        val friendship: Chip = findViewById(R.id.chipFriendship)
        val movies: Chip = findViewById(R.id.chipMovies)
        val dining: Chip = findViewById(R.id.chipDinning)
        val dating: Chip = findViewById(R.id.chipDating)
        val matrimony: Chip = findViewById(R.id.chipMatrimony)

        //
        val saveAndExploreBtn: Button = findViewById(R.id.savAndExploreBtn)
        val availability: AutoCompleteTextView = findViewById(R.id.availability)
        val status: EditText = findViewById(R.id.etStatus)
        //

        coffee.isChecked = true
        business.isChecked = true
        hobbies.isChecked = true

        selectedChips.add(coffee)
        selectedChips.add(business)
        selectedChips.add(hobbies)

        //

        coffee.setOnClickListener { onChipClicked(coffee) }
        business.setOnClickListener { onChipClicked(business) }
        hobbies.setOnClickListener { onChipClicked(hobbies) }
        friendship.setOnClickListener { onChipClicked(friendship) }
        movies.setOnClickListener { onChipClicked(movies) }
        dining.setOnClickListener { onChipClicked(dining) }
        dating.setOnClickListener { onChipClicked(dating) }
        matrimony.setOnClickListener { onChipClicked(matrimony) }

        //

        val textField: TextInputLayout = findViewById(R.id.textField)
        val slider: Slider = findViewById(R.id.slider)
        slider.setLabelFormatter {
            (it.toInt()).toString()
        }

        val items = listOf("Available | Hey Let Us Connect", "Away | Stay Discrete And Watch", "Busy | Do Not Disturb | Will Catch Up Later", "SOS | Emergency! Need Assistance! HELP")
        val adapter = ArrayAdapter(applicationContext , android.R.layout.simple_list_item_1, items)

        (textField.editText as? AutoCompleteTextView)?.setText(items.get(0))
        (textField.editText as? AutoCompleteTextView)?.setAdapter(adapter)

        saveAndExploreBtn.setOnClickListener {
            currentAvailability = availability.text.toString()
            currentStatus = status.text.toString()

            val intent: Intent = Intent(this@RefineActivity , MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun onChipClicked(chip: Chip) {
        if (selectedChips.contains(chip)) {
            // If the Chip is already in the list, remove it
            selectedChips.remove(chip)
        } else {
            // If the Chip is not in the list, add it
            selectedChips.add(chip)
        }

        // Update the appearance of the Chip (e.g., change the background color)
        chip.isChecked = selectedChips.contains(chip)

    }
}