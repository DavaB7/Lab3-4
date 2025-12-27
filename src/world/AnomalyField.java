package world;

import records.FieldConfig;
import characters.PoliceOfficer;
import states.*;
import enums.SeverityLevel;
import enums.Direction;
import java.util.Random;

public class AnomalyField {
    private final FieldConfig config;
    private final Random random = new Random();
    private static final double BASE_COEF = 0.2;

    public AnomalyField(FieldConfig config) { this.config = config; }

    private SeverityLevel chooseSeverity() {
        double coef = BASE_COEF + config.extraCoefficient() + random.nextDouble();
        if(coef < 0.6) return SeverityLevel.MILD;
        if(coef < 1.0) return SeverityLevel.MODERATE;
        if(coef < 1.4) return SeverityLevel.SEVERE;
        return SeverityLevel.EXTREME;
    }

    public void affectOfficer(PoliceOfficer officer) {
        double[] chances = {0.9, 0.6, 0.4};
        for(double chance : chances) {
            if(random.nextDouble() > chance) break;
            SeverityLevel severity = chooseSeverity();
            int type = random.nextInt(4);
            switch(type) {
                case 0 -> officer.applyState(new FlyingState(severity, 2, 1.5, Direction.UP));
                case 1 -> officer.applyState(new NauseousState(severity, 2));
                case 2 -> officer.applyState(new ElectrifiedState(severity, 2));
                case 3 -> officer.applyState(new WeightlessState(severity, 2));
            }
        }
    }
}
