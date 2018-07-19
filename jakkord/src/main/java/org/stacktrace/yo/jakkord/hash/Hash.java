package org.stacktrace.yo.jakkord.hash;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.net.InetAddresses;

import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Hash {

    private static final int SEED = 1531969054;

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

    public static HashFunction fixedFastHash(int minimumBits) {
        int bits = (minimumBits + 31) & ~31;

        if (bits == 32) {
            return fixed_murmur3_32();
        }
        if (bits <= 128) {
            return fixed_murmur3_128();
        }

        int hashFunctionsNeeded = (bits + 127) / 128;
        HashFunction[] hashFunctions = new HashFunction[hashFunctionsNeeded];
        hashFunctions[0] = fixed_murmur3_128();
        int seed = SEED;
        for (int i = 1; i < hashFunctionsNeeded; i++) {
            seed += 1500450271; // a prime; shouldn't matter
            hashFunctions[i] = murmur3_128(seed);
        }
        return Hashing.concatenating(Arrays.asList(hashFunctions));
    }

    public static HashFunction fixed_murmur3_128() {
        return murmur3_128(SEED);
    }

    public static HashFunction murmur3_128(int seed) {
        return Hashing.murmur3_128(seed);
    }

    public static HashFunction murmur3_32(int seed) {
        return Hashing.murmur3_32(seed);
    }

    public static HashFunction fixed_murmur3_32() {
        return murmur3_32(SEED);
    }
}
