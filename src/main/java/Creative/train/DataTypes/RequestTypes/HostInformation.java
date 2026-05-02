package Creative.train.DataTypes.RequestTypes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class HostInformation {
    private final UUID sessionId;
    private final UUID hostUuid;
    @JsonCreator
    public HostInformation(
        @JsonProperty("sessionId") UUID sessionId,
        @JsonProperty("hostUuid") UUID hostUuid

    )
        {
            this.sessionId = sessionId;
            this.hostUuid = hostUuid;
        }

    public UUID getHostUuid() {
        return hostUuid;
    }

    public UUID getSessionId() {
        return sessionId;
    }
}
