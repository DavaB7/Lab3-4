package states;

import enums.SeverityLevel;
import enums.StateType;
import enums.Direction;

public class FlyingState extends PhysicalState {
    private final double altitude;
    private final Direction direction;

    public FlyingState(SeverityLevel severity, int duration, double altitude, Direction direction) {
        super(StateType.FLYING, severity, duration, "Levitation");
        this.altitude = altitude;
        this.direction = direction;
    }

    @Override
    public String getEffectDescription() {
        return switch(severity) {
            case MILD -> "легкое парение в воздухе";
            case MODERATE -> "полет в воздухе";
            case SEVERE -> "стремительный полет в воздухе";
            case EXTREME -> "неконтролируемый полет вверх тормашками";
        };
    }
}
