package org.stacktrace.yo.jakkord.node;

import com.google.common.collect.BoundType;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;

import java.net.InetAddress;
import java.util.List;
import java.util.Map;

public class JAkkordNode {

    private final NodeKey myKey;
    private final InetAddress myAddress;
    private final Map<Integer, NodeKey> myFingerTable = Maps.newHashMap();
    private final List<NodeKey> mySuccessors = Lists.newArrayList();
    private NodeKey myPredecessor;
    private Range<Long> myRange;

    public JAkkordNode(InetAddress address) {
        myAddress = address;
        myKey = new NodeKey(myAddress);
        myPredecessor = myKey;
        myRange = createRange(myKey, myKey);
    }

    private Range<Long> createRange(NodeKey from, NodeKey to) {
        return createRange(from.getHash(), to.getHash());
    }

    private Range<Long> createRange(long from, long to) {
        return Range.range(from, BoundType.OPEN, to, BoundType.CLOSED);
    }

    public boolean join(NodeKey nodeKey) {
        if (!nodeKey.equals(myKey)) {
            return false;
        }
        return false;
    }

    public NodeKey findSuccessor(NodeKey nodeKey) {
        if(inRange(nodeKey)){
            return getSuccessor();
        }else{
            //ask successor
            return getSuccessor();
        }
    }

    private boolean inRange(NodeKey nodeKey) {
        return myRange.contains(nodeKey.getHash());
    }

    public NodeKey getSuccessor() {
        return myFingerTable.get(1);
    }

    public NodeKey getKey() {
        return myKey;
    }

    public InetAddress getAddress() {
        return myAddress;
    }
}
