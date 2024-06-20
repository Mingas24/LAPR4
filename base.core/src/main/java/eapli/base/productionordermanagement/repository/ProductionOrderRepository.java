package eapli.base.productionordermanagement.repository;

import eapli.base.productionordermanagement.domain.ProductionOrder;

import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface ProductionOrderRepository extends DomainRepository<Long, ProductionOrder> {

    Optional<ProductionOrder> findProductionOrderByProductionOrderId(String productionOrderID);

    Iterable<ProductionOrder> findProductionOrderListByOrderId(String productionOrderID);

    Iterable<ProductionOrder> findByState(String state);


}
