package com.example.ideplot

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ViewPlotActivity : AppCompatActivity() {

    // Deklarasi tampilan
    private lateinit var textViewPlotName: TextView
    private lateinit var textViewPlotLength: TextView
    private lateinit var textViewPlotDate: TextView
    private lateinit var textViewPlotDescription: TextView
    private lateinit var textViewPlotPoints: TextView
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_plot) // Mengatur layout untuk ViewPlotActivity

        // Inisialisasi tampilan
        textViewPlotName = findViewById(R.id.textViewPlotName)
        textViewPlotLength = findViewById(R.id.textViewPlotLength)
        textViewPlotDate = findViewById(R.id.textViewPlotDate)
        textViewPlotDescription = findViewById(R.id.textViewPlotDescription)
        textViewPlotPoints = findViewById(R.id.textViewPlotPoints)
        btnBack = findViewById(R.id.btnBack)

        // Mendapatkan data plot dari intent (dikirim dari AddPlotActivity)
        val plotName = intent.getStringExtra("PLOT_NAME")
        val plotLength = intent.getStringExtra("PLOT_LENGTH")
        val plotDate = intent.getStringExtra("PLOT_DATE") // Mengasumsikan tanggal dikirim sebagai string
        val plotDescription = intent.getStringExtra("PLOT_DESCRIPTION") // Deskripsi plot
        val plotPoints = intent.getStringExtra("PLOT_POINTS") // Poin penting dari plot

        // Validasi dan menampilkan data yang diterima ke tampilan text view masing-masing
        if (plotName.isNullOrEmpty() || plotLength.isNullOrEmpty() || plotDate.isNullOrEmpty()
            || plotDescription.isNullOrEmpty() || plotPoints.isNullOrEmpty()) {
            // Menampilkan pesan "Data tidak ada" jika salah satu data tidak tersedia
            textViewPlotName.text = "Data tidak ada"
            textViewPlotLength.text = "Data tidak ada"
            textViewPlotDate.text = "Data tidak ada"
            textViewPlotDescription.text = "Data tidak ada"
            textViewPlotPoints.text = "Data tidak ada"
        } else {
            // Mengatur data yang diterima ke tampilan text view masing-masing
            textViewPlotName.text = plotName
            textViewPlotLength.text = plotLength
            textViewPlotDate.text = plotDate
            textViewPlotDescription.text = plotDescription
            textViewPlotPoints.text = plotPoints
        }

        // Mengatur click listener untuk tombol kembali
        btnBack.setOnClickListener {
            finish() // Menutup aktivitas saat ini dan kembali ke aktivitas sebelumnya
        }
    }
}
