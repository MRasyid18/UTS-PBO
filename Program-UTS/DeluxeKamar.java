public class DeluxeKamar extends Kamar {
    public DeluxeKamar(String nomorKamar, double harga, String status) {
        super(nomorKamar, harga, status);
    }

    @Override
    public void tampilkanDetail() {
        System.out.printf("No: %-5s | Tipe: Deluxe     | Harga: Rp%-9.0f | Status: %s (Fasilitas: 1 King Bed, AC, TV)%n", 
                getNomorKamar(), getHarga(), getStatus());
    }

    @Override
    public String getTipe() { return "Deluxe"; }
}