import java.util.ArrayList;
import java.util.Scanner;

public class SistemHotel {
    static ArrayList<Kamar> daftarKamar = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    
    // Kode Warna ANSI untuk estetika modern
    static final String RESET = "\u001B[0m";
    static final String CYAN = "\u001B[36m";
    static final String GOLD = "\u001B[33m";

    public static void main(String[] args) {
        boolean jalan = true;

        while (jalan) {
            System.out.println(CYAN + "\n========================================" + RESET);
            System.out.println(GOLD + "   SISTEM MANAJEMEN KAMAR HOTEL VIP" + RESET);
            System.out.println(CYAN + "========================================" + RESET);
            System.out.println("1. Tampilkan Semua Kamar");
            System.out.println("2. Tambah Kamar Baru");
            System.out.println("3. Edit Data Kamar");
            System.out.println("4. Hapus Kamar");
            System.out.println("5. Keluar");
            System.out.print(CYAN + "Pilih menu (1-5): " + RESET);
            
            int pilihan = Integer.parseInt(scanner.nextLine());

            switch (pilihan) {
                case 1: tampilkanKamar(); break;
                case 2: tambahKamar(); break;
                case 3: editKamar(); break;
                case 4: hapusKamar(); break;
                case 5: 
                    jalan = false;
                    System.out.println(GOLD + "Terima kasih telah menggunakan sistem ini!" + RESET);
                    break;
                default: System.out.println("Pilihan tidak valid!");
            }
        }
    }

    static void tampilkanKamar() {
        System.out.println(GOLD + "\n--- Daftar Kamar Saat Ini ---" + RESET);
        if (daftarKamar.isEmpty()) {
            System.out.println("Belum ada data kamar.");
        } else {
            for (Kamar k : daftarKamar) {
                k.tampilkanDetail(); 
            }
        }
    }

    static void tambahKamar() {
        System.out.println(GOLD + "\n--- Tambah Kamar Baru ---" + RESET);
        System.out.print("Masukkan Nomor Kamar: ");
        String nomor = scanner.nextLine();
        
        System.out.println("Pilih Tipe Kamar:\n1. Standard\n2. Deluxe\n3. Suite\n4. Presidential Suite");
        System.out.print(CYAN + "Pilih (1-4): " + RESET);
        int tipe = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Masukkan Harga Kamar: Rp ");
        double harga = Double.parseDouble(scanner.nextLine());
        
        System.out.println("Pilih Status:\n1. Tersedia\n2. Dipesan\n3. Maintenance");
        System.out.print(CYAN + "Pilih (1-3): " + RESET);
        int statusPilihan = Integer.parseInt(scanner.nextLine());
        String status = statusPilihan == 1 ? "Tersedia" : statusPilihan == 2 ? "Dipesan" : "Maintenance";

        Kamar kamarBaru = null;
        if (tipe == 1) {
            kamarBaru = new StandardKamar(nomor, harga, status);
        } else if (tipe == 2) {
            kamarBaru = new DeluxeKamar(nomor, harga, status);
        } else if (tipe == 3) {
            kamarBaru = new SuiteKamar(nomor, harga, status);
        } else if (tipe == 4) {
            kamarBaru = new PresidentialSuiteKamar(nomor, harga, status);
        }

        if (kamarBaru != null) {
            daftarKamar.add(kamarBaru);
            System.out.println(CYAN + "Kamar " + nomor + " berhasil ditambahkan!" + RESET);
        }
    }

    static void editKamar() {
        // PERUBAHAN: Menampilkan list kamar dulu sebelum input nomor
        tampilkanKamar();
        
        if (daftarKamar.isEmpty()) return; // Jika kosong, langsung kembali ke menu utama

        System.out.println(GOLD + "\n--- Edit Data Kamar ---" + RESET);
        System.out.print("Masukkan Nomor Kamar yang akan diedit: ");
        String nomor = scanner.nextLine();
        
        Kamar kamarDitemukan = cariKamar(nomor);
        
        if (kamarDitemukan != null) {
            System.out.print("Masukkan Harga Baru (Lama: Rp" + kamarDitemukan.getHarga() + "): Rp ");
            double hargaBaru = Double.parseDouble(scanner.nextLine());
            kamarDitemukan.setHarga(hargaBaru);
            
            System.out.println("Pilih Status Baru (Lama: " + kamarDitemukan.getStatus() + "):\n1. Tersedia\n2. Dipesan\n3. Maintenance");
            System.out.print(CYAN + "Pilih (1-3): " + RESET);
            int statusPilihan = Integer.parseInt(scanner.nextLine());
            String statusBaru = statusPilihan == 1 ? "Tersedia" : statusPilihan == 2 ? "Dipesan" : "Maintenance";
            kamarDitemukan.setStatus(statusBaru);
            
            System.out.println(CYAN + "Data kamar " + nomor + " berhasil diupdate!" + RESET);
        } else {
            System.out.println("Kamar dengan nomor " + nomor + " tidak ditemukan.");
        }
    }

    static void hapusKamar() {
        // PERUBAHAN: Menampilkan list kamar dulu sebelum input nomor
        tampilkanKamar();

        if (daftarKamar.isEmpty()) return;

        System.out.println(GOLD + "\n--- Hapus Kamar ---" + RESET);
        System.out.print("Masukkan Nomor Kamar yang akan dihapus: ");
        String nomor = scanner.nextLine();
        
        Kamar kamarDitemukan = cariKamar(nomor);
        
        if (kamarDitemukan != null) {
            daftarKamar.remove(kamarDitemukan);
            System.out.println(CYAN + "Kamar nomor " + nomor + " berhasil dihapus." + RESET);
        } else {
            System.out.println("Kamar dengan nomor " + nomor + " tidak ditemukan.");
        }
    }

    static Kamar cariKamar(String nomor) {
        for (Kamar k : daftarKamar) {
            if (k.getNomorKamar().equalsIgnoreCase(nomor)) {
                return k;
            }
        }
        return null;
    }
}