package net.mikoto.pixiv.engine.util;

import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author wang864676212 https://blog.csdn.net/wang864676212
 * @modify mikoto
 */
public class Sha256Util {
    /**
     * Encode normal string to sha256 string.
     *
     * @param str The string you need to encode.
     * @return A sha256 string.
     */
    @NotNull
    public static String getSha256(@NotNull String str) {
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encodeStr.toUpperCase();
    }

    /**
     * Encode byte to hex.
     *
     * @param bytes The byte you need to encode.
     * @return Hex.
     */
    @NotNull
    private static String byte2Hex(@NotNull byte[] bytes) {
        StringBuilder stringBuffer = new StringBuilder();
        String temp;
        for (byte aByte : bytes) {
            temp = Integer.toHexString(aByte & 0xFF);
            if (temp.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

}