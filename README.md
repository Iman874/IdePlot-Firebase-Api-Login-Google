# 📖 IdePlot - Firebase Google Login

[Baca dalam Bahasa Indonesia](#bahasa-indonesia) | [Read in English](#english)

---

## POIN-POIN MATERI

* 📜 [Deskripsi Singkat](#deskripsi-singkat)
* 🧰 [Fitur Utama](#fitur-utama)
* ⚙️ [Struktur Teknis](#struktur-teknis)
* ⚖️ [Cara Instalasi](#cara-instalasi)
* 🔗 [Referensi Tambahan](#referensi-tambahan)
* 📄 [Lisensi](#lisensi)

---

<a name="bahasa-indonesia"></a>

## 🇮🇩 Bahasa Indonesia

<a name="deskripsi-singkat"></a>

### 📜 Deskripsi Singkat

**IdePlot Firebase** adalah prototipe aplikasi Android untuk mencatat ide cerita dan plot. Aplikasi ini mendemonstrasikan alur antarmuka dasar serta integrasi login Google menggunakan Firebase Authentication.

Nama "IdePlot" merupakan gabungan dari kata "Ide" dan "Plot", mencerminkan tujuan aplikasi sebagai alat bantu kreatif bagi penulis.

---

<a name="fitur-utama"></a>

### 🧰 Fitur Utama

* **Registrasi Manual:**

  * Input nama depan, nama belakang, email, dan password.
  * Setelah berhasil login, ditampilkan sapaan personal di halaman utama.

* **Login dengan Google:**

  * Menggunakan Firebase Authentication dan Google Sign-In.
  * Otomatis mengambil nama dan email pengguna untuk ditampilkan.

* **Manajemen Plot Cerita:**

  * Form tambah plot: judul, deskripsi, poin cerita, dan panjang plot.
  * Halaman tampilan detail plot setelah ditambahkan.

> ⚠️ *Catatan:* Data belum tersimpan secara permanen. Semua data hanya dikirim antar Activity melalui intent dan hilang saat aplikasi ditutup.

---

<a name="struktur-teknis"></a>

### ⚙️ Struktur Teknis

* **`HalamanDaftar.kt`**: Login manual dan login Google.
* **`MainActivity.kt`**: Tampilan utama dan sapaan pengguna.
* **`AddPlotActivity.kt`**: Form tambah plot.
* **`ViewPlotActivity.kt`**: Menampilkan plot yang dikirim dari `AddPlotActivity`.

**Library utama:**

* Firebase Authentication
* Google Play Services Auth
* AndroidX + Material Components

---

<a name="cara-instalasi"></a>

### ⚖️ Cara Instalasi

1. **Clone repositori:**

```bash
git clone https://github.com/iman874/IdePlot-Firebase-Api-Login-Google.git
```

2. **Buka di Android Studio:**

* Pilih `File > Open`, lalu arahkan ke folder proyek

3. **Konfigurasi Firebase:**

* Buka [Firebase Console](https://console.firebase.google.com/)
* Buat project baru atau gunakan yang sudah ada
* Tambahkan aplikasi Android dengan package name `com.example.ideplot`
* Unduh `google-services.json` dan letakkan di folder `app/`
* Aktifkan metode login Google di menu **Build > Authentication**

4. **Build & Jalankan**

* Build project dan jalankan di emulator atau perangkat fisik

---

<a name="referensi-tambahan"></a>

## 🔗 Referensi Tambahan

* **Laporan Proyek:** [Google Docs](https://docs.google.com/document/d/1JigVVOJabZNeSe2ocXJsAwCRkH8kNhBw)
* **Demo Video:** [YouTube](https://youtu.be/krbCXqPIja8?si=C3vMxuuVIEzYb8w4)

---

<a name="lisensi"></a>

## 📄 Lisensi

Proyek ini dilisensikan di bawah Apache License 2.0. Lihat file [LICENSE](LICENSE) untuk detail lebih lanjut.

---

<a name="english"></a>

## 🇬🇧 English

<a name="deskripsi-singkat"></a>

### 📜 Overview

**IdePlot Firebase** is a simple Android app prototype for capturing and organizing story ideas. It demonstrates Google Sign-In integration via Firebase and simple multi-activity UI flows.

The name "IdePlot" combines "Idea" and "Plot"—a creative writing companion.

---

<a name="fitur-utama"></a>

### 🧰 Features

* **User Registration:**

  * Manual signup with first name, last name, email, and password.
  * Personalized greeting shown on the main screen.

* **Google Sign-In:**

  * Firebase Authentication integration
  * Retrieves user name and email automatically

* **Plot Management:**

  * Add plot screen with fields for title, description, key points, and length
  * View plot screen after saving

> ⚠️ *Note:* No persistent storage is used. Plot data is passed via intents and cleared on app close.

---

<a name="struktur-teknis"></a>

### ⚙️ Technical Overview

* **`HalamanDaftar.kt`**: User registration & Google Sign-In
* **`MainActivity.kt`**: Home screen with greeting
* **`AddPlotActivity.kt`**: Add plot screen
* **`ViewPlotActivity.kt`**: Plot detail viewer

**Key Libraries:**

* Firebase Authentication
* Google Play Services Auth
* AndroidX & Material Components

---

<a name="cara-instalasi"></a>

### ⚖️ Setup & Installation

1. **Clone the repository:**

```bash
git clone https://github.com/iman874/IdePlot-Firebase-Api-Login-Google.git
```

2. **Open in Android Studio:**

* Go to `File > Open`, navigate to the cloned folder

3. **Firebase Setup:**

* Visit [Firebase Console](https://console.firebase.google.com/)
* Create a project or use existing one
* Add Android app with package: `com.example.ideplot`
* Download `google-services.json` and place in `app/`
* Enable Google Sign-In under **Build > Authentication**

4. **Build & Run:**

* Build and run the app on emulator or real device

---

<a name="referensi-tambahan"></a>

## 🔗 Additional Resources

* [Project Report (Bahasa Indonesia)](https://docs.google.com/document/d/1JigVVOJabZNeSe2ocXJsAwCRkH8kNhBw)
* [Demo Video](https://youtu.be/krbCXqPIja8?si=C3vMxuuVIEzYb8w4)

---

<a name="lisensi"></a>

## 📄 License

This project is licensed under the Apache License 2.0. See the [LICENSE](LICENSE) file for details.
