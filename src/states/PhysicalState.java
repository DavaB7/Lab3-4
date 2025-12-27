package states;

import enums.StateType;
import enums.SeverityLevel;
import java.util.Objects;

public abstract class PhysicalState {
    protected final StateType type;
    protected final SeverityLevel severity;
    protected int duration;
    protected final String description;

    protected PhysicalState(StateType type, SeverityLevel severity, int duration, String description) {
        this.type = type;
        this.severity = severity;
        this.duration = duration;
        this.description = description;
    }

    public abstract String getEffectDescription();

    public boolean isActive() { return duration > 0; }
    public void decreaseDuration() { if(duration > 0) duration--; }

    public StateType getType() { return type; }
    public SeverityLevel getSeverity() { return severity; }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof PhysicalState s)) return false;
        return type == s.type && severity == s.severity && duration == s.duration;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, severity, duration);
    }

    @Override
    public String toString() {
        return type + " (" + severity + ", длительность: " + duration + ")";
    }
}
