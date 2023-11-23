import java.util.Scanner;

public class FungsiNilai_18_1 {
    static Scanner input18 = new Scanner(System.in);
    static int jumlahMahasiswa;
    static int jumlahMinggu;

    static String nilaiMahasiswa[][];

    public static void InputJumlahMahasiswaMinggu() {
        System.out.print("Masukkan jumlah mahasiswa : ");
        jumlahMahasiswa = input18.nextInt();

        System.out.print("Masukkan jumlah minggu    : ");
        jumlahMinggu = input18.nextInt();

        nilaiMahasiswa = new String[jumlahMahasiswa][jumlahMinggu + 1]; // ditambah 1 untuk menyimpan nama mahasiswa
    }

    public static void InputNilaiMahasiswa() {
        for (int i = 0; i < nilaiMahasiswa.length; i++) {
            System.out.print("Nama Mahasiswa ke-" + (i + 1) + " : ");
            nilaiMahasiswa[i][0] = input18.next();
            for (int j = 1; j <= jumlahMinggu; j++) {
                System.out.print("Nilai Minggu ke-" + j + "   : ");
                int nilai = input18.nextInt();
                nilaiMahasiswa[i][j] = String.valueOf(nilai);
            }
            System.out.println();
        }
    }

    public static void PrintNilaiMahasiswa() {
        System.out.println("Nilai dari seluruh mahasiswa adalah :\n");

        for (int i = 0; i < nilaiMahasiswa.length; i++) {
            for (int j = 0; j < nilaiMahasiswa[i].length; j++) {
                if (j == 0) {
                    System.out.println("Nama : " + nilaiMahasiswa[i][j]);
                } else {
                    System.out.println("Nilai Minggu ke-" + j + " : " + nilaiMahasiswa[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void HitungTotalNilaiPerMinggu() {
        int totalNilaiPerMinggu[] = new int[jumlahMinggu];

        for (int i = 0; i < nilaiMahasiswa.length; i++) {
            for (int j = 1; j <= jumlahMinggu; j++) {
                int nilai = Integer.parseInt(nilaiMahasiswa[i][j]);
                totalNilaiPerMinggu[j - 1] += nilai;
            }
        }

        for (int i = 0; i < totalNilaiPerMinggu.length; i++) {
            System.out.println("Total nilai minggu ke-" + (i + 1) + ": " + totalNilaiPerMinggu[i]);
        }

        int mingguTertinggi = 1;
        int nilaiTertinggi = totalNilaiPerMinggu[0];

        for (int i = 1; i < totalNilaiPerMinggu.length; i++) {
            if (totalNilaiPerMinggu[i] > nilaiTertinggi) {
                nilaiTertinggi = totalNilaiPerMinggu[i];
                mingguTertinggi = i + 1;
            }
        }

        
        System.out.println("\nMinggu dengan total nilai tertinggi adalah Minggu ke-" + mingguTertinggi +
                " dengan total nilai " + nilaiTertinggi);
    }

    public static void CariHariNilaiTertinggi() {
        int nilaiTertinggi = Integer.MIN_VALUE;
        int mingguTertinggi = 0;
        String namaTertinggi = "";

        for (int i = 0; i < nilaiMahasiswa.length; i++) {
            for (int j = 1; j < nilaiMahasiswa[i].length; j++) {
                int nilai = Integer.parseInt(nilaiMahasiswa[i][j]);
                if (nilai > nilaiTertinggi) {
                    nilaiTertinggi = nilai;
                    mingguTertinggi = j;
                    namaTertinggi = nilaiMahasiswa[i][0];
                }
            }
        }

        System.out
                .println("\nNilai tertinggi adalah " + nilaiTertinggi + " terdapat pada minggu ke-" + mingguTertinggi);
        System.out.println("Diraih oleh " + namaTertinggi);
    }

    public static void main(String[] args) {
        InputJumlahMahasiswaMinggu();
        InputNilaiMahasiswa();
        PrintNilaiMahasiswa();
        HitungTotalNilaiPerMinggu();
        CariHariNilaiTertinggi();
    }
}
