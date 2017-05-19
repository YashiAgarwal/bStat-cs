package bStat.CS.com.common.utils;

import com.google.inject.Injector;

/**
 * Created with IntelliJ IDEA.
 * User: akash.jain
 * Date: 20/02/15
 * Time: 6:00 PM
 * To change this template use File | Settings | File Templates.
 */


public class GuiceInjector {
    private static Injector injector = null;

    public static void assignInjector(Injector givenInjector) {
        if (injector == null)
            synchronized (GuiceInjector.class) {
                if (injector == null) {
                    injector = givenInjector;
                }
            }
        else
            throw new IllegalStateException("Injector instance was already assigned.");
    }

    public static Injector getInjector() {
        if (injector == null) {
            synchronized (GuiceInjector.class) {
                if (injector == null)
                    throw new IllegalStateException("Injector instance is not assigned. Please assign first");

            }
        }
        return injector;
    }
}
