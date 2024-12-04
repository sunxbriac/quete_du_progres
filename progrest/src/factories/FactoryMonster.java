package factories;

import main.Monster;
import utils.Reader;

public class FactoryMonster {
    public Monster generateMonster(){
        return new Monster(Reader.getStringMonsterName(), Reader.getStringLocation());
    }
}
