package string;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UniqueEmail {

    public int solve_1(String[] emails){
        Set<String> set=new HashSet<>();

        for(String email:emails){
            String localName=makeLocalName(email);
            String dName=makeDName(email);

            set.add(localName+"@"+dName);
            System.out.println(localName+"@"+dName);
        }

        return set.size();
    }

    public int solve_2(String[] emails){
        return 0;
    }

    public int split(String[] emails){
        Set<String> set=new HashSet<>();
        for(String email:emails){
            String[] split = email.split("@");
            String[] localName = split[0].split("[+]");
            set.add(localName[0].replace(".", "") + "@" + split[1]);
        }

        return set.size();
    }

    private String makeLocalName(String email){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<email.length();i++){
            if(email.charAt(i)=='.'){
                continue;
            }
            if(email.charAt(i)=='+'){
                break;
            }
            if(email.charAt(i)=='@'){
                break;
            }

            sb.append(email.charAt(i));

        }
        return sb.toString();
    }

    private String makeDName(String email){
        return email.substring(email.indexOf('@')+1);
    }
}
