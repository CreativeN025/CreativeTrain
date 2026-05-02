package Creative.train.Managers.Api;

import Creative.train.DataTypes.GlobalVariableHolder;
import Creative.train.DataTypes.RequestTypes.HostInformation;
import Creative.train.Managers.SessionManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(GlobalVariableHolder.apiPrefix+"/session")
public class SessionApi {
    static final SessionManager sessionManager=SessionManager.getInstance();


    @PostMapping("/start")
    public ResponseEntity<?> startSession(@RequestBody HostInformation data){
        UUID hostUuid = data.getHostUuid();
        UUID sessionUuid = data.getSessionId();
        if(sessionManager.getSession(sessionUuid)==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Session not found");
        }

        if(!sessionManager.getHostUuid(sessionUuid).equals(hostUuid)){
            return ResponseEntity.status(403).body("You are not the host");
        }
        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }
}
