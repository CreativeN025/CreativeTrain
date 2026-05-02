package Creative.train.DataTypes;

import java.util.*;

public class Session {
    private boolean active;
    private final UUID sessionId;
    private final Map<String,Player> playerMap = new HashMap<>();
    private final UUID hostUuid;
    public Session(UUID hostUuid){
        sessionId = UUID.randomUUID();
        this.hostUuid = hostUuid;
    }

    public void setActive() {
        this.active = true;
    }
    public boolean addPlayer(Player player){
        if(playerMap.containsKey(player.getName())) return false;
        playerMap.put(player.getName(),player);
        return true;
    }

    public UUID getSessionId() {
        return sessionId;
    }

    public Map<String,Player> getPlayerMap() {
        return playerMap;
    }

    public UUID getHostUuid() {
        return hostUuid;
    }
}
