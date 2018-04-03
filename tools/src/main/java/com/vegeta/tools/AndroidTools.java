package com.vegeta.tools;

import android.content.Context;
import android.content.pm.ApplicationInfo;

import com.vegeta.tools.categories.IntentLogger;
import com.vegeta.tools.categories.logger.LogLevel;
import com.vegeta.tools.categories.logger.Settings;
/**
 * Created by Anderson on 2016/6/27.
 */
public class AndroidTools {

    private static getContextListener contextListener;

    public static String TAG = "REPLACE_WITH_DESIRED_TAG";

    /**
     * Developer mode for Debugging purposes
     */
    private static Boolean isDebug = null;


    private AndroidTools() {

    }

    public static Context getContext() {
        return contextListener.getContext();
    }


    public interface getContextListener {
        Context getContext();
    }

    public static synchronized void init(getContextListener listener) {
        contextListener = listener;

        // Set the appropriate log TAG
        setTAG(system.getApplicationNameByContext());

        // resets all timestamps
        timer.resetAllTimestamps();
    }

    /**
     * Set the log TAG for debug purposes
     *
     * @param tag Desired tag (e.g.: Aplication_X)
     */
    public static void setTAG(String tag) {
        TAG = tag;
        Settings settings = log.init(tag);
        if (isInDebug()) {
            settings.setLogLevel(LogLevel.FULL);
        } else {
            settings.setLogLevel(LogLevel.NONE);
        }
        settings.hideThreadInfo().setMethodCount(1);
    }

    /**
     * Should I show logs?
     *
     * @return true if you should
     */
    public static Boolean isInDebug() {

        if (isDebug == null) {
            isDebug = isApkDebugable(getContext());
        }
        return isDebug;
    }


    public static boolean isApkDebugable(Context context) {
        try {
            ApplicationInfo info = context.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {

        }
        return false;
    }

    public static class log extends com.vegeta.tools.categories.log {
    }

    public static class date extends com.vegeta.tools.categories.date {
    }

    public static class prefs extends com.vegeta.tools.categories.prefs {
    }

    public static class system extends com.vegeta.tools.categories.system {
    }

    public static class math extends com.vegeta.tools.categories.math {
    }

    public static class web extends com.vegeta.tools.categories.web {
    }


    public static class sdcard extends com.vegeta.tools.categories.sdcard {
    }

    public static class security extends com.vegeta.tools.categories.security {
    }


    public static class image extends com.vegeta.tools.categories.image {
    }

    public static class timer extends com.vegeta.tools.categories.timer {
    }

    public static class string extends com.vegeta.tools.categories.string {
    }

    public static class validation extends com.vegeta.tools.categories.validation {
    }

    public static class screen extends com.vegeta.tools.categories.screen {
    }


    public static class intentLogger extends IntentLogger {
        private intentLogger() {
        }
    }
}
