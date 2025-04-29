# PBO-Tugas1

# Program Investasi Saham dan Surat Berharga Negara (SBN)
Hai ! ini merupakan proyek kecil untuk membuat program investasi saham dan surat berharga negara (SBN) sebagai bagian dari Tugas I PBO kami.

Program Java ini dirancang dengan alur investasi sebagai berikut.
1. Program meminta pengguna untuk login. Jika login gagal tampilkan pesan gagal, dan
jika login berhasil tampilkan dua menu investasi yaitu Saham dan SBN.
2. Admin dapat menambahkan saham, mengubah harga saham, dan menambahkan
produk SBN.
3. Customer dapat melakukan pembelian dan penjualan saham, pembelian SBN,
simulasi SBN, dan melihat portofolio investasi.

Program ini juga dilengkapi dengan validasi untuk memastikan bahwa input yang diberikan pengguna sesuai dengan yang dibutuhkan program.

Di bawah ini terdapat penjelasan mengenai program, bagaimana program ini akan dijalankan, serta UML yang menggambarkan alur kerja program.
Untuk deskripsi kode lebih lengkap dapat dilihat pada kode program yang sudah dicommit (sudah disertakan penjelasan untuk membantu dalam mengerti cara kerja program). Selamat membaca.

# Identitas Kami
* Nama  : I Made Nanda Prasetya Dwipayana  
  NIM   : 2405551043  
  Matkul: PBO (B)


