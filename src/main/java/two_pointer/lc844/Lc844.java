package two_pointer.lc844;


class Lc844 {
    public boolean backspaceCompare(String S, String T) {
        // two pointers
        return isClear(S).equals(isClear(T));
    }
    public String isClear(String S){
        char[] arr = new char[S.length()];
        int j = 0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)!='#')
                arr[j++] = S.charAt(i);
            else{
                if(j>0){
                    j--;
                }
            }
        }
        return String.valueOf(arr).substring(0,j);
    }
}

