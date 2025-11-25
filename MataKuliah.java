
    private String nama;
    private int sks;
    private int kapasitas;
    private String jadwal;
    private String ruangan;
    private Dosen dosenPengampu;

    private Mahasiswa[] daftarMahasiswa;
    private int jumlahTerdaftar;

    public MataKuliah(String kode, String nama, int sks, int kapasitas,
                      String jadwal, String ruangan, Dosen dosenPengampu) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
        this.kapasitas = kapasitas;
        this.jadwal = jadwal;
        this.ruangan = ruangan;
        this.dosenPengampu = dosenPengampu;

        this.daftarMahasiswa = new Mahasiswa[kapasitas];
        this.jumlahTerdaftar = 0;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public int getSks() {
        return sks;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public int getJumlahTerdaftar() {
        return jumlahTerdaftar;
    }

    public String getJadwal() {
        return jadwal;
    }

    public String getRuangan() {
        return ruangan;
    }

    public Dosen getDosenPengampu() {
        return dosenPengampu;
    }

    public boolean isMahasiswaTerdaftar(String nrp) {
        for (int i = 0; i < jumlahTerdaftar; i++) {
            if (daftarMahasiswa[i].getNrp().equals(nrp)) {
                return true;
            }
        }
        return false;
    }

    public boolean tambahMahasiswa(Mahasiswa mhs) {
        if (isMahasiswaTerdaftar(mhs.getNrp())) {
            return false; // sudah terdaftar
        }
        if (jumlahTerdaftar >= kapasitas) {
            return false; // kelas penuh
        }
        daftarMahasiswa[jumlahTerdaftar] = mhs;
        jumlahTerdaftar++;
        return true;
    }
}
