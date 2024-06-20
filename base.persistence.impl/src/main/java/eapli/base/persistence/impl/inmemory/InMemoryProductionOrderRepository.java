/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.inmemory;

import eapli.base.productionordermanagement.domain.ProductionOrder;
import eapli.base.productionordermanagement.domain.ProductionOrderState;
import eapli.base.productionordermanagement.repository.ProductionOrderRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainAutoNumberRepository;

import java.util.Optional;

/**
 *
 * @author Utilizador
 */
public class InMemoryProductionOrderRepository extends InMemoryDomainAutoNumberRepository<ProductionOrder> implements ProductionOrderRepository {
    
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<ProductionOrder> findByState(String state) {
        return match(e -> e.unState().equals(state));
    }

    @Override
    public Optional<ProductionOrder> findProductionOrderByProductionOrderId(String productionOrderID) {
        return matchOne(e -> e.ProductionOrderID().productOrderId().equals(productionOrderID));
    }

    @Override
    public Iterable<ProductionOrder> findProductionOrderListByOrderId(String productionOrderID) {
        return match(e -> e.ProductionOrderID().productOrderId().equals(productionOrderID));
    }
}
