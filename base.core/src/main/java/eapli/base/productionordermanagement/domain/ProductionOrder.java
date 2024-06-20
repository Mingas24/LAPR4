package eapli.base.productionordermanagement.domain;


import eapli.base.floormanagement.domain.Deposit;
import eapli.base.machinemanagement.domain.Machine;
import eapli.base.machinemanagement.domain.MachineExecutionTime;
import eapli.base.machinemanagement.domain.ProductionLine;
import eapli.base.messagemanagement.domain.*;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.UniqueFabricationCode;
import eapli.base.productmanagement.domain.Unity;
import eapli.base.rawmaterial.domain.RawMaterial;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class ProductionOrder implements AggregateRoot<Long> {

    @Id
    @GeneratedValue
    private Long id;
    @Version
    private Long version;

    @Column(unique = true, nullable = false)
    private ProductionOrderId productionOrderID;

    @Temporal(TemporalType.DATE)
    private EmissionDate emissionDate;

    @Temporal(TemporalType.DATE)
    private ExpectedExecutionDate expectedExecutionDate;

    @Column(nullable = false)
    private UniqueFabricationCode prodUniqueFabCode;

    @Column(nullable = false)
    private ProductionOrderQuantity quantity;

    @Enumerated(EnumType.STRING)
    private Unity unity;

    @Column
    @ElementCollection
    private List<OrderId> orderIds;

    @Enumerated(EnumType.STRING)
    private ProductionOrderState state;

    private Date stoppageTime;

    private long stoppageTimeImpact = 0;

    private long stoppageTimeReal = -1;

    private long stoppageTimeGross = -1;

    @ElementCollection
    @OrderColumn
    private List<MachineExecutionTime> executionTimes = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    private ProductionLine productionLine;

    @ElementCollection
    private List<Production> productionList = new ArrayList<>();

    @ElementCollection
    private List<Consumption> consumptionList = new ArrayList<>();

    @ElementCollection
    private List<Reversal> reversalList = new ArrayList<>();

    public ProductionOrder() {

    }

    public ProductionOrder(ProductionOrderId productionOrderID, EmissionDate emissionDate, ExpectedExecutionDate expectedExecutionDate,
                           UniqueFabricationCode prodUniqueFabCode, ProductionOrderQuantity quantity, Unity unity, List<OrderId> orderIds, ProductionOrderState state) {
        this.productionOrderID = productionOrderID;
        this.emissionDate = emissionDate;
        this.expectedExecutionDate = expectedExecutionDate;
        this.prodUniqueFabCode = prodUniqueFabCode;
        this.quantity = quantity;
        this.unity = unity;
        this.orderIds = orderIds;
        this.state = state;
    }

    @Override
    public boolean equals(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(java.lang.Object other) {
        if (!(other instanceof ProductionOrder)) {
            return false;
        }

        final ProductionOrder that = (ProductionOrder) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    @Override
    public Long identity() {
        return id;
    }

    public ProductionOrderId ProductionOrderID() {
        return productionOrderID;
    }

    public EmissionDate EmissionDate() {
        return emissionDate;
    }

    public ExpectedExecutionDate ExpectedExecutionDate() {
        return expectedExecutionDate;
    }

    public UniqueFabricationCode ProdUniqueFabCode() {
        return prodUniqueFabCode;
    }

    public ProductionOrderQuantity Quantity() {
        return quantity;
    }

    public Unity Unity() {
        return unity;
    }

    public List<OrderId> OrderIds() {
        return orderIds;
    }

    public ProductionOrderState unState() {
        return state;
    }

    public void addToProductionList(Production production) {
        this.productionList.add(production);
    }

    public void setProductionLine(ProductionLine productionLine) {
        this.productionLine = productionLine;
    }

    public void setState(ProductionOrderState state) {
        this.state = state;
    }

    public void addToConsumptionList(Consumption consumption) {
        this.consumptionList.add(consumption);
    }

    public void addToReversalList(Reversal reversal) {
        this.reversalList.add(reversal);
    }

    public List<MachineExecutionTime> getExecutionTimes() {
        return executionTimes;
    }

    public void processBegginingMessage(Message message, Machine m) {
        MachineExecutionTime machineExecutionTime = new MachineExecutionTime(m, message.date().getTime());
        this.executionTimes.add(machineExecutionTime);
        this.setState(ProductionOrderState.IN_EXECUTION);
        if (this.state.equals(ProductionOrderState.EXECUTION_TEMPORARILY_STOPPED)) {
            if (message.date().getTime().after(this.stoppageTime)) {
                this.stoppageTimeImpact += message.date().getTime().getTime() - this.stoppageTime.getTime();
            }
        }
    }

    public void processEndMessage(Message message, Machine machine) {
        if (this.productionLine.order().get(this.productionLine.order().size() - 1).equals(machine)) {
            Date endTime = message.date().getTime();
            Date beginTime = this.executionTimes.get(0).begin();
            endExecutionTime(machine, message);
            this.stoppageTimeGross = endTime.getTime() - beginTime.getTime();
            this.stoppageTimeReal = this.stoppageTimeGross - this.stoppageTimeImpact;
            this.state = ProductionOrderState.FINISHED;
        } else {
            int flag = -1;
            endExecutionTime(machine, message);
            for (MachineExecutionTime machineExecutionTime : this.executionTimes) {
                if (machineExecutionTime.end() == null) {
                    flag = 1;
                    break;
                }
            }
            if (flag == -1) {
                this.state = ProductionOrderState.EXECUTION_TEMPORARILY_STOPPED;
                this.stoppageTime = message.date().getTime();
            }
        }
    }

    public void processStopMessage(Message message, Machine machine) {
        int flag = -1;
        endExecutionTime(machine, message);
        for (MachineExecutionTime machineExecutionTime : this.executionTimes) {
            if (machineExecutionTime.end() == null) {
                flag = 1;
                break;
            }
        }
        if (flag == -1) {
            this.state = ProductionOrderState.EXECUTION_TEMPORARILY_STOPPED;
            this.stoppageTime = message.date().getTime();
        }
    }

    public void endExecutionTime(Machine machine, Message message) {
        for (MachineExecutionTime machineExecutionTime : this.executionTimes) {
            if (machine.equals(machineExecutionTime.machine())) {
                if (machineExecutionTime.end() == null) {
                    machineExecutionTime.changeEnd(message.date().getTime());
                    break;
                }
            }
        }
    }

    public void processConsumeMessageRaw(MessageConsume message, RawMaterial rawMaterial){
        consumptionList.add(new Consumption(rawMaterial, message.getQuantity()));
    }

    public void processConsumeMessageProd(MessageConsume message, Product product){
        consumptionList.add(new Consumption(product, message.getQuantity()));
    }

    public void processDeliveryMessage(MessageDelivery message, Deposit deposit){
        for(Production production: productionList){
            if(production.getDeposit() == null){
                if(message.getQuantity() == production.quantity()){
                    production.setDeposit(deposit);
                    break;
                }
            }
        }
    }

    public void processProductionMessage(MessageProduction message, Product product){
        productionList.add(new Production(product, message.getQuantity()));
    }

    public void processReversalMessage(MessageReversal message, RawMaterial rawMaterial){
        reversalList.add(new Reversal(rawMaterial, message.getQuantity()));
    }

    @Override
    public String toString() {
        return "ProductionOrder: Production Order ID:" + productionOrderID +
                ", Order ID's=" + orderIds +
                ", State=" + state;
    }
}
