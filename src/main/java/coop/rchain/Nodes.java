package coop.rchain;

/**
 * Available RChain nodes
 */
public class Nodes {

    // Root nodes
    public static final String NODE_0 = "node0.root-shard.mainnet.rchain.coop";
    public static final String NODE_1 = "node1.root-shard.mainnet.rchain.coop";
    public static final String NODE_2 = "node2.root-shard.mainnet.rchain.coop";
    public static final String NODE_3 = "node3.root-shard.mainnet.rchain.coop";
    public static final String NODE_4 = "node4.root-shard.mainnet.rchain.coop";
    public static final String NODE_5 = "node5.root-shard.mainnet.rchain.coop";
    public static final String NODE_6 = "node6.root-shard.mainnet.rchain.coop";
    public static final String NODE_7 = "node7.root-shard.mainnet.rchain.coop";
    public static final String NODE_8 = "node8.root-shard.mainnet.rchain.coop";

    // Read-only nodes
    public static final String OBSERVER_ASIA = "observer-asia.services.mainnet.rchain.coop";
    public static final String OBSERVER_US = "observer-us.services.mainnet.rchain.coop";
    public static final String OBSERVER_EU = "observer-eu.services.mainnet.rchain.coop";

    /**
     * Returns an unmodifiable set that contains all the root nodes
     */
    public static java.util.Set<String> allRoot() {
        java.util.Set<String> set = new java.util.HashSet<>();
        set.add(NODE_0);
        set.add(NODE_1);
        set.add(NODE_2);
        set.add(NODE_3);
        set.add(NODE_4);
        set.add(NODE_5);
        set.add(NODE_6);
        set.add(NODE_7);
        set.add(NODE_8);
        return java.util.Collections.unmodifiableSet(set);
    }

    /**
     * Returns an unmodifiable set that contains all the read-only nodes
     */
    public static java.util.Set<String> allReadOnly() {
        java.util.Set<String> set = new java.util.HashSet<>();
        set.add(OBSERVER_ASIA);
        set.add(OBSERVER_US);
        set.add(OBSERVER_EU);
        return java.util.Collections.unmodifiableSet(set);
    }

    /**
     * Returns an unmodifiable set that contains all the nodes
     */
    public static java.util.Set<String> all() {
        java.util.Set<String> set = new java.util.HashSet<>();
        set.addAll(allRoot());
        set.addAll(allReadOnly());
        return java.util.Collections.unmodifiableSet(set);
    }

    private Nodes() {
    }

}
