package Creative.train.DataTypes.RequestTypes;

import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private final UUID playerUuid;
    private final String playerName;
    private final UUID joinedSession;
    private final boolean isHost;

    @JsonCreator
    public User(
            @JsonProperty("playerUuid") UUID playerUuid,
            @JsonProperty("playerName") String playerName,
            @JsonProperty("joinedSession") UUID joinedSession
    ) {
        this.playerUuid = playerUuid;
        this.playerName = playerName;
        this.joinedSession = joinedSession;
        this.isHost = (joinedSession == null); // infer host
    }

    public boolean isHost() {
        return isHost;
    }

    public UUID getPlayerUuid() { return playerUuid; }
    public String getPlayerName() { return playerName; }
    public UUID getJoinedSession() { return joinedSession; }
}