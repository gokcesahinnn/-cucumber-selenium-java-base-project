package config;

public class BaseConfig {

    public static BaseConfig getInstance() {
        return new BaseConfig();
    }

    String browser = System.getenv("BROWSER");
    String env = System.getenv("ENV");
    String headless = System.getenv("HEADLESS");

    String locale = System.getenv("LOCALE");

    public String getBrowser() {
        return (browser != null) ? browser : "chrome";
    }

    public String getUrl() {
        env = (env != null) ? env : "test";
        String url = null;
        switch (env) {
            case "test" -> url = "https://automationexercise.com/";
            case "prod" -> url = "https://www.google.com/";
        }
        return url;
    }

    public Boolean getHeadless() {
        return (headless != null) ? Boolean.parseBoolean(headless) : false;
    }

    public String getLocale() {
        return (locale != null) ? locale : "tr";
    }
}