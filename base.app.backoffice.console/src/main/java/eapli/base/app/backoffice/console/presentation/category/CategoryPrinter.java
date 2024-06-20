package eapli.base.app.backoffice.console.presentation.category;

import eapli.base.categorymanagement.dto.CategoryDTO;
import eapli.framework.visitor.Visitor;


@SuppressWarnings("squid:S106")
public class CategoryPrinter implements Visitor<CategoryDTO> {


    @Override
    public void visit(CategoryDTO visitee) {
        System.out.println("Category{" +
                "description='" + visitee.descriptionCategory + '\'' +
                ", ID='" + visitee.idCategory + '\'' +
                '}');

    }
}
