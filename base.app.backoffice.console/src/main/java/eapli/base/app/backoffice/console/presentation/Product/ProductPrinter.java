package eapli.base.app.backoffice.console.presentation.Product;

import eapli.base.productmanagement.dto.ProductDTO;
import eapli.framework.visitor.Visitor;

@SuppressWarnings("squid:S106")
public class ProductPrinter implements Visitor<ProductDTO> {


    @Override
    public void visit(ProductDTO visitee) {
        System.out.printf("Product{" +
                "unFabCode='" + visitee.unFabCode + '\'' +
                ", comCode='" + visitee.comCode + '\'' +
                ", category='" + visitee.category + '\'' +
                ", shortDesc='" + visitee.shortDesc + '\'' +
                '}');
    }
}