* Nama  : Ni Putu Candradevi Davantari  
  NIM   : 2405551035  
  Matkul: PBO (B)

  ![Screenshot](https://drive.google.com/uc?export=view&id=1WcA_nmQ_rg2FVQu0OAoPnEZMpA-xYz9k)
  # Login Page
  ![Screenshot](https://drive.google.com/uc?export=view&id=1G8YffiEFbPlCOgcGZfIyF3A3_eYQfLDq)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1fa-LR78zskisuD8u-0Y9DaV2d8YhuTOz)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1j-afjZd4iooB8h7doRGqZJ3vxpIrPOpi)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1I3KTZAgHG9kRRzIVXV7bIhT26MekLnoo)  
Pada awal program user akan diminta login dengan melakukan input username dan password, jika username atau password salah maka akan mengeluarkan pesan username atau password salah! coba lagi, dan akan diminta untuk melakukan login kembali
  # Landing Page User (Main Menu & Watchlist)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1NWIGpPk1ZU6UKBCGllEKGJVs3lGq84A4)  
Jika User telah berhasil melakukan login akan menuju halaman Landing page yang berisi watchlist, jika watchlist kosong maka akan berisi pesan watchlist anda kosong.
  # List Saham
  ![Screenshot](https://drive.google.com/uc?export=view&id=1i-4VL8qRY0ZRBigy7EH4kB0aW2pxoz9f)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1HcdsBcsiDEA-JnTsQDqcP0xZD6JrHxdB)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1LaM3SmBPnUwDNMLczZgj-wb_TErvz4ys)  
  list saham adalah halaman yang menampilkan saham saham yang tersedia, pada halaman ini terdapat pagenation agar mempermudah user dalam membaca saham saham. jika pada halaman satu menu next saja yang akan ditampilkan, jika halaman tengah tengah maka next dan prev, jika halaman terakhir maka prev. pada halaman ini menampilkan informasi no, kode, harga, persentase dan sektor
  # List SBN
  ![Screenshot](https://drive.google.com/uc?export=view&id=1tqYWHvVW_-fWZffKToLfVF8MGEq5VFiL)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1TiX8i99txkvx5NqVtG_8Kt4qoeHnpu5W)  
  List sbn adalah halaman yang memuat daftar sbn yang tersedia, dalam tampilan halaman ini juga menggunakan pagenation, dalam tampilan ini berisi kode, harga, kouta, bunga, jatuh tempo
  # Beli Saham dan SBN
  ![Screenshot](https://drive.google.com/uc?export=view&id=1XUJNlat0NllNkWrrWZGKxtvYIF3hvipK)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1yOw--2s9Mgb__iSjNpFz8UxSwQ6e5H3U)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1er4oZoSs428uah4isgiLUiOFqEkRzkob)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1VRIxzyxrXg1BOJa6A-O9Z2ii9WUXssDY)
  ![Screenshot](https://drive.google.com/uc?export=view&id=13mSkQhHXPTC1mxRsFbLvMl9zBXA5lfme)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1xrDwS8z6BC7eqc-0_VrfTOOu2fUWS7CL)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1UzdKQZAbKTRLmkuclLlEPLZr3jnNPFWH)  
  Halaman beli saham dan sbn adalah halaman yang berfungsi untuk membeli sbn dan saham. pada halaman ini akan diminta kode saham atau sbn. jika kode benar maka akan mengulang, jika saldo mencukupi dari saham atau sbn yang dibeli maka transaksi akan berhasil, yang akan menampilkan kode, jumlah harga per lembar untuk saham, total pembayaran, harga per unit untuk sbn, pada pesan transaksi berhasil akan menutup secara sendiri ketika telah 5 detik
  # Saldo
  ![Screenshot](https://drive.google.com/uc?export=view&id=19J3dEpFEZqayl4yK2bk-8vvZGwwX1Meh)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1v6Fr3KPCJm9nmVonzzHLXrN4mtsO6KY7)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1Ljjs_j0ea2JbLTM86dT-h8kBuQYt4o7N)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1DvHjZ6TRmRveebVOWXQPvsDg-XO6lOG-)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1c69Uv8qD9YkVepSvhPKpB6e5-2PV1H1_)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1YLO6oFPmlwUoMPfYYLri33WZz1THuXe8)
  ![Screenshot](https://drive.google.com/uc?export=view&id=14AXq-ZEmwbcvOSo_Pa7hjfz8i1Y4cTRv)  
  halaman saldo digunakan untuk melihat saldo untuk transaksi, nilai dari investasi saham dan SBN, ada juga tambah saldo untuk menambahkan saldo dan tarik saldo untuk menarik saldo. jika topup dan penarikan berhasil maka akan memunculkan pesan berhasil dan akan hilang dalam 5 detik.
  # Portfolio SBN
  ![Screenshot](https://drive.google.com/uc?export=view&id=1S3czGT6PXIKn-earXI7eu_oFONCALDll)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1RcK3XIUrO19E1Ui9non56IgDGN4R0uaI)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1mQrU1ePIwuXa7odtN4cgZRRP89g5Fr0C)  
  Dalam portfolio sbn menampilkan SBN apa saja yang dimiliki, yang menampilkan kode, bunga per bulan, jumlah, bunga per tahun dan jatuh tempo, dalam halaman ini juga memiliki pagenation untuk memudahkan dalam melihat
  # Portfolio Saham
  ![Screenshot](https://drive.google.com/uc?export=view&id=1xYHl6aO3LRpsPpsHSCqWQjAlBcz5QhYo)
  ![Screenshot](https://drive.google.com/uc?export=view&id=10J30Iy_RWStLl5ZE7AWoRpBXInooEXKm)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1U5UBIpLExAtUsjtGde2IBUPjob1ZyMsy)  
  Dalam portfolio saham digunakan untuk melihat saham apa saja yang dimiliki user, dalam halaman ini menampilkan kode, nilai beli, nilai sekarang dan jumlah dalam lembar. pada halaman ini juga ada fitur pagenation yang berfungsi untuk memudahkan dalam melihat saham.
  # Simulasi SBN
  ![Screenshot](https://drive.google.com/uc?export=view&id=1T8DRLKvUhTbuSTe1BajTir509AEznU7J)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1rvfiINPoyA2pCSNtXeyBQ4xpRuo917Hz)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1nSJJRGYh0wFtIgBc_dk2ON1CAgVxGSzS)  
  dalam simulasi sbn user dapat melakukan simulasi SBN sebelum membelinya dalam simulasi ini akan menghasilkan informasi bunga per tahun dan bulan, harganya, jatuh tempo, kupon per bulan dan hasil investasi hingga jatuh tempo yang tidak termasuk modal. jika user melakukan input kode yang salah akan ada pesan kode sebelumnya bukanlah kode sbn
  # Jual Saham
  ![Screenshot](https://drive.google.com/uc?export=view&id=1Tet2RIatj7M-vnKepD0doxlmil3ISVG9)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1bmefbrqXWMMouIRTn5wxB-dO_Mg9SEsX)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1ik8fkiNotaljUgLWa0dc4HRWIG1NU2yo)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1pm5Uz401We86yC3tmoDWMzqAM0y4aKlR)  
dalam halaman menjual saham akan ada list saham yang dimiliki, dalam halaman ini ditampilkan kode, nilai beli, nilai sekarang dan jumlah. user akan diminta untuk melakukan input kode, jika kode salah akan memunculkan pesan dan akan hilang dalam 3 detik, jika jumlah saham yang ingin dijual melebihi yang dimiliki maka akan terdapat pesan error karena saham yang dimiliki kurang, jika berhasil akan menampilkan sisa saham, berapa banyak saham yang dijual, harga beli dan jual, dan hasil penjualan
  # Tambah dan Hapus Watchlist
  ![Screenshot](https://drive.google.com/uc?export=view&id=1NKbWGWRffX2etWPL5L16Oe44MRhjgC8P)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1sjeiN6nLz38JK8srtlVRQ4HCIU4N7FSA)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1Nf0zuKNID7xZ9NSTzDhzY6pEznun6ckE)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1TgLYgGteykrKjYSNZyxG_iJQ86Zp3ohF)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1LUmhksf3X3WT7y4oXeWiTiRC6b4dedvU)  
dalam halaman ini user akan diminta untuk melakukan input terhadap kode saham, jika kode saham atau saham belum tertambah di watchlist maka akan ditambahkan, jika sudah ada maka akan dihapus, jika watchlist sudah 8 maka tidak bisa menambahkan saham ke watchlist kecuali di hapus, watchlist berguna untuk membatu pengguna memantau harga saham.
# Logout
  ![Screenshot](https://drive.google.com/uc?export=view&id=1U7G_5DMZhL7ZpQ48xuoYQVpOg6HYGOcs)  
  Jika user dan admin memilih logout maka akan ada peringatan apakah ingin logout atau keluar aplikasi
# Admin
 # Main Menu Admin
  ![Screenshot](https://drive.google.com/uc?export=view&id=1GXZZ2v4Rj-JDeGqT7y6df2UCHrbn6aa9)
  ![Screenshot](https://drive.google.com/uc?export=view&id=16n2iI5yvML2Rv3nhLlUi8id9F4lG_Ovq)  
Ketika berhasil login, admin akan diminta untuk memilih menu yang ada di bagian kiri
 # Menu Saham
  ![Screenshot](https://drive.google.com/uc?export=view&id=16UloTF-eUup1VacI4PuRpZo3zjUenYiW)
  ![Screenshot](https://drive.google.com/uc?export=view&id=14RqgsSq5jxzGyrHDT9dr1Frqin5Glwdx)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1psSxWO4JpWjumDMlp_epqCBcmj6lzfJ6)
  ![Screenshot](https://drive.google.com/uc?export=view&id=14xNUBeTSRuNRDm4MY9gqrJXZ5Nh7VOv3)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1-CWICo-4r6zFxorrDTf_IGyzmY5M70Jw)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1GC9Mot8q3o99Fv9ED4NvKFmc_L4aOJVt)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1jRReGRhsQiJ5khtvfUavQL4L59O458ce)  
  Ketika memilih menu bagian saham, admin akan diminta untuk memilih opsi yang akan dilakukan. Ketika melakukan tambah saham, admin diminta memasukkan kelengkapan yang ada, disini juga dilengkapi validasi seperti ketika memasukkan harga maka input yang diperbolehkan hanyalah angka, dan setelah berhasil akan ada pertanda dan admin kembali memilih menu lain. Ketika melakukan ubah harga saham, admin disajikan daftar kode saham beserta nama perusahaannya. Admin diminta memasukkan kode saham yang ingin diubah harganya serta harga terbaru. Hal ini juga dilengkapi validasi input angka. Ketika melakukan hapus saham, admin disajikan daftar kode saham beserta nama perusahaannya. Admin diminta memasukkan kode saham yang ingin dihapus, lalu terdapat validasi kembali untuk memastikan bahwa admin benar-benar ingin menghapus saham
# Menu SBN
  ![Screenshot](https://drive.google.com/uc?export=view&id=1-lRvjq5DiDe6Srjs1bpzmmVLeZGa5ScA)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1jxfGdvTITCDIWoIXsECabDsO6YhOPOfh)
  ![Screenshot](https://drive.google.com/uc?export=view&id=15Ddl5CUdM-Sin04gs-c3kpp_LV5KXE3I)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1dJ_C_-rLEzJOikzSHV4ReqAxuS9WsMn8)
  ![Screenshot](https://drive.google.com/uc?export=view&id=1XGBMDGijC3n9dxS6Vzok004UZ1-RHzM2)  
  Pada pilihan kedua yaitu menu SBN, admin disajikan opsi SBN. Ketika melakukan tambah SBN, admin diminta memasukkan kelengkapan, hal ini juga sudah dilengkapi validasi pada input angka untuk harga, input angka untuk % bunga, input angka pada bulan dan format tanggal pada tanggal jatuh tempo. Ketika admin melakukan lihat daftar SBN, admin disajikan list SBN yang telah ada beserta perintah-perintah yang sebelumnya dilakukan juga akan terupdate. Contohnya ketika tadi melakukan tambah SBN, otomatis SBN baru akan terlihat disini. Ketika admin ingin kembali, admin dapat menginput 0 kemudian admin akan diarahkan ke halaman main menu admin kemudian akan logout. Ketika ingin logout, admin akan diberi pilihan untuk memilih apakah benar-benar ingin keluar dari program atau hanya keluar untuk memilih user.
