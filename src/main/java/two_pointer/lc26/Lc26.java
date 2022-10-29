package two_pointer.lc26;

public class Lc26 {
    public static int removeDuplicates(int[] A) {
        if(A==null || A.length==0) return 0;
        int p = 1;
        for(int i=1;i<A.length;i++) if(A[i]!=A[i-1]) A[p++]=A[i];
        return p;
    }
}
