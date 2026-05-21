package Creative.train.GameLogic.Roles;

import Creative.train.DataTypes.GlobalVariableHolder;
import Creative.train.GameLogic.Items.Gun;

public class Vigilante extends Role{

    public Vigilante() {
        super("Vigilante", Team.CIVILIAN,"#0092fa");
        Gun gun = new Gun("Revolver");
        baseInventory.add(gun);
    }

}
