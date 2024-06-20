/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.productionordermanagement.domain.ProductionOrder;
import eapli.base.productionordermanagement.repository.ProductionOrderRepository;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Utilizador
 */
public class JpaProductionOrderRepository extends BasepaRepositoryBase<ProductionOrder, Long, Long> implements ProductionOrderRepository {
    public JpaProductionOrderRepository() {
        super("id");
    }


    @Override
    public Iterable<ProductionOrder> findByState(String state) {
        return match("e.prodOrderState =: state");
    }


    @Override
    public Optional<ProductionOrder> findProductionOrderByProductionOrderId(String productionOrderID) {
        final Map<String, Object> params = new HashMap<>();
        params.put("ProdOrdID", productionOrderID);
        return matchOne("e.productionOrderID.productOrderId=:ProdOrdID", params);
    }

    @Override
    public List<ProductionOrder> findProductionOrderListByOrderId(String orderId) {
        //final Query query = super.entityManager().createNativeQuery("SELECT * FROM PRODUCTIONORDER op INNER JOIN PRODUCTIONORDER_ORDERIDS ope ON ope.PRODUCTIONORDER_ID=op.ID AND ope.ORDERID=:orderId)", ProductionOrder.class);
        //final Query query1 = super.entityManager().createNativeQuery("SELECT * FROM PRODUCTIONORDER PO WHERE PO.ID IN (SELECT POI.PRODUCTIONORDER_ID FROM PRODUCTIONORDER_ORDERIDS poi WHERE poi.ORDERID = :oid)", ProductionOrder.class);
        //query1.setParameter("oid",orderId);
        //return query1.getResultList();
        return null;
    }
}



