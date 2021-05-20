package AllTime;

import org.junit.platform.commons.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class MatchString {
    /*
Find the particular string pattern and exist in the larger string
*/

    public boolean patternExistInString(String string, String pattern) {
        if (StringUtils.isBlank(pattern) || StringUtils.isBlank(string)){
            return false;}

        {
            int count = 1;
            Map<Character, Integer> patternCharToValueMap = new HashMap<>();
            for (char c : pattern.toCharArray()) {
                if (patternCharToValueMap.containsKey(c)) {
                    int value = patternCharToValueMap.get(c);
                    patternCharToValueMap.put(c, ++value);
                } else {
                    patternCharToValueMap.put(c, count);
                }
            }
            for (char c : string.toCharArray()) {
                if (patternCharToValueMap.containsKey(c)) {
                    patternCharToValueMap.put(c, patternCharToValueMap.get(c) - 1);
                    if (patternCharToValueMap.get(c) == 0) {
                        if (patternCharToValueMap.isEmpty()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}