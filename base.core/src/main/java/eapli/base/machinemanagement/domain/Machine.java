package eapli.base.machinemanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import javax.security.auth.login.Configuration;
import java.io.File;


@Entity
public class Machine implements AggregateRoot<ID> {

    @Id
    private ID id;

    @Column(nullable = false)
    private Brand brand;
    private Model model;
    private Type type;
    private MachineDescription desc;
    private ConfigurationSheet config;
    private String shortDesc;
    private InstallationDate date;
    private ProductionLineID plID;
    @Column(unique = true, nullable = false)
    private SerialNumber num;
    private ProtocolId protocolID;



    public Machine() {
    }

    //Constructor without configuration
    public Machine(ID id, Brand brand, Model model, Type type, MachineDescription desc,
                   InstallationDate date, SerialNumber num, ProductionLineID plID, ProtocolId protocolID) {
        Preconditions.noneNull(id, brand, model, type, desc, date, num, protocolID);
        Preconditions.ensure(protocolID.protocolId()>0 && protocolID.protocolId()<65535);
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.date = date;
        this.desc = desc;
        this.num = num;
        this.plID = plID;
        this.protocolID = protocolID;
    }


    //Constructor with configuration
    public Machine(ID id, Brand brand, Model model, Type type, MachineDescription desc,
                   ConfigurationSheet config, String shortDesc, InstallationDate date, SerialNumber num, ProductionLineID plID, ProtocolId protocolID) {
        Preconditions.noneNull(id, brand, model, type, desc, date, num, protocolID);
        Preconditions.ensure(protocolID.protocolId()>0 && protocolID.protocolId()<65535);
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.desc = desc;
        this.config = config;
        this.shortDesc = shortDesc;
        this.date = date;
        this.num = num;
        this.plID = plID;
        this.protocolID = protocolID;
    }

    public ID machineId() {
        return id;
    }


    public Brand machineBrand() { return brand; }

    public ConfigurationSheet machineConfig() { return config; }

    public InstallationDate machineInstallDate() { return date; }

    public MachineDescription machineDescription() { return desc; }

    public Model machineModel() { return model; }

    public SerialNumber machineSerialNumber() { return num; }

    public ProductionLineID machinePLID() { return plID; }

    public Type machineType() { return type; }

    public ProtocolId protocolId(){return this.protocolID;}

    public void addConfig(ConfigurationSheet config, String shortDesc){
        this.config = config;
        this.shortDesc = shortDesc;
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
        if (!(other instanceof Machine)) {
            return false;
        }
        final Machine that = (Machine) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    @Override
    public ID identity() {
        return id;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "id=" + id +
                ", brand=" + brand +
                ", model=" + model +
                ", type=" + type +
                ", desc=" + desc +
                ", config=" + config +
                ", date=" + date +
                ", num=" + num +
                ", plID=" + plID +
                ", protocolID =" + protocolID +
                '}';
    }
}


