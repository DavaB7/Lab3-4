package states;

import enums.SeverityLevel;
import enums.StateType;

public class NormalState extends PhysicalState {
    public NormalState() {
        super(StateType.NORMAL, SeverityLevel.MILD, Integer.MAX_VALUE, "Normal");
    }

    @Override
    public String getEffectDescription() {
        return "чувствую себя нормально";
    }
}
