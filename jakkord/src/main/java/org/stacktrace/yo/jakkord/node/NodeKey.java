package org.stacktrace.yo.jakkord.node;

import com.google.common.net.InetAddresses;
import org.stacktrace.yo.jakkord.util.hash.Hash;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.Objects;

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
            throw new IllegalArgumentException("provided string is not an acceptable IPAddress: " + ip);
        }
    }

    public InetAddress getIp() {
        return myIp;
    }

    public Long getHash() {
        return myHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeKey nodeKey = (NodeKey) o;
        return myHash == nodeKey.myHash &&
                Objects.equals(myIp, nodeKey.myIp);
    }

    @Override
    public int hashCode() {

        return Objects.hash(myIp, myHash);
    }

}
