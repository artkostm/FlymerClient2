package com.artkostm.flymer.flymerclient2.login;

/**
 * Created by arttsiom.chuiko on 04/06/16.
 */
public final class LoginValuesAlgorithm {

    public static int dkey(final String fkey) {
        int n = 0;
        if (fkey != null && fkey.length() != 0) {
            for (int e = 0, g; e < fkey.length(); e++) {
                g = fkey.codePointAt(e);
                n = (n << 5) - n + g;
                n &= n;
            }
        }
        return n;
    }

}
