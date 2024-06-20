package eapli.base.machinemanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.File;
import java.util.Objects;

@Embeddable
public class ConfigurationSheet implements ValueObject {

    private String config;


    protected ConfigurationSheet() {
        this.config = "";
    }

    public ConfigurationSheet(String config) {
        Preconditions.noneNull(config);
        this.config = config;
    }

    public String config() {
        return config;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfigurationSheet that = (ConfigurationSheet) o;
        return Objects.equals(config, that.config);
    }

    @Override
    public int hashCode() {
        return Objects.hash(config);
    }

    @Override
    public String toString() {
        return "Configuration Sheet{" +
                "Configuration Sheet='" + config + '\'' +
                '}';
    }
}
