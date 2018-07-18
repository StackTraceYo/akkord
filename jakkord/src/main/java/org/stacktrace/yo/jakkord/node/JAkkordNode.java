package org.stacktrace.yo.jakkord.node;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.net.InetAddress;
import java.util.List;
import java.util.Map;

public class JAkkordNode implements Node {

    private final NodeKey myKey;
    private final InetAddress myAddress;
    private final List<NodeKey> mySuccessors = Lists.newArrayList();
    private final Map<Integer, NodeKey> myFingerTable = Maps.newHashMap();
    private NodeKey myPredecessor;

    public JAkkordNode(InetAddress address) {
        myAddress = address;
        myKey = new NodeKey(myAddress);
    }

    public NodeKey getKey() {
        return myKey;
    }

    public InetAddress getAddress() {
        return myAddress;
    }

    @Override
    public Node join(Node newNode) {
        return this;
    }
}
