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

//    public static HashFunction goodFastHash(int minimumBits) {
//        int bits = (minimumBits + 31) & ~31;
//
//
//        if (bits == 32) {
//            return Murmur3_32HashFunction.GOOD_FAST_HASH_32;
//        }
//        if (bits <= 128) {
//            return Murmur3_128HashFunction.GOOD_FAST_HASH_128;
//        }
//
//        // Otherwise, join together some 128-bit murmur3s
//        int hashFunctionsNeeded = (bits + 127) / 128;
//        HashFunction[] hashFunctions = new HashFunction[hashFunctionsNeeded];
//        hashFunctions[0] = Murmur3_128HashFunction.GOOD_FAST_HASH_128;
//        int seed = GOOD_FAST_HASH_SEED;
//        for (int i = 1; i < hashFunctionsNeeded; i++) {
//            seed += 1500450271; // a prime; shouldn't matter
//            hashFunctions[i] = murmur3_128(seed);
//        }
//        return new Hashing.ConcatenatedHashFunction(hashFunctions);
//    }
}
