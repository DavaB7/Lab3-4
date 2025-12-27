package states;

import enums.SeverityLevel;
import enums.StateType;

public class UnconsciousState extends PhysicalState {
    public UnconsciousState() {
        super(StateType.UNCONSCIOUS, SeverityLevel.SEVERE, Integer.MAX_VALUE, "Unconscious");
    }

    @Override
    public String getEffectDescription() {
        return "Без сознания";
    }
}
