public class StandardKamar extends Kamar {
    public StandardKamar(String nomorKamar, double harga, String status) {
        super(nomorKamar, harga, status);
    }

    @Override
    public void tampilkanDetail() {
        System.out.printf("No: %-5s | Tipe: Standard   | Harga: Rp%-9.0f | Status: %s (Fasilitas: 1 Bed, Kipas)%n", 
                getNomorKamar(), getHarga(), getStatus());
    }

    @Override
    public String getTipe() { return "Standard"; }
}