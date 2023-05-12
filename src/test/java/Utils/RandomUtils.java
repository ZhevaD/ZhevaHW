package Utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;
import java.sql.SQLOutput;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static void main(String[] args) {

        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        System.out.println(RandomStringUtils.random(20, false, false));
        System.out.println(RandomStringUtils.random(23, true, false));
        System.out.println(RandomStringUtils.random(64, true, true));
        System.out.println(RandomStringUtils.random(20, false, true));
    }

    public static String randomString(int len) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
    public static String randomEmail(int len) {
        return randomString(len) + "@zheva.com";
    }
    public static Long randomNumber(Long min, Long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }
    public static String randomPhone(String prefix, Long min, Long max) {
        return prefix + randomNumber(min, max);
    }
}
