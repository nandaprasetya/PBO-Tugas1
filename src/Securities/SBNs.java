package Securities;

import java.time.LocalDate;

public class SBNs extends Securities{
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

    public boolean reduceQuota(int amount) {
        if (amount <= nationalQuota) {
            nationalQuota -= amount;
            return true;
        }
        return false;
    }

    public double simulateProfit(double interestRate, double amountInvested, int totalMonths) {
        double monthlyCoupon = ((interestRate / 100 / 12) * price) * 0.9 * amountInvested;
        return monthlyCoupon * totalMonths;
    }
}