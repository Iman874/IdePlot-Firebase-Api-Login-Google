package com.example.ideplot

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class AddPlotActivity : AppCompatActivity() {

    // Declare views
    private lateinit var spinnerPlotLength: Spinner
    private lateinit var editTextPlotName: EditText
    private lateinit var editTextPlotDescription: EditText
    private lateinit var editTextImportantPoints: EditText
    private lateinit var btnSavePlot: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_plot) // Set the layout for AddPlotActivity

        // Initialize views
        spinnerPlotLength = findViewById(R.id.spinnerPlotLength)
        editTextPlotName = findViewById(R.id.editTextPlotName)
        editTextPlotDescription = findViewById(R.id.editTextPlotDescription)
        editTextImportantPoints = findViewById(R.id.editTextImportantPoints)
        btnSavePlot = findViewById(R.id.btnSavePlot)

        // Set up the spinner for plot length options
        val plotLengths = resources.getStringArray(R.array.plot_lengths)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, plotLengths)
        spinnerPlotLength.adapter = adapter

        // Set click listener for the save button
        btnSavePlot.setOnClickListener {
            savePlot()
        }
    }

    // Fungsi savePlot
    private fun savePlot() {
        val plotLength = spinnerPlotLength.selectedItem.toString()
        val plotName = editTextPlotName.text.toString().trim()
        val plotDescription = editTextPlotDescription.text.toString().trim()
        val importantPoints = editTextImportantPoints.text.toString().trim()

        if (plotName.isEmpty() || plotDescription.isEmpty() || importantPoints.isEmpty()) {
            Toast.makeText(this, "Harap isi semua kolom", Toast.LENGTH_SHORT).show()
            return
        }

        // Mendapatkan tanggal saat ini secara dinamis
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val plotDate = dateFormat.format(java.util.Date())

        // Membuat Intent untuk memulai ViewPlotActivity dan mengirim data plot
        val intent = Intent(this, ViewPlotActivity::class.java).apply {
            putExtra("PLOT_NAME", plotName)
            putExtra("PLOT_LENGTH", plotLength)
            putExtra("PLOT_DATE", plotDate) // Mengirim tanggal sebagai string
            putExtra("PLOT_DESCRIPTION", plotDescription) // Mengirim deskripsi plot
            putExtra("PLOT_POINTS", importantPoints) // Mengirim poin penting plot
        }
        startActivity(intent)

        // Menghapus isi kolom setelah menyimpan
        clearInputFields()
    }

    // Function to clear input fields after saving
    private fun clearInputFields() {
        editTextPlotName.text.clear()
        editTextPlotDescription.text.clear()
        editTextImportantPoints.text.clear()
        spinnerPlotLength.setSelection(0)
    }
}
