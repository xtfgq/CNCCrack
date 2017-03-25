package com.cnc.cnccrack;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Administrator on 2017/3/24.
 */

public class CncUtils {
    public static String  DeCode(char num[]){
        String ustr = "9012345678abcdeABCDEFGHIJKLMNfghijklmnUVWXYZxyzuvwopqrstOPQRST";
        String yinzi = "25-35-182-236-43-41-53-18-226-215-24-117-35-201-52-17";
        String[] yzarr = yinzi.split("-");
        Collections.reverse(Arrays.asList(yzarr));
        int l = 37, k = 0, u1, x;
        char[] dec_str = new char[num.length];
        for (int i = 0; i < num.length; i++)
        {
            for (int j = 0; j < ustr.length(); j++)
            {
                if (num[i] == (int)ustr.charAt(j))
                {
                    if (i < 16)
                    {
                        u1 = Integer.parseInt(yzarr[i]);
                    } else{
                        x = i % 16;
                        u1 = Integer.parseInt(yzarr[x]);
                    }
                    u1 = ((u1 ^ (l * 3)) ^ k) + j;
                    x = u1 % 62;
                    dec_str[i]=ustr.charAt(x);
                    l = l ^ (x + 9433);
                    break;
                }
            }
            if (dec_str[i]=='\0')
                dec_str[i]=ustr.charAt(i);
                 k = k + 5;
        }
        return "2:" + String.valueOf(dec_str);
    }
}
