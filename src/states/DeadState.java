package states;

import enums.SeverityLevel;
import enums.StateType;

public class DeadState extends PhysicalState {
    public DeadState() {
        super(StateType.DEAD, SeverityLevel.EXTREME, Integer.MAX_VALUE, "Dead");
    }

    @Override
    public String getEffectDescription() {
        return "Мертв";
    }
}
