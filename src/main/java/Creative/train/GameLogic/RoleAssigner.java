package Creative.train.GameLogic;

import Creative.train.DataTypes.GlobalVariableHolder;
import Creative.train.DataTypes.Player;
import Creative.train.DataTypes.Session;
import Creative.train.GameLogic.Roles.Innocent;
import Creative.train.GameLogic.Roles.Role;
import Creative.train.GameLogic.Roles.Vigilante;
import Creative.train.Managers.SessionManager;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RoleAssigner {
    static SessionManager sessionManager = SessionManager.getInstance();
    public static int playersNeededForNewSpecialRole=6; //for testing, real value should be 6

    public static void assignAllRoles(Session session){
        List<UUID> uuids = session.getAllPlayerUuids();

        List<Role> roles = createRoles(uuids.size());
        for(UUID uuid : uuids){
            Player player = sessionManager.getPlayer(uuid);
            int max = roles.size();
            int index = (int) Math.floor((Math.random() * max));
            player.setRole(roles.get(index));
            roles.remove(index);
        }
    }
    private static Role getRandomRole(List<Class<? extends Role>> classList){
        int max = classList.size();
        int index = (int) (Math.random() * max);


        try {
            return classList.get(index).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            return null;
        }

    }

    static List<Role> createRoles(int playerCount) {
        List<Role> roleList=new ArrayList<>();
        var killers = GlobalVariableHolder.killerClasses;
        var neutrals = GlobalVariableHolder.neutralClasses;
        var innocents = GlobalVariableHolder.innocentClasses;

        int sets = playerCount / playersNeededForNewSpecialRole;

        //add a new killer/neutral for every playersNeededForNewSpecialRole players
        for (int i = 0; i < sets; i++) {

            Role killer = getRandomRole(killers);
            Role neutral = getRandomRole(neutrals);

            if (killer != null) roleList.add(killer);
            if (neutral != null) roleList.add(neutral);

            roleList.add(new Vigilante());
        }


        var noVigiInnocents = innocents.stream().filter(aClass -> !aClass.equals(Vigilante.class)).toList();
        while (roleList.size() < playerCount) {
            roleList.add(getRandomRole(noVigiInnocents));
        }
        return roleList;
    }
}
