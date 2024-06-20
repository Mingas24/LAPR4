package eapli.base.machinemanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Model implements ValueObject {

    private final String model;

    protected Model(){this.model="";}

    public Model(String model){
        Preconditions.noneNull(model);
        this.model = model;
    }

    public String model(){return model;}

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model1 = (Model) o;
        return Objects.equals(model, model1.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model);
    }

    @Override
    public String toString() {
        return "Model{" +
                "Model='" + model + '\'' +
                '}';
    }
}
