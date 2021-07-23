public class CreditCalculator {

    //Рассчет аннуитетного платежа по кредиту
    public static double calcOfMonthlyPayment(int creditAmount, double interestRate, int numberOfMount) {
        double interestRatePerMonthInPercent = interestRate / 100 / 12;
        return (interestRatePerMonthInPercent
                * Math.pow(1 + interestRatePerMonthInPercent, numberOfMount))
                / (Math.pow(1 + interestRatePerMonthInPercent, numberOfMount) - 1)
                * creditAmount;
    }

    //Рассчет общей суммы к возврату в банк
    public static double calcTotalRefundAmount(int creditAmount, double interestRate, int numberOfMount) {
        return calcOfMonthlyPayment(creditAmount, interestRate, numberOfMount) * numberOfMount;
    }

    //Рассчет переплаты за весь период
    public static double calcOverpaymentForTheEntirePeriod(int creditAmount, double interestRate, int numberOfMount) {
        return calcTotalRefundAmount(creditAmount, interestRate, numberOfMount) - creditAmount;
    }

    public static void main(String[] args) {
        System.out.printf("Ежемесячный платёж: %.2f руб.\n", calcOfMonthlyPayment(20000, 12, 36));
        System.out.printf("Общая сумма возврата: %.2f руб.\n", calcTotalRefundAmount(20000, 12, 36));
        System.out.printf("Переплата за весь период: %.2f руб.\n", calcOverpaymentForTheEntirePeriod(20000, 12, 36));
    }
}
