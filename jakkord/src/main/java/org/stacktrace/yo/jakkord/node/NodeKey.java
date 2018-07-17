package org.stacktrace.yo.jakkord.node;

import com.google.common.net.InetAddresses;
import org.stacktrace.yo.jakkord.hash.Hash;

import java.io.Serializable;
import java.net.InetAddress;

public class NodeKey implements Serializable {

    private final InetAddress myIp;
    private final String myHash;

    public NodeKey(InetAddress ip) {
        myIp = ip;
        myHash = Hash.hashIp(myIp);
    }

    public NodeKey(String ip) {
        boolean isAddress = InetAddresses.isInetAddress(ip);
        if (isAddress) {
            myIp = InetAddresses.forString(ip);
            myHash = Hash.hashIp(myIp);
        } else {
            throw new IllegalArgumentException("String provided is not an acceptable IPAddress: " + ip);
        }
    }

}
