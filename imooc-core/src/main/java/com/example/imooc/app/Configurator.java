package com.example.imooc.app;

import java.util.WeakHashMap;

/**
 * @author nizhenyang on 2017/11/23.
 */

public class Configurator {
    private static final WeakHashMap<String, Object> IMOOC_CONFIGS = new WeakHashMap<>();

    public Configurator() {
        IMOOC_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    public WeakHashMap<String, Object> getImoocConfigs() {
        return Configurator.IMOOC_CONFIGS;
    }

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    public final void configure() {
        IMOOC_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    public final Configurator withApiHost(String host) {
        IMOOC_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    private void checkConfiguration() {
        final boolean isReady = (boolean) IMOOC_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready, call configure");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key) {
        checkConfiguration();
        return (T) IMOOC_CONFIGS.get(key.name());
    }
}
