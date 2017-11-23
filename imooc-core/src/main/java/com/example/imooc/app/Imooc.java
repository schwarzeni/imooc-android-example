package com.example.imooc.app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * @author nizhenyang
 */
public final class Imooc {
    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static WeakHashMap<String, Object> getConfigurations() {
        return Configurator.getInstance().getImoocConfigs();
    }
}
