# Submission 3
## Kriteria
Fitur yang harus ada pada aplikasi:

1. Daftar film
- Syarat:
    * Terdapat 2 (dua) halaman yang menampilkan daftar film (Movies dan Tv Show)
    * Menggunakan Fragment untuk menampung halaman Movies dan Tv Show.
    * Menggunakan RecyclerView untuk menampilkan daftar film.
    * Menggunakan TabLayout, BottomNavigationView atau yang lainnya sebagai navigasi antara halaman Movies dan Tv Show.
    * Menampilkan indikator loading ketika data sedang dimuat.

2. Detail film
- Syarat:
    * Menampilkan poster dan informasi film pada halaman detail film.
    * Menggunakan ConstraintLayout untuk menyusun layout.
    * Menampilkan indikator loading ketika data sedang dimuat.

3. Localization
- Syarat:
    * Aplikasi harus mendukung bahasa Indonesia dan bahasa Inggris.

4. Configuration Changes
- Syarat:
    * Aplikasi harus bisa menjaga data yang sudah dimuat ketika terjadi pergantian orientasi dari potrait ke landscape atau sebaliknya.
    
## Resources
*  Untuk mendapatkan API Key silakan ikuti tutorial pada tautan berikut:
   https://blog.dicoding.com/registrasi-testing-themoviedb-api/
*  Gunakan endpoint berikut untuk mendapatkan data Movies:
   https://api.themoviedb.org/3/discover/movie?api_key={API KEY}&language=en-US
*  Gunakan endpoint berikut untuk mendapatkan data Tv Show:
   https://api.themoviedb.org/3/discover/tv?api_key={API KEY}&language=en-US
*  Gunakan url berikut untuk mendapatkan poster film.
   https://image.tmdb.org/t/p/{POSTER SIZE}{POSTER FILENAME}

   POSTER SIZE di atas adalah ukuran dari poster yang ingin didapatkan. Tersedia beberapa ukuran yang dapat digunakan w92, w154, w185, w342, w500, w780, dan original. Sedangkan POSTER FILENAME adalah path poster yang bisa didapatkan dari response JSON dengan key poster_path.
   Contoh:
   https://image.tmdb.org/t/p/w185/kSBXou5Ac7vEqKd97wotJumyJvU.jpg

*  Penjelasan mengenai poster dapat Anda lihat pada tautan berikut:
   https://developers.themoviedb.org/3/configuration/get-api-configuration

## Demo Aplikasi

<img src="demo/demo.gif" width="256" />

**Jangan lupa follow dan kasih ★** lihat profil akademi saya [di sini](https://www.dicoding.com/users/319160/academies).




