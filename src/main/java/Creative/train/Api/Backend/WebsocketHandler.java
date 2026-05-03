package Creative.train.Api.Backend;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class WebsocketHandler {
    Map<UUID,SseEmitter> connectionMap = new HashMap<>();
    private final static WebsocketHandler INSTANCE = new WebsocketHandler();
    private WebsocketHandler(){

    }
    public static WebsocketHandler getInstance(){
        return INSTANCE;
    }

    public void stream(UUID playerUUID) {
        SseEmitter emitter = new SseEmitter();

        new Thread(() -> {
            try {
                emitter.send("Hello from server!");
            } catch (Exception e) {
                emitter.complete();
            }
        }).start();

        handleNewConnection(playerUUID,emitter);
    }
    private void handleNewConnection(UUID playerUUID,SseEmitter emitter){
        connectionMap.put(playerUUID,emitter);
    }
}
