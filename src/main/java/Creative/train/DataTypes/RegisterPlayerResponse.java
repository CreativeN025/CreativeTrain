package Creative.train.DataTypes;

import Creative.train.DataTypes.RequestTypes.HostInformation;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.ResponseEntity;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterPlayerResponse {
    private HostInformation hostInformation;
    private ResponseEntity<?> response;

    public void setHostInformation(HostInformation hostInformation) {
        this.hostInformation = hostInformation;
    }

    public void setResponse(ResponseEntity<?> response) {
        this.response = response;
    }

    public HostInformation getHostInformation() {
        return hostInformation;
    }

    public ResponseEntity<?> getResponse() {
        return response;
    }
}
