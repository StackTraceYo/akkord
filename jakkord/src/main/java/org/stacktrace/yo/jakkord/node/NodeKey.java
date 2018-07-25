package org.stacktrace.yo.jakkord.node;

import com.google.common.net.InetAddresses;
import org.stacktrace.yo.jakkord.util.hash.Hash;

import java.io.Serializable;
import java.net.InetAddress;

public class NodeKey implements Serializable {

    private final InetAddress myIp;
    private final long myHash;

    public NodeKey(InetAddress ip) {
        myIp = ip;
        myHash = Hash.hash(myIp);
    }

    public NodeKey(String ip) {
        boolean isAddress = InetAddresses.isInetAddress(ip);
        if (isAddress) {
            myIp = InetAddresses.forString(ip);
            myHash = Hash.hash(myIp);
        } else {
            throw new IllegalArgumentException("String provided is not an acceptable IPAddress: " + ip);
        }
    }

    public InetAddress getIp() {
        return myIp;
    }

    public Long getHash() {
        return myHash;
    }
}
