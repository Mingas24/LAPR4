package eapli.base.productionordermanagement.domain;

import eapli.base.productionordermanagement.application.IntroduceProductionOrderController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImportProductionOrders {
    private static final String csvSplitBy = ";";
    private static final String ordersSplitBy = ",";
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    private final IntroduceProductionOrderController ipoc = new IntroduceProductionOrderController();

    public boolean loadProductionOrdersFromCSV(List<String> fileLines) {
        for (String line : fileLines.subList(1, fileLines.size())) { //skips header
            String[] prodOrder = line.split(csvSplitBy);
            try {
                List<String> orderList = new ArrayList<>();
                Date emissionDate = dateFormat.parse(prodOrder[1]);
                Date expectedExecutionDate = dateFormat.parse(prodOrder[2]);
                int quantity = Integer.parseInt(prodOrder[4]);
                String[] orders = prodOrder[6].split(ordersSplitBy);
                for (String order : orders) {
                    orderList.add(order.replace("\"", ""));
                }
                ipoc.createProductionOrder(prodOrder[0], emissionDate, expectedExecutionDate, prodOrder[3], quantity, prodOrder[5], orderList);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
