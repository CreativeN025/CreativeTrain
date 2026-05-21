package Creative.train.DataTypes.Wrappers.Configs;

import Creative.train.DataTypes.Wrappers.RoleData;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class RoleLoader {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static RoleData load(String fileName) {

        try{

            InputStream stream = RoleLoader.class
                    .getResourceAsStream("/roles/" + fileName);
            return mapper.readValue(stream, RoleData.class);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}