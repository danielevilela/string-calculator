package com.dvilela.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static List<Integer> negatives = new ArrayList<>();

    public static int add(String numbers) throws Exception {
        int res = 0;
        List<Integer> listNegatives = new ArrayList<>();
        Pattern p = Pattern.compile("-?\\d+");
        Matcher m = p.matcher(numbers);

        while(m.find()) {
            int n = Integer.parseInt(m.group());

            if(n > 1000) {
                continue;
            }

            if ( n < 0 ) {
                listNegatives.add(n);
            }

            res += n;
        }
        negatives = listNegatives;
        if(negatives.size() > 0){
            throw new Exception("Exception: Negatives not allowed " + negatives.toString());
        }
        return res;
    }
}
