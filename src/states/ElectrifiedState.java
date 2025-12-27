package states;

import enums.SeverityLevel;
import enums.StateType;

public class ElectrifiedState extends PhysicalState {
    public ElectrifiedState(SeverityLevel severity, int duration) {
        super(StateType.ELECTRIFIED, severity, duration, "Electric");
    }

    @Override
    public String getEffectDescription() {
        return switch(severity) {
            case MILD -> "легкий разряд электричества";
            case MODERATE -> "ощущаю сильный электрический разряд";
            case SEVERE -> "сильный разряд, больно!";
            case EXTREME -> "катастрофический разряд, невозможно выдержать!";
        };
    }
}
