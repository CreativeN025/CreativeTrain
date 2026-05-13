package Creative.train.Api.WebServer;

import Creative.train.Managers.SessionManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class LoadPages {
    @GetMapping("/")
    public String home() {
        return "index.html";
    }
    @GetMapping("/activeGame")
    public String activeGame(@RequestParam(value = "sessionUuid",required = false) UUID sessionUuid) {
        if(SessionManager.getInstance().getSession(sessionUuid)==null) return "index.html";
        return "activeGame.html";
    }
}
