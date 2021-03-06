package com.datasift.client.odp;

import com.datasift.client.DataSiftIngestionResult;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ODPBatchResponse extends DataSiftIngestionResult {
    @JsonProperty("accepted")
    protected long interactionsProcessed;
    @JsonProperty("total_message_bytes")
    protected long bytesProcessed;

    public ODPBatchResponse() { }

    public long getInteractionsProcessed() {
        return interactionsProcessed;
    }

    public long getBytesProcessed() {
        return bytesProcessed;
    }
}
