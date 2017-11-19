package fr.android.draymond;

import timber.log.Timber;

/**
 * Created by damien on 19/11/2017.
 */

public class Logger {

    public Logger() {
        Timber.plant(new Timber.DebugTree());
    }

    public void info(String msg, Object... objects){
        Timber.i(msg, objects);
    }

    public void error(String msg, Object... objects) {
        Timber.e(msg, objects);
    }

    public void error(Throwable t) {
        Timber.e(t);
    }
}
