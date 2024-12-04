package main;

import java.util.ArrayList;
import java.util.List;

public class MerchantEncounter implements Event{
    private int gold;
    private ArrayList<Sellable> sellables;

    @Override
    public void resolveEvent() {

    }

    @Override
    public void printMessage() {

    }

    @Override
    public String generate(List<String> strings) {
        return "";
    }
}
