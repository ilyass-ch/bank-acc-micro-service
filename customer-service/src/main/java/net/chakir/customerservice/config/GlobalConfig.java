package net.chakir.customerservice.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@ConfigurationProperties(prefix = "global.params")
//@RefreshScope
public class GlobalConfig {
    private int p1;
    private int p2;

    public GlobalConfig() {
    }
    public GlobalConfig(int p1, int p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public int getP1() {
        return p1;
    }

    public void setP1(int p1) {
        this.p1 = p1;
    }

    public int getP2() {
        return p2;
    }

    public void setP2(int p2) {
        this.p2 = p2;
    }
}
