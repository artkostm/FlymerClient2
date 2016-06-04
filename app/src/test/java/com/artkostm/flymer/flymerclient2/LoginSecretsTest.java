package com.artkostm.flymer.flymerclient2;

import com.artkostm.flymer.flymerclient2.login.LoginValuesAlgorithm;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class LoginSecretsTest {
    @Test
    public void testDKEY() throws Exception {
        String fkey = "5ZfwGo0Ilv0C3ap6";
        int dkey = LoginValuesAlgorithm.dkey(fkey);
        System.out.println("dkey value is " + dkey);
        assertEquals(2032372968, dkey);
    }
}