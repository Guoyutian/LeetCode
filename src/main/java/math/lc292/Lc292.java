package math.lc292;

public class Lc292 {
    public boolean canWinNim(int n) {
        if (n <= 0) {
            return false;
        }
        return n % 4 != 0;
    }
}
