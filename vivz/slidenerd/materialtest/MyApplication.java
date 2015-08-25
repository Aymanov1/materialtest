package materialtest.vivz.slidenerd.materialtest;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import materialtest.vivz.slidenerd.database.DBMovies;

/**
 * Created by Windows on 30-01-2015.
 */
public class MyApplication extends Application {


    public static final String API_KEY_ROTTEN_TOMATOES = "54wzfswsa4qmjg8hjwa64d4c";
    private static MyApplication sInstance;

    private static DBMovies mDatabase;

    private int cardiacPulse;
    private int respiration;
    private int vomit;
    private int diacons;
    private boolean back_ache;
    private boolean head_ache;

    public boolean getBack_ache() {
        return back_ache;
    }

    public boolean getHead_ache() {
        return head_ache;
    }

    public boolean getChest_ache() {
        return chest_ache;
    }

    public void setChest_ache(boolean chest_ache) {

        this.chest_ache = chest_ache;
    }

    public void setHead_ache(boolean head_ache) {
        this.head_ache = head_ache;
    }

    public void setBack_ache(boolean back_ache) {
        this.back_ache = back_ache;
    }

    private boolean chest_ache;
    private int dizyyness;
    private int isonomia;
    private int tired, Temperature;

    public void setCardiacPulse(int cardiacPulse) {
        this.cardiacPulse = cardiacPulse;
    }

    public void setRespiration(int respiration) {
        this.respiration = respiration;
    }

    public void setVomit(int vomit) {
        this.vomit = vomit;
    }

    public void setTemperature(int Temperature) {
        this.Temperature = Temperature;
    }


    public void setDiacons(int diacons) {
        this.diacons = diacons;
    }

    public void setDizyyness(int dizyyness) {
        this.dizyyness = dizyyness;
    }

    public void setIsonomia(int isonomia) {
        this.isonomia = isonomia;
    }

    public void setTired(int tired) {
        this.tired = tired;
    }

    public int getCardiacPulse() {


        return cardiacPulse;
    }

    public int getTemperature() {

        return Temperature;
    }


    public int getRespiration() {
        return respiration;
    }

    public int getVomit() {
        return vomit;
    }

    public int getDiacons() {
        return diacons;
    }

    public int getDizyyness() {
        return dizyyness;
    }

    public int getIsonomia() {
        return isonomia;
    }

    public int getTired() { return tired;   }

    public static MyApplication getInstance() {
        return sInstance;
    }

    public static Context getAppContext() {
        return sInstance.getApplicationContext();
    }

    public synchronized static DBMovies getWritableDatabase() {
        if (mDatabase == null) {
            mDatabase = new DBMovies(getAppContext());
        }
        return mDatabase;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        mDatabase = new DBMovies(this);
    }

    public static void saveToPreferences(Context context, String preferenceName, String preferenceValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(preferenceName, preferenceValue);
        editor.apply();
    }

    public static void saveToPreferences(Context context, String preferenceName, boolean preferenceValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(preferenceName, preferenceValue);
        editor.apply();
    }

    public static String readFromPreferences(Context context, String preferenceName, String defaultValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        return sharedPreferences.getString(preferenceName, defaultValue);
    }

    public static boolean readFromPreferences(Context context, String preferenceName, boolean defaultValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        return sharedPreferences.getBoolean(preferenceName, defaultValue);
    }
}
