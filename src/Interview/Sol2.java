package Interview;

public class Sol2{

    public static void main(String[] args) {
        isSubsequence("abc","acbahbgdc");
    }

    public static boolean isSubsequence(String s, String t) {

            int len = s.length();
            int k=0;
            while(k<len){
                for(int i=0;i<t.length();i++){
                    if(s.charAt(k)==t.charAt(i)){
                        k++;
                    }
                    else if(s.indexOf(t.charAt(i))!=-1){
                        k=s.indexOf(t.charAt(i));
                    }
                }
            }
            if(k==len) return true;
            return false;
    }
}