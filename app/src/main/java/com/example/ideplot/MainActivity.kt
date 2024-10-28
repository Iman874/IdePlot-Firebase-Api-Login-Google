    package com.example.ideplot

    import android.annotation.SuppressLint
    import android.content.Intent
    import android.os.Bundle
    import android.widget.TextView
    import androidx.appcompat.app.AppCompatActivity
    import androidx.core.view.ViewCompat
    import androidx.core.view.WindowInsetsCompat
    import com.google.android.material.button.MaterialButton

    class MainActivity : AppCompatActivity() {
        @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            // Ambil nama depan dari Intent
            val namaDepan = intent.getStringExtra("NAMA_DEPAN") ?: "Guest"

            // Set nilai ke TextView
            val textView: TextView = findViewById(R.id.Judul)
            textView.text = "Selamat Datang, $namaDepan!"

            // Handle "View Plot" button click
            val btnViewPlot: MaterialButton = findViewById(R.id.btnViewPlot)
            btnViewPlot.setOnClickListener {
                val intent = Intent(this, ViewPlotActivity::class.java)
                startActivity(intent)
            }

            // Handle "Btn Login" button click
            val btnLogin: MaterialButton = findViewById(R.id.btn4)
            btnLogin.setOnClickListener {
                val intent = Intent(this, HalamanDaftar::class.java)
                startActivity(intent)
            }

            // Handle "Add Plot" button click (jika diperlukan)
            val btnAddPlot: MaterialButton = findViewById(R.id.btnAddPlot)
            btnAddPlot.setOnClickListener {
                val intent = Intent(this, AddPlotActivity::class.java)
                startActivity(intent)
            }
        }
    }
