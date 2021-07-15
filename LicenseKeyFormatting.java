package string;

public class LicenseKeyFormatting {

    public String solve(String str,int k){
        String replace = str.replace("-", "");
        String newStr = replace.toUpperCase();

        StringBuilder sb=new StringBuilder(newStr);

        int length=sb.length();
        for(int i=k;i<length;i=i+k){
            sb.insert(length-i,'-');
        }
        return sb.toString();
    }
}
