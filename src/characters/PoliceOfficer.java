package characters;

import interfaces.Damageable;
import states.*;
import enums.SeverityLevel;
import java.util.*;

public class PoliceOfficer implements Damageable {
    private static int nextId = 1;
    private final int id;
    private final String name;
    private int health = 100;
    private final List<PhysicalState> states = new ArrayList<>();
    private final Random random = new Random();

    public PoliceOfficer(String name) { this.id = nextId++; this.name = name; }

    private int damageBySeverity(SeverityLevel s) {
        return switch(s) {
            case MILD -> 10;
            case MODERATE -> 20;
            case SEVERE -> 30;
            case EXTREME -> 40;
        };
    }

    public void applyState(PhysicalState state) {
        if(states.size() >= 3) return;
        states.removeIf(s -> s.getType() == state.getType());
        states.add(state);
        takeDamage(damageBySeverity(state.getSeverity()));
        checkHealthState();
    }

    private void checkHealthState() {
        if(health <= 0) { states.clear(); states.add(new DeadState()); }
        else if(health <= 10) { states.clear(); states.add(new UnconsciousState()); }
        else if(health >= 90) { states.add(new NormalState()); }
    }

    public boolean isAlive() { return health > 0; }
    public boolean isConscious() { return health > 10; }
    public int getDisplayHealth() { return Math.max(health, 0); }

    @Override
    public void takeDamage(int amount) { health -= amount; }
    @Override
    public boolean isDead() { return health <= 0; }

    public void experienceEffects() {
        System.out.println("\n" + name + " (здоровье: " + getDisplayHealth() + "%) рассказывает:");
        if(states.isEmpty()) { System.out.println("Ничего особенного не почувствовал."); return; }
        for(PhysicalState s : states) { if(s.isActive()) { System.out.println("*" + s.getEffectDescription() + "*"); s.decreaseDuration(); } }
        if(isAlive() && isConscious() && !states.isEmpty()) {
            String[] comments = {"Это было совершенно неожиданно!", "Никогда не испытывал ничего подобного!", "До сих пор не могу прийти в себя."};
            System.out.println(comments[random.nextInt(comments.length)]);
        }
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof PoliceOfficer p)) return false;
        return id == p.id && Objects.equals(name, p.name);
    }

    @Override
    public int hashCode() { return Objects.hash(id, name); }

    @Override
    public String toString() { return "PoliceOfficer{" + "id=" + id + ", name='" + name + '\'' + ", health=" + health + '}'; }
}
