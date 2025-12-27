package states;

import enums.SeverityLevel;
import enums.StateType;

public class NauseousState extends PhysicalState {
    public NauseousState(SeverityLevel severity, int duration) {
        super(StateType.NAUSEOUS, severity, duration, "Nausea");
    }

    @Override
    public String getEffectDescription() {
        return switch(severity) {
            case MILD -> "легкое подташнивание";
            case MODERATE -> "тошнота";
            case SEVERE -> "сильная тошнота";
            case EXTREME -> "невыносимая тошнота с рвотой";
        };
    }
}
