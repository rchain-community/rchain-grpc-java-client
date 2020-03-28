package coop.rchain.comm.protocol.routing;

import coop.rchain.AbstractClient;
import io.grpc.Channel;
import io.grpc.stub.StreamObserver;

public class TransportLayer extends AbstractClient {

    private TransportLayer(Builder builder) {
        super(builder);
    }

    public TransportLayer(Channel channel) {
        this(new TransportLayer.Builder(channel));
    }

    public static final class Builder extends AbstractClient.Builder<TransportLayerGrpc.TransportLayerBlockingStub,
            TransportLayerGrpc.TransportLayerStub> {
        public Builder(Channel channel) {
            super(TransportLayerGrpc.newBlockingStub(channel), TransportLayerGrpc.newStub(channel));
        }

        @Override
        public TransportLayer build() {
            return new TransportLayer(this);
        }

        @Override
        public TransportLayer.Builder setBlockingStub(TransportLayerGrpc.TransportLayerBlockingStub blockingStub) {
            return (Builder) super.setBlockingStub(blockingStub);
        }

        @Override
        public TransportLayer.Builder setAsyncStub(TransportLayerGrpc.TransportLayerStub asyncStub) {
            return (Builder) super.setAsyncStub(asyncStub);
        }
    }

    public Routing.TLResponse send(Routing.TLRequest request) {
        return ((TransportLayerGrpc.TransportLayerBlockingStub) this.blockingStub).send(request);
    }

    public StreamObserver<Routing.Chunk> stream(StreamObserver<Routing.TLResponse> responseObserver) {
        return ((TransportLayerGrpc.TransportLayerStub) this.asyncStub).stream(responseObserver);
    }

}
