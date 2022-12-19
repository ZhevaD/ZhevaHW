package Utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;
import java.sql.SQLOutput;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static void main(String[] args) {
//        System.out.println(randomString(10));
//        System.out.println(randomEmail(10));
//        System.out.println(randomNumber(100000L,9999999L));
//        System.out.println(randomPone("+000", 0000000L,9999999L));
//    }

        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        System.out.println(RandomStringUtils.random(20, false, false));
        System.out.println(RandomStringUtils.random(20, true, false));
        System.out.println(RandomStringUtils.random(20, true, true));
        System.out.println(RandomStringUtils.random(20, false, true));
    }

    static String randomString(int len) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
    static String randomEmail(int len) {
        return randomString(len) + "@zheva.com";
    }
    static Long randomNumber(Long min, Long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }
    static String randomPone(String prefix, Long min, Long max) {
        return prefix + randomNumber(min, max);
    }
}
