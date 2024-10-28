@file:Suppress("DEPRECATION")

package com.example.ideplot

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class HalamanDaftar : AppCompatActivity() {

    // Deklarasi tampilan
    private lateinit var editTextNamaDepan: EditText
    private lateinit var editTextNamaBelakang: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText

    // Tambahkan variabel untuk Google Sign-In
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.halaman_daftar)


        FirebaseApp.initializeApp(this)

        // Inisialisasi tampilan
        editTextNamaDepan = findViewById(R.id.editTextNamaDepan)
        editTextNamaBelakang = findViewById(R.id.editTextNamaBelakang)
        editTextEmail = findViewById(R.id.editTextTextEmailAddress)
        editTextPassword = findViewById(R.id.editTextTextPassword)

        // Konfigurasi opsi login Google
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)
        auth = FirebaseAuth.getInstance()

        // Panggil fungsi login saat tombol ditekan
        findViewById<AppCompatImageButton>(R.id.btnLoginGoogle).setOnClickListener {
            googleSignInClient.revokeAccess()  // Hapus akses agar bisa memilih akun lagi
                .addOnCompleteListener {
                    googleSignInClient.signOut()  // Logout dari akun Google
                        .addOnCompleteListener {
                            signInWithGoogle()  // Mulai ulang proses login Google
                        }
                }
        }


        // Jika USER DAFTAR dengan NAMA DAN EMAIL BIASA tanpa akun
        // Menangani klik tombol "Daftar"

        editTextNamaDepan = findViewById(R.id.editTextNamaDepan)
        editTextNamaBelakang = findViewById(R.id.editTextNamaBelakang)
        editTextEmail = findViewById(R.id.editTextTextEmailAddress)
        editTextPassword = findViewById(R.id.editTextTextPassword)

        findViewById<Button>(R.id.BtnDaftar).setOnClickListener {
            val namaDepan = editTextNamaDepan.text.toString().trim()
            val namaBelakang = editTextNamaBelakang.text.toString().trim()
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            // Validasi input
            if (namaDepan.isEmpty() || namaBelakang.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Harap isi semua kolom", Toast.LENGTH_SHORT).show()
            } else {
                // Proses pendaftaran
                val message = "Pendaftaran Berhasil!\nNama: $namaDepan $namaBelakang\nEmail: $email"
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()

                // Pindah ke MainActivity dengan membawa isi dari variabel nama depan
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("NAMA_DEPAN", namaDepan) // Mengirim nama depan
                startActivity(intent)

                // Menutup activity ini agar tidak kembali ke sini setelah menekan back
                finish()
            }
        }
    }



    // Fungsi untuk memulai Google Sign-In
    private fun signInWithGoogle() {
        val signInIntent = googleSignInClient.signInIntent
        googleSignInLauncher.launch(signInIntent)
    }

    private val googleSignInLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)

        if (task.isSuccessful) {
            val account = task.result
            if (account != null) {
                firebaseAuthWithGoogle(account)
            }
        } else {

            // Mengambil informasi error secara detail
            val errorCause = task.exception?.cause
            val errorClass = task.exception?.javaClass?.simpleName
            val errorStackTrace = task.exception?.stackTrace?.joinToString("\n")

            // Menampilkan pesan error dari Google Sign-In
            val errorMessage = task.exception?.message

            Log.e("GoogleSignInError", "Google Sign-In gagal dengan error:")
            Log.e("GoogleSignInError", "Error Message: $errorMessage")
            Log.e("GoogleSignInError", "Error Cause: $errorCause")
            Log.e("GoogleSignInError", "Error Class: $errorClass")
            Log.e("GoogleSignInError", "Stack Trace: $errorStackTrace")
            // Menampilkan pesan Toast dengan pesan error jika ada, atau pesan default jika errorMessage null
            Toast.makeText(this, errorMessage ?: "Terjadi kesalahan pada Google Sign-In", Toast.LENGTH_LONG).show()
        }
    }



    private fun firebaseAuthWithGoogle(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    try {
                        val namaDepan = account.givenName ?: "Guest"
                        val namaBelakang = account.familyName ?: ""
                        val email = account.email ?: ""

                        val message = "Pendaftaran Berhasil!\nNama: $namaDepan $namaBelakang\nEmail: $email"
                        Toast.makeText(this, message, Toast.LENGTH_LONG).show()

                        val intent = Intent(this, MainActivity::class.java)
                        intent.putExtra("NAMA_DEPAN", namaDepan)
                        startActivity(intent)
                        finish()
                    } catch (e: ApiException) {
                        Log.w("HalamanDaftar", "signInResult:failed code=" + e.statusCode)
                        Toast.makeText(this, "Login Google gagal", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    val errorCode = task.exception?.message
                    Log.e("FirebaseAuthError", "Firebase Auth gagal: $errorCode", task.exception)
                }
            }
    }



}
