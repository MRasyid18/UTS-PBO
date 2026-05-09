public abstract class Kamar {
    private String nomorKamar;
    private double harga;
    private String status;

    public Kamar(String nomorKamar, double harga, String status) {
        this.nomorKamar = nomorKamar;
        this.harga = harga;
        this.status = status;
    }

    public String getNomorKamar() { return nomorKamar; }
    public void setNomorKamar(String nomorKamar) { this.nomorKamar = nomorKamar; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public abstract void tampilkanDetail();
    public abstract String getTipe();
}