import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

    
        Dosen d1 = new Dosen("Misbakhul Munir", "D001");
        Dosen d2 = new Dosen("Fajar Baskoro", "D002");
        Dosen d3 = new Dosen("Baskoro Adi", "D003");

    
        MataKuliah[] daftarMK = new MataKuliah[5];
        daftarMK[0] = new MataKuliah("IF2301", "Pemrograman Web", 3, 3,
                "Senin 07:00-08:50", "IF309", d1);
        daftarMK[1] = new MataKuliah("IF2302", "PBO", 3, 3,
                "Selasa 10:00-11:50", "IF105", d2);
        daftarMK[2] = new MataKuliah("IF2303", "Jaringan Komputer", 4, 3,
                "Rabu 07:00-08:50", "IF105", d3);
        daftarMK[3] = new MataKuliah("IF2304", "Teori Graf", 3, 3,
                "Kamis 09:00-10:50", "IF107", d1);
        daftarMK[4] = new MataKuliah("IF2305", "Matematika Diskrit", 3, 3,
                "Jumat 09:00-10:50", "IF105", d2);

        boolean jalan = true;

        while (jalan) {
            System.out.println("\n===== SISTEM PENGAMBILAN MATA KULIAH =====");
            System.out.println("1. Daftar Mata Kuliah");
            System.out.println("2. Ambil Mata Kuliah");
            System.out.println("3. Lihat Mata Kuliah Saya");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");

            int menu = in.nextInt();
            in.nextLine(); 

            switch (menu) {
                case 1:
                
                    System.out.println("\n--- DAFTAR MATA KULIAH ---");
                    for (int i = 0; i < daftarMK.length; i++) {
                        MataKuliah mk = daftarMK[i];
                        System.out.println((i + 1) + ". [" + mk.getKode() + "] "
                                + mk.getNama() + " (" + mk.getSks() + " sks) "
                                + "[" + mk.getRuangan() + "] "
                                + mk.getJumlahTerdaftar() + "/" + mk.getKapasitas());
                    }
                    break;

                case 2:
                   
                    System.out.println("\n--- AMBIL MATA KULIAH ---");
                    System.out.print("Nama Mahasiswa : ");
                    String nama = in.nextLine();
                    System.out.print("NRP Mahasiswa  : ");
                    String nrp = in.nextLine();

                    Mahasiswa mhs = new Mahasiswa(nama, nrp);

            
                    System.out.println("\nPilih Mata Kuliah:");
                    for (int i = 0; i < daftarMK.length; i++) {
                        MataKuliah mk = daftarMK[i];
                        System.out.println((i + 1) + ". [" + mk.getKode() + "] "
                                + mk.getNama() + " (" + mk.getSks() + " sks) "
                                + mk.getJumlahTerdaftar() + "/" + mk.getKapasitas());
                    }

                    System.out.print("Masukkan nomor pilihan: ");
                    int pilihan = in.nextInt();
                    in.nextLine();

                    if (pilihan < 1 || pilihan > daftarMK.length) {
                        System.out.println("Pilihan tidak valid.");
                    } else {
                        MataKuliah mkDipilih = daftarMK[pilihan - 1];

                        if (mkDipilih.isMahasiswaTerdaftar(mhs.getNrp())) {
                            System.out.println("Gagal: kamu sudah terdaftar di mata kuliah ini.");
                        } else {
                            boolean berhasil = mkDipilih.tambahMahasiswa(mhs);
                            if (berhasil) {
                                System.out.println("\nBerhasil mengambil mata kuliah!");
                                System.out.println("Mahasiswa : " + mhs.getNama() + " (" + mhs.getNrp() + ")");
                                System.out.println("Matkul    : " + mkDipilih.getNama() + " [" + mkDipilih.getKode() + "]");
                                System.out.println("Jadwal    : " + mkDipilih.getJadwal() + " - " + mkDipilih.getRuangan());
                                System.out.println("Dosen     : " + mkDipilih.getDosenPengampu().getNama());
                            } else {
                                System.out.println("Gagal: kelas sudah penuh.");
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- CEK MATA KULIAH SAYA ---");
                    System.out.print("Masukkan NRP: ");
                    String nrpCari = in.nextLine();

                    boolean ada = false;
                    for (int i = 0; i < daftarMK.length; i++) {
                        MataKuliah mk = daftarMK[i];
                        if (mk.isMahasiswaTerdaftar(nrpCari)) {
                            if (!ada) {
                                System.out.println("Mata kuliah yang diambil oleh NRP " + nrpCari + ":");
                            }
                            ada = true;
                            System.out.println("- " + mk.getNama() + " [" + mk.getKode() + "] "
                                    + mk.getJadwal() + " (" + mk.getRuangan() + "), Dosen: "
                                    + mk.getDosenPengampu().getNama());
                        }
                    }

                    if (!ada) {
                        System.out.println("Belum ada mata kuliah yang diambil oleh NRP tersebut.");
                    }
                    break;

                case 4:
                    System.out.println("Keluar dari sistem. Terima kasih!");
                    jalan = false;
                    break;

                default:
                    System.out.println("Menu tidak dikenal.");
            }
        }

        in.close();
    }
}
