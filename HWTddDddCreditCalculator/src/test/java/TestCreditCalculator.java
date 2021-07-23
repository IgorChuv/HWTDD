import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCreditCalculator {
    final static double interestRate = 12;
    final static double interestRatePerMonthInPercent = 0.01;
    final static int creditAmount = 20000;
    final static int numberOfMount = 36;


    //Рассчет аннуитетного платежа по кредиту
    @Test
    public void testCalcOfMonthlyPayment() {
        double expected = (interestRatePerMonthInPercent
                * Math.pow(1 + interestRatePerMonthInPercent, numberOfMount))
                / (Math.pow(1 + interestRatePerMonthInPercent, numberOfMount) - 1)
                * creditAmount;
        double actual = CreditCalculator.calcOfMonthlyPayment(creditAmount,interestRate,numberOfMount);
        Assertions.assertEquals(expected,actual);
    }

   @Test
   //Рассчет общей суммы к возврату в банк
   public void testCalcTotalRefundAmount() {
       double expected = (interestRatePerMonthInPercent
               * Math.pow(1 + interestRatePerMonthInPercent, numberOfMount))
               / (Math.pow(1 + interestRatePerMonthInPercent, numberOfMount) - 1)
               * creditAmount * numberOfMount;
       double actual = CreditCalculator.calcOfMonthlyPayment(creditAmount, interestRate, numberOfMount) * numberOfMount;
 Assertions.assertEquals(expected,actual);
   }

    @Test
    //Рассчет переплаты за весь период
    public void testCalcOverpaymentForTheEntirePeriod() {
        double expected = (interestRatePerMonthInPercent
                * Math.pow(1 + interestRatePerMonthInPercent, numberOfMount))
                / (Math.pow(1 + interestRatePerMonthInPercent, numberOfMount) - 1)
                * creditAmount * numberOfMount - creditAmount;
        double actual = CreditCalculator.calcTotalRefundAmount(creditAmount, interestRate, numberOfMount) - creditAmount;
        Assertions.assertEquals(expected,actual);
    }
}
