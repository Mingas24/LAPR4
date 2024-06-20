package eapli.base.productionordermanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.productionordermanagement.domain.*;
import eapli.base.productionordermanagement.repository.ProductionOrderRepository;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.UniqueFabricationCode;
import eapli.base.productmanagement.domain.Unity;
import eapli.base.productmanagement.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ProductionOrderService {

    private final RepositoryFactory repos = PersistenceContext.repositories();

    public Product checkProduct(String unFabCode) {
        ProductRepository productRepository = repos.product();
        if (productRepository.findProductByUFP(unFabCode).isPresent()) {
            return productRepository.findProductByUFP(unFabCode).get();
        } else return null;
    }


    public boolean createProductionOrder (String productionOrderID, Date emissionDate, Date expectedExecutionDate,
                                          String prodUniqueFabCode, int quantity, String unity, List<String> orderIds){
        ProductionOrderRepository productionOrderRepository = repos.productionOrder();
        ProductionOrder p = createNewProductionOrder(productionOrderID, emissionDate, expectedExecutionDate, prodUniqueFabCode, quantity, unity, orderIds);
        ProductionOrder productionOrder = productionOrderRepository.save(p);
        if (productionOrder != null) {
            return true;
        }
        return false;
    }

    public ProductionOrder createNewProductionOrder(String productionOrderID, Date emissionDate, Date expectedExecutionDate,
                                                    String prodUniqueFabCode, int quantity, String unity, List<String> orderIds) {

        ProductionOrderId id = new ProductionOrderId(productionOrderID);
        EmissionDate emissDate = new EmissionDate(emissionDate);
        ExpectedExecutionDate expectDate = new ExpectedExecutionDate(expectedExecutionDate);
        UniqueFabricationCode prodUnFabCode = new UniqueFabricationCode(prodUniqueFabCode);
        ProductionOrderQuantity orderQuantity = new ProductionOrderQuantity(quantity);
        List<OrderId> orderIdList = new ArrayList<>();
        for (String idOr : orderIds) {
            orderIdList.add(new OrderId(idOr));
        }
        if (unity.trim().equalsIgnoreCase("KG")) {
            return new ProductionOrder(id, emissDate, expectDate, prodUnFabCode,
                    orderQuantity, Unity.KG, orderIdList, ProductionOrderState.PENDING);
        } else if (unity.trim().equalsIgnoreCase("UN")) {
            return new ProductionOrder(id, emissDate, expectDate, prodUnFabCode,
                    orderQuantity, Unity.UN, orderIdList, ProductionOrderState.PENDING);
        } else if (unity.trim().equalsIgnoreCase("L")) {
            return new ProductionOrder(id, emissDate, expectDate, prodUnFabCode,
                    orderQuantity, Unity.L, orderIdList, ProductionOrderState.PENDING);
        }else if (unity.trim().equalsIgnoreCase("METERS")) {
            return new ProductionOrder(id, emissDate, expectDate, prodUnFabCode,
                    orderQuantity, Unity.METERS, orderIdList, ProductionOrderState.PENDING);
        }
        return null;
    }
}
