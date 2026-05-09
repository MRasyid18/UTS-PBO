public class SuiteKamar extends Kamar {
    public SuiteKamar(String nomorKamar, double harga, String status) {
        super(nomorKamar, harga, status);
    }

    @Override
    public void tampilkanDetail() {
        System.out.printf("No: %-5s | Tipe: Suite      | Harga: Rp%-9.0f | Status: %s (Fasilitas: Ruang Tamu, Mini Bar)%n", 
                getNomorKamar(), getHarga(), getStatus());
    }

    @Override
    public String getTipe() { return "Suite"; }
}