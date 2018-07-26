package org.stacktrace.yo.jakkord.node;

public interface Node {

    String join(String newNode);

    String notify(String successor);

    String pNotify(String predecessor);

    String findSuccessor();

    String findPredecessor();

}
