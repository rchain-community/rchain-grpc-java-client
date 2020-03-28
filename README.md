# [WIP] RChain gRPC API Client Library for Java

Communicate with the RChain blockchain.

This page contains information about getting started with the RChain gRPC API
using the RChain gRPC API Client Library for Java. In addition, you may be interested
in the following documentation:

* The [RChain cooperative website](https://developer.rchain.coop/)
* The [RChain open-source repository](https://github.com/rchain/)

## Quickstart example

```java
import coop.rchain.casper.protocol.DeployServiceCommon;
import coop.rchain.casper.protocol.deploy.v1.DeployService;
import coop.rchain.casper.protocol.deploy.v1.DeployServiceV1;
import io.grpc.ManagedChannelBuilder;

public class RChainQuickstart {

    /**
     * Prints the block related to the hash
     */
    public static void main(String... args) {
        // Init the client with EU read-only node
        DeployService deployService = new DeployService.Builder(
                ManagedChannelBuilder.forAddress(
                        coop.rchain.Nodes.OBSERVER_EU, 40401)
                        .usePlaintext()
                        .build())
                .build();
        
        // Build the api query
        DeployServiceCommon.BlockQuery blockQuery = DeployServiceCommon.BlockQuery.newBuilder()
                .setHash("<BLOCK_HASH>")
                .build();
        
        // Execute the request and print response
        DeployServiceV1.BlockResponse blockResponse = deployService.getBlock(blockQuery);
        System.out.printf(blockResponse.toString());
    }

}
```