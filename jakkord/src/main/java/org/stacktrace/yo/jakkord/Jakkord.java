package org.stacktrace.yo.jakkord;

import com.google.common.net.InetAddresses;
import org.stacktrace.yo.jakkord.network.Network;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Jakkord {

    public static void main(String args[]) {
        // start server
        Network.findIp();
    }

}
