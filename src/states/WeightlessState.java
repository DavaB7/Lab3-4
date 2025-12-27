package states;

import enums.SeverityLevel;
import enums.StateType;

public class WeightlessState extends PhysicalState {
    public WeightlessState(SeverityLevel severity, int duration) {
        super(StateType.WEIGHTLESS, severity, duration, "Weightless");
    }

    @Override
    public String getEffectDescription() {
        return switch(severity) {
            case MILD -> "легкость в теле";
            case MODERATE -> "ощущение невесомости";
            case SEVERE -> "полная потеря веса";
            case EXTREME -> "ощущение что конечности отнялись";
        };
    }
}
