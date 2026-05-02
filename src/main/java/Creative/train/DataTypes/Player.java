package Creative.train.DataTypes;

import java.util.UUID;

public class Player {
    private boolean isAlive=true;
    private final String name;
    private final UUID playerId;
    private final boolean isHost;
    public Player(String name, UUID playerId,boolean isHost){
        this.name = name;
        this.playerId = playerId;
        this.isHost = isHost;
    }

    public boolean isHost() {
        return isHost;
    }

    public String getName() {
        return name;
    }

    public UUID getPlayerId() {
        return playerId;
    }
    public void setAlive(boolean alive){
        isAlive=alive;
    }

    public boolean isAlive() {
        return isAlive;
    }
}
