package org.stacktrace.yo.jakkord.node;

import org.stacktrace.yo.jakkord.protocol.ChordProtocol.NodeProps;

public interface Node {

    NodeProps join(NodeProps newNode);

    NodeProps notify(NodeProps successor);

    NodeProps pNotify(NodeProps predecessor);

    NodeProps findSuccessor();

    NodeProps findPredecessor();

}
