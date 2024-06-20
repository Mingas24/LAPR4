package eapli.base.categorymanagement.dto;

import eapli.base.categorymanagement.domain.CategoryDescription;
import eapli.base.categorymanagement.domain.CategoryID;
import eapli.framework.representations.dto.DTO;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;

@DTO
public class CategoryDTO {


    public String idCategory;


    public String descriptionCategory;


    public CategoryDTO( String idCategory, String descriptionCategory) {

        Preconditions.noneNull(descriptionCategory,idCategory);
        this.descriptionCategory = descriptionCategory;
        this.idCategory = idCategory;
    }

    public String idCategory() {
        return idCategory;
    }

    public String descriptionCategory() {
        return descriptionCategory;
    }
}
