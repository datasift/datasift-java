package com.datasift.client;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Courtney Robinson <courtney.robinson@datasift.com>
 */
public class Response {
    protected String data;
    protected io.higgs.http.client.Response rawResponse;
    private Map<String, List<String>> headers = new HashMap<>();

    public Response(String data, io.higgs.http.client.Response rawResponse) {
        this.data = data;
        this.rawResponse = rawResponse;
        //we're doing this here to ensure it's only done once and to avoid exposing any classes from the underlying client
        //this means we can swap out the client if need be without breaking the public API
        for (String name : rawResponse.getHeaders().names()) {
            headers.put(name, rawResponse.getHeaders().getAll(name));
        }
    }

    /**
     * @return The HTTP status returned by the API e.g 200, 400, 404 etc...
     */
    public int status() {
        return rawResponse.getStatus().code();
    }

    /**
     * @return Status reason/message e.g. "OK" or "Not Found"
     */
    public int statusMessage() {
        return rawResponse.getStatus().code();
    }

    /**
     * @return The HTTP protocol version e.g. 1.0 or 1.1
     */
    public float protocolVersion() {
        return Float.parseFloat(rawResponse.getProtocolVersion().majorVersion()
                + "." + rawResponse.getProtocolVersion().minorVersion());
    }

    /**
     * @return True if this response was returned with transfer encoding set to "chunked"
     */
    public boolean isChunked() {
        return rawResponse.isChunked();
    }

    /**
     * @return The data returned by the DataSift API.
     */
    public String data() {
        return data;
    }

    public Map<String, List<String>> headers() {
        return headers;
    }

    @Override
    public String toString() {
        try {
            return DataSiftClient.MAPPER.writeValueAsString(rawResponse);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Unable to generate string representation of this response/result";
        }
    }

}
