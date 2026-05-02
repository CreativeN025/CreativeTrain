package Creative.train.Managers.Api;

import Creative.train.DataTypes.GlobalVariableHolder;
import Creative.train.DataTypes.Player;
import Creative.train.DataTypes.RegisterPlayerResponse;
import Creative.train.DataTypes.RequestTypes.User;
import Creative.train.Managers.QrManager;
import Creative.train.Managers.SessionManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.UUID;

@RestController
@RequestMapping(GlobalVariableHolder.apiPrefix)
public class ApiHandler {
    static final SessionManager sessionManager=SessionManager.getInstance();

    @PostMapping("/registerUser")
    public ResponseEntity<?> registerUser(@RequestBody User data) {

        if (data == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Data not found");
        }

        Player player = new Player(
                data.getPlayerName(),
                data.getPlayerUuid(),
                data.isHost()
        );

        RegisterPlayerResponse result =
                sessionManager.registerPlayerToSession(data.getJoinedSession(), player);

        if (result.getHostInformation() != null) {
            return ResponseEntity.ok(result.getHostInformation());
        }

        return result.getResponse();
    }

    @GetMapping(path="/newPlayerQr",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getQrCode() throws Exception {
        BufferedImage image = QrManager.generateQrCode(GlobalVariableHolder.playerQrCodePrefix +UUID.randomUUID());

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "PNG", baos);

        return baos.toByteArray();
    }


}