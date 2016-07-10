package com.artkostm.flymer.flymerclient2.login;

import com.artkostm.flymer.flymerclient2.login.model.FlymerUserInfo;
import com.artkostm.flymer.flymerclient2.login.model.LoginModel;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Map;

/**
 * Created by arttsiom.chuiko on 10/07/16.
 */
public class LoginHelper {
    public static final String ULR_FORMATTER = "http://flymer.ru/req/login?ts=%d";

    private static final String FKEY_SELECTOR = "input[name='fkey']";
    private static final String LKEY_SELECTOR = "input[name='lkey']";

    public static FlymerUserInfo attemptLogin(LoginModel loginModel) {
        final FlymerUserInfo userInfo = new FlymerUserInfo();
        try {
            final Connection connection = Jsoup.connect("http://flymer.ru");
            final Document doc = connection.get();
            Map<String, String> cookies = connection.response().cookies();
            String fkey = doc.select(FKEY_SELECTOR).first().attr("value");
            String lkey = doc.select(LKEY_SELECTOR).first().attr("value");
            final int dkey = LoginValuesAlgorithm.dkey(fkey);
            cookies.put("fkey", fkey);

            String ac = Jsoup.connect(String.format(ULR_FORMATTER, System.currentTimeMillis()))
                    .data("pass", loginModel.getPassword())
                    .data("email", loginModel.getEmail())
                    .data("fkey",fkey)
                    .data("lkey",lkey)
                    .data("dkey",String.valueOf(dkey))
                    .header("Content-Type","application/x-www-form-urlencoded")
                    .header("Connection","keep-alive")
                    .cookies(cookies)
                    .method(Connection.Method.POST)
                    .execute().cookie("ac");

            cookies.put("lkey", lkey);
            cookies.put("dkey", String.valueOf(dkey));

            userInfo.setAc(ac);
            userInfo.setFkey(fkey);
            userInfo.setSid(cookies.get("sid"));
            userInfo.setCookiesMap(cookies);
        } catch (Exception e) {
            Error error = new Error("Attempt login fail", e);
            userInfo.setError(error);
        }
        return userInfo;
    }
}
