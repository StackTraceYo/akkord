package org.stacktrace.yo.jakkord.hash;

import com.google.common.hash.Hashing;
import com.google.common.net.InetAddresses;

import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class Hash {


    public static String hashIp(String ip) {
        return Hashing.sha256()
                .hashString(ip, StandardCharsets.UTF_8)
                .toString();
    }

    public static String hashIp(InetAddress ip) {
        return Hashing.sha256()
                .hashString(InetAddresses.toAddrString(ip), StandardCharsets.UTF_8)
                .toString();
    }
}
