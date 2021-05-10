package dynamic;

import java.util.*;

public class StringDecomposition {
    //Suppose you are designing a search engine. In addition to getting keywords from
//a page's content, you would like to get keywords from Uniform Resource Locators
//(URLs). For example, bedbathandbeyond.com yields the keywords "bed, bath, beyond,
//bat, hand": the first two coming from the decomposition "bed bath beyond" and the
//latter two coming from the decomposition "bed bat hand beyond".
//Given a dictionary i.e., a set of strings, and a name, design an efficient algorithm that
//checks whether the name is the concatenation of a sequence of dictionary words. If
//such a concatenation exists, return it. A dictionary word may appear more than once
//in the sequence, e.g., "a", "man", "a", "plan", "a", "canal" is a valid sequence for
//"amanaplanacanal".

    //String ->BedBathAndBeyond.com
    public static List<String> decompositionDict(String domain, Set<String> dict){
        int [] lastLength = new int [domain.length()];
        Arrays.fill(lastLength,-1);
        for(int i=0;i<domain.length();i++){
            if(dict.contains(domain.substring(0,i+1)))
            lastLength[i]= i+1;
            if(lastLength[i]==-1){
                for(int j=0;j<i;j++){
                    if(lastLength[j]!=-1 && dict.contains(domain.substring(j+1,i+1))){
                        lastLength[i]= i-j;
                        break;
                    }
                }
            }
        }
        List<String> decompositions = new ArrayList<>();
        if(lastLength[lastLength.length-1]!=-1){
            int idx = domain.length()-1;
            while(idx>=0){
                decompositions.add(domain.substring(idx+1- lastLength[idx],idx+1));
                idx-=lastLength[idx];
            }
            Collections.reverse(decompositions);
        }
        return decompositions;
    }
}
