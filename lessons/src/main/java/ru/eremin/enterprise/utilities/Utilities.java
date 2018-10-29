package ru.eremin.enterprise.utilities;

import lombok.SneakyThrows;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Utilities {

    @SneakyThrows
    public static String getHash(final String s) {
        final MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        final byte[] bytes = ("1112_54$%" + s).getBytes(StandardCharsets.UTF_8);
        final byte[] hex = messageDigest.digest(bytes);
        return DatatypeConverter.printHexBinary(hex);
    }
}
