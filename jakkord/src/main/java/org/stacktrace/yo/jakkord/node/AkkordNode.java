package org.stacktrace.yo.jakkord.node;

import com.google.common.collect.BoundType;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;

import java.net.InetAddress;
import java.util.List;
import java.util.Map;

public class AkkordNode {

    private final NodeProps myKey;
    private final InetAddress myAddress;
    private final Map<Integer, NodeProps> myFingerTable;
    private final List<NodeProps> mySuccessors = Lists.newArrayList();
    private NodeProps myPredecessor;
    private Range<Long> myRange;

    public AkkordNode(InetAddress address) {
        myAddress = address;
        myKey = new NodeProps(myAddress);
        myPredecessor = myKey;
        myRange = createRange(myKey, myKey);
        myFingerTable = initFingerTable();

    }

    private Map<Integer, NodeProps> initFingerTable() {
        return Maps.newLinkedHashMap();
    }

    private Range<Long> createRange(NodeProps from, NodeProps to) {
        return createRange(from.getHash(), to.getHash());
    }

    private Range<Long> createRange(long from, long to) {
        return Range.range(from, BoundType.OPEN, to, BoundType.CLOSED);
    }

    public boolean join(NodeProps nodeProps) {
        if (!nodeProps.equals(myKey)) {
            return false;
        }
        return false;
    }

    public NodeProps findSuccessor(NodeProps nodeProps) {
        if (inRange(nodeProps)) {
            return getSuccessor();
        } else {
            //ask successor
            return getSuccessor();
        }
    }

    private boolean inRange(NodeProps nodeProps) {
        return myRange.contains(nodeProps.getHash());
    }

    public NodeProps getSuccessor() {
        return myFingerTable.get(1);
    }

    public NodeProps getKey() {
        return myKey;
    }

    public InetAddress getAddress() {
        return myAddress;
    }
}
