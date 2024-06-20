package eapli.base.app.backoffice.console.presentation.MachineConfigurationFile;

import eapli.base.app.backoffice.console.presentation.Product.ProductPrinter;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.machinemanagement.DTO.MachineDTO;
import eapli.base.machinemanagement.application.SpecifyConfigurationFileController;
import eapli.base.machinemanagement.domain.Machine;
import eapli.base.machinemanagement.repositories.MachineRepository;
import eapli.base.productmanagement.dto.ProductDTO;
import eapli.framework.actions.Action;
import eapli.framework.presentation.console.SelectWidget;
import org.springframework.expression.spel.ast.BooleanLiteral;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationFileAction implements Action {

    @Override
    public boolean execute() {
        return new ConfigurationFileUI().show();
    }
}
