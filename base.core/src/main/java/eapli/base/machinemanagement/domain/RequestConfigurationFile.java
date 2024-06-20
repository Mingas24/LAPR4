package eapli.base.machinemanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RequestConfigurationFile implements AggregateRoot<ProtocolId> {

    @Id
    private ProtocolId protocolId;

    private ConfigurationSheet sheet;

    public RequestConfigurationFile(){
    }

    public RequestConfigurationFile(ProtocolId protocolId, ConfigurationSheet sheet) {
        this.protocolId = protocolId;
        this.sheet = sheet;
    }

    public ConfigurationSheet sheet() {
        return this.sheet;
    }

    @Override
    public boolean equals(Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof RequestConfigurationFile)) {
            return false;
        }
        final RequestConfigurationFile that = (RequestConfigurationFile) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }


    @Override
    public ProtocolId identity() {
        return this.protocolId;
    }
}
