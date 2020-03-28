package coop.rchain.casper.protocol.propose.v1;

import coop.rchain.AbstractClient;
import coop.rchain.casper.protocol.ProposeServiceCommon;
import io.grpc.Channel;

public class ProposeService extends AbstractClient {

    private ProposeService(Builder builder) {
        super(builder);
    }

    public ProposeService(Channel channel) {
        this(new Builder(channel));
    }

    public static final class Builder extends AbstractClient.Builder<ProposeServiceGrpc.ProposeServiceBlockingStub,
            ProposeServiceGrpc.ProposeServiceStub> {
        public Builder(Channel channel) {
            super(ProposeServiceGrpc.newBlockingStub(channel), ProposeServiceGrpc.newStub(channel));
        }

        @Override
        public ProposeService build() {
            return new ProposeService(this);
        }

        @Override
        public Builder setBlockingStub(ProposeServiceGrpc.ProposeServiceBlockingStub blockingStub) {
            return (Builder) super.setBlockingStub(blockingStub);
        }

        @Override
        public Builder setAsyncStub(ProposeServiceGrpc.ProposeServiceStub asyncStub) {
            return (Builder) super.setAsyncStub(asyncStub);
        }
    }


    public ProposeServiceV1.ProposeResponse propose(ProposeServiceCommon.PrintUnmatchedSendsQuery request) {
        return ((ProposeServiceGrpc.ProposeServiceBlockingStub) this.blockingStub).propose(request);
    }

}
