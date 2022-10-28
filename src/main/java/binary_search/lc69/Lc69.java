package binary_search.lc69;

public class Lc69 {
    public long mySqrt(int x){
        int right = 1, left = x, res = 0;

        while (right <= left){
            int mid = right + (left - right) / 2;
            //java中long数据类型占8个字节，64位,取值范围是-2^64 (-9223372036854775808)~ 2^64-1(9223372036854775807)
            //int的取值范围为： -2^31——2^31-1，即-2147483648——2147483647
            if((long)mid * mid <= x){
                right = mid + 1;
                res = mid;
            }else {
                left = mid - 1;
            }
        }
        return res;
    }
}
