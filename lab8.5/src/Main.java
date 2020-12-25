import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Squad army = new Squad(new Rases());
        Squad squad = new Squad(new Elf());
        army.addSquad(squad);
        army.addSquad(new Squad(new Dragon()));
        army.addUnit(new Unit(new Centaur()));
        army.addUnit(new Unit(new Orc()));
        for(Squad i : army.getSquads()){
            i.define();
        }
        for(Unit i : army.getUnits()){
            i.define();
        }
    }
}

abstract class Army {
    protected Rase rase;

    public Army(Rase rase) {
        this.rase = rase;
    }

    public abstract void define();
}

class Squad extends Army {

    public Squad(Rase rase) {
        super(rase);
    }

    @Override
    public void define() {
        System.out.print("Squad from ");
        rase.defineRase();
        System.out.print("s\n");
    }

    List<Squad> squads = new ArrayList<>();
    List<Unit> units = new ArrayList<>();

    void addSquad(Squad squad){
        squads.add(squad);
    }

    void removeSquad(Squad squad){
        squads.remove(squad);
    }

    List<Squad> getSquads(){
        return squads;
    }

    void addUnit(Unit unit){
        units.add(unit);
    }

    void removeUnit(Unit unit){
        units.remove(unit);
    }

    List<Unit> getUnits(){
        return units;
    }
}

class Unit extends Army {

    public Unit(Rase rase) {
        super(rase);
    }

    @Override
    public void define() {
        System.out.print("Unit ");
        rase.defineRase();
        System.out.print("\n");
    }
}

interface Rase {
    void defineRase();
}

class Elf implements Rase {
    @Override
    public void defineRase() {
        System.out.print("Elf");
    }
}

class Orc implements Rase {
    @Override
    public void defineRase() {
        System.out.print("Orc");
    }
}

class Minotaur implements Rase {
    @Override
    public void defineRase() {
        System.out.print("Minotaur");
    }
}

class Centaur implements Rase {
    @Override
    public void defineRase() {
        System.out.print("Centaur");
    }
}

class Cyclop implements Rase {
    @Override
    public void defineRase() {
        System.out.print("Cyclop");
    }
}
class Dragon implements Rase {
    @Override
    public void defineRase() {
        System.out.print("Dragon");
    }
}

class Hydra implements Rase {
    @Override
    public void defineRase() {
        System.out.print("Hydra");
    }
}

class Knight implements Rase {
    @Override
    public void defineRase() {
        System.out.print("Knight");
    }
}

class Rases implements Rase {
    @Override
    public void defineRase(){
        System.out.print("");
    }
}