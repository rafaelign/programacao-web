package ine5646.primo.modelo;

/**
 *
 * @author leandro
 */
public class VerificadorDePrimo {

    public boolean ehPrimo(long num) {
        if (num % 2 == 0 || num % 5 == 0) {
            return false;
        }
        boolean primo = true;
        long divisor = 3;
        while (primo && num / divisor > 1) {
            if (num % divisor == 0) {
                primo = false;
            } else {
                divisor = divisor + 2;
            }
        }
        return primo;
    }

}
