package org.stacktrace.yo.jakkord.protocol;

import java.net.InetAddress;

public class ChordProtocol {

    public static final class NodeProps {
        private InetAddress myAddress;

        public NodeProps() {

        }

        public InetAddress getAddress() {
            return myAddress;
        }

        public NodeProps setAddress(InetAddress myAddress) {
            this.myAddress = myAddress;
            return this;
        }
    }
}
