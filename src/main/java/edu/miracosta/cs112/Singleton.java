package edu.miracosta.cs112;

import edu.miracosta.cs112.models.DietTracker;

public class Singleton {

    private static Singleton INSTANCE;

    private Singleton() {
        //nothing, just making sure no one can build my singleton class
    }

    public static Singleton getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }


    //SINGLETON DATA

    //EXAMPLE: private static DietTracker myDietTracker = new DietTracker();

    //GETTERS AND SETTERS

    //EXAMPLE:
//    public DietTracker getMyDietTracker() {
//        return myDietTracker;
//    }
}
