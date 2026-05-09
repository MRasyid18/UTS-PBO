public class PresidentialSuiteKamar extends Kamar {
    public PresidentialSuiteKamar(String nomorKamar, double harga, String status) {
        super(nomorKamar, harga, status);
    }

    @Override
    public void tampilkanDetail() {
        System.out.printf("No: %-5s | Tipe: Pres-Suite | Harga: Rp%-9.0f | Status: %s (Fasilitas: Private Pool, VVIP Service)%n", 
                getNomorKamar(), getHarga(), getStatus());
    }

    @Override
    public String getTipe() { return "Presidential Suite"; }
}