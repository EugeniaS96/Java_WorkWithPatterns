package org.example;

public class ConfigurationProxy {
    private Configuration configuration;
    private boolean isAdmin;

    public ConfigurationProxy(boolean isAdmin) {
        this.configuration = Configuration.getInstance();
        this.isAdmin = isAdmin;
    }

    public String getConfig() {
        if (checkAccess()) {
            return configuration.getConfig();
        } else {
            throw new SecurityException("Access denied. You don`t have rights for changing configuration.");
        }
    }

    public void setConfig(String config) {
        if (checkAccess() && isAdmin) {
            configuration.setConfig(config);
        } else {
            throw new SecurityException("Access denied. You don`t have rights for changing configuration.");
        }
    }
    private boolean checkAccess() {
        return true;
    }
}