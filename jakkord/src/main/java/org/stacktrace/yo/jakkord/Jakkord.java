package org.stacktrace.yo.jakkord;

import org.stacktrace.yo.jakkord.network.Network;
import org.stacktrace.yo.jakkord.node.Node;
import org.stacktrace.yo.jakkord.protocol.ChordProtocol;

public class Jakkord {

    private Node myNode;


    public Jakkord create(Node node) {
        return this;
    }

    public Jakkord join(ChordProtocol.NodeProps node) {
        return this;
    }


    public static void main(String args[]) {
        // start server
        Network.findIp();
    }

}
