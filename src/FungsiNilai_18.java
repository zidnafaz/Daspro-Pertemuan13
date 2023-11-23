import java.util.Scanner;

public class FungsiNilai_18 {
    static Scanner input18 = new Scanner(System.in);
    
    static String nilaiMahasiswa[][] = new String[5][8];

    public static void InputNilaiMahasiswa() {

        for (int i = 0; i < nilaiMahasiswa.length; i++) {
            System.out.print("Nama Mahasiswa ke-" + (i + 1) + " : ");
            nilaiMahasiswa[i][0] = input18.next();
            for (int j = 1; j < nilaiMahasiswa[0].length; j++) {
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
        int totalNilaiPerMinggu[] = new int[nilaiMahasiswa[0].length - 1];
    
        // Menghitung total nilai per minggu
        for (int i = 0; i < nilaiMahasiswa.length; i++) {
            for (int j = 1; j < nilaiMahasiswa[i].length; j++) {
                int nilai = Integer.parseInt(nilaiMahasiswa[i][j]);
                totalNilaiPerMinggu[j - 1] += nilai;
            }
        }
    
        // Menampilkan total nilai per minggu
        for (int i = 0; i < totalNilaiPerMinggu.length; i++) {
            System.out.println("Total nilai minggu ke-" + (i + 1) + ": " + totalNilaiPerMinggu[i]);
        }
    
        // Mencari minggu dengan total nilai tertinggi
        int mingguTertinggi = 1; // Minggu diindeks mulai dari 1
        int nilaiTertinggi = totalNilaiPerMinggu[0];
    
        for (int i = 1; i < totalNilaiPerMinggu.length; i++) {
            if (totalNilaiPerMinggu[i] > nilaiTertinggi) {
                nilaiTertinggi = totalNilaiPerMinggu[i];
                mingguTertinggi = i + 1; // Minggu diindeks mulai dari 1
            }
        }
    
        // Menampilkan hasil
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

        System.out.println("Nilai tertinggi adalah " + nilaiTertinggi + " terdapat pada minggu ke-" + mingguTertinggi);
        System.out.println("Diraih oleh " + namaTertinggi);
    }

    public static void main(String[] args) {
        InputNilaiMahasiswa();
        PrintNilaiMahasiswa();
        HitungTotalNilaiPerMinggu();
        CariHariNilaiTertinggi();
    }
}