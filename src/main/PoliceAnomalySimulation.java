package main;

import java.util.*;
import characters.PoliceOfficer;
import world.AnomalyField;
import records.FieldConfig;
import exceptions.InvalidInputException;

public class PoliceAnomalySimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            int level = -1;
            while(level < 0 || level > 4) {
                System.out.println("Выберите уровень тяжести аномалии (0-4):");
                String input = sc.nextLine().trim();
                try {
                    level = Integer.parseInt(input);
                    if(level < 0 || level > 4) throw new InvalidInputException("число должно быть от 0 до 4");
                } catch(NumberFormatException e) {
                    System.out.println(new InvalidInputException("некорректный ввод (не число)").getMessage());
                } catch(InvalidInputException e) { System.out.println(e.getMessage()); }
            }

            int choice = -1;
            while(choice < 0 || choice > 2) {
                System.out.println("Запустить аномалию? 0 — выход, 1 — назад, 2 — запуск");
                String input = sc.nextLine().trim();
                try {
                    choice = Integer.parseInt(input);
                    if(choice < 0 || choice > 2) throw new InvalidInputException("число должно быть 0, 1 или 2");
                } catch(NumberFormatException e) {
                    System.out.println(new InvalidInputException("некорректный ввод (не число)").getMessage());
                } catch(InvalidInputException e) { System.out.println(e.getMessage()); }
            }

            if(choice == 0) return;
            if(choice == 1) continue;

            FieldConfig config = new FieldConfig(level, level * 0.2);
            AnomalyField field = new AnomalyField(config);

            List<PoliceOfficer> officers = Arrays.asList(
                    new PoliceOfficer("Первый полицейский"),
                    new PoliceOfficer("Второй полицейский"),
                    new PoliceOfficer("Третий полицейский"),
                    new PoliceOfficer("Четвертый полицейский"),
                    new PoliceOfficer("Пятый полицейский"),
                    new PoliceOfficer("Шестой полицейский"),
                    new PoliceOfficer("Седьмой полицейский")
            );

            for(PoliceOfficer o : officers) { field.affectOfficer(o); o.experienceEffects(); }
            break;
        }
    }
}
