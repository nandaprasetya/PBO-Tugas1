package Securities;

import Data.SecuritiesData;
import java.time.LocalDate;
import java.util.Scanner;

public class SBNs extends Securities {
    private int nationalQuota;
    private double interestRate;
    private int durationInMonths;
    private LocalDate maturityDate;

    public SBNs(String code, String name, double price, int nationalQuota, double interestRate, int durationInMonths, LocalDate maturityDate) {
        super(code, name, price);
        this.nationalQuota = nationalQuota;
        this.interestRate = interestRate;
        this.durationInMonths = durationInMonths;
        this.maturityDate = maturityDate;
    }

    public int getNationalQuota() {
        return nationalQuota;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getDurationInMonths() {
        return durationInMonths;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public static void addSBN(Scanner scanner) {
        System.out.println("||========================== TAMBAH SBN ============================||");

        String code = scanner.nextLine().trim();
        String name = scanner.nextLine().trim();
        double price = scanner.nextDouble();
        int quota = scanner.nextInt();
        double interest = scanner.nextDouble();
        int duration = scanner.nextInt();
        scanner.nextLine();  // Consume the newline
        LocalDate maturityDate = LocalDate.parse(scanner.nextLine().trim());

        SBNs newSBN = new SBNs(code, name, price, quota, interest, duration, maturityDate);
        SecuritiesData.getSbnsList().add(newSBN);

        System.out.println("||===================================================================||");
        System.out.println("||                 SBN berhasil ditambahkan ke daftar!               ||");
        System.out.println("||===================================================================||");
    }

    public static void viewSBNList() {
        if (SecuritiesData.getSbnsList().isEmpty()) {
            System.out.println("||==================================================================||");
            System.out.println("||                  Belum ada SBN yang tersedia.                    ||");
            System.out.println("||==================================================================||");
            return;
        }

        System.out.println("||====||=======||=============================||==============||=======||=======||========||================||");
        System.out.println("|| NO || KODE  || NAMA                        || HARGA        || KUOTA || BUNGA || DURASI || JATUH TEMPO    ||");
        System.out.println("||====||=======||=============================||==============||=======||=======||========||================||");

        int no = 1;
        for (SBNs sbn : SecuritiesData.getSbnsList()) {
            System.out.printf("|| %2d || %-5s || %-27s || %,-12.2f || %5d || %5.2f%% || %6d || %-12s ||%n",
                    no++, sbn.getCode(), sbn.getName(), sbn.getPrice(),
                    sbn.getNationalQuota(), sbn.getInterestRate(),
                    sbn.getDurationInMonths(), sbn.getMaturityDate());
        }

        System.out.println("||====||=======||=============================||==============||=======||=======||========||================||");
    }

    public static void deleteSBN(Scanner scanner) {
        System.out.println("||========================= HAPUS SBN ===============================||");

        if (SecuritiesData.getSbnsList().isEmpty()) {
            System.out.println("|| Tidak ada SBN yang tersedia untuk dihapus.                        ||");
            System.out.println("||===================================================================||");
            return;
        }

        System.out.println("|| Daftar SBN:                                                       ||");
        int no = 1;
        for (SBNs sbn : SecuritiesData.getSbnsList()) {
            System.out.printf("|| %-65s ||%n", no++ + "|| " + sbn.getCode() + "- " + sbn.getName());
        }
        System.out.println("||===================================================================||");

        String code = scanner.nextLine().trim();
        SBNs found = null;
        for (SBNs sbn : SecuritiesData.getSbnsList()) {
            if (sbn.getCode().equalsIgnoreCase(code)) {
                found = sbn;
                break;
            }
        }

        if (found != null) {
            SecuritiesData.getSbnsList().remove(found);
            System.out.println("||===================================================================||");
            System.out.printf("|| %-65s ||%n", "SBN " + found.getName() + " berhasil dihapus!");
            System.out.println("||===================================================================||");
        } else {
            System.out.println("||===================================================================||");
            System.out.println("|| Kode SBN tidak ditemukan.                                         ||");
            System.out.println("||===================================================================||");
        }
    }
}
