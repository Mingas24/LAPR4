package eapli.base.productmanagement.dto;

import eapli.framework.representations.dto.DTO;


@DTO
public class ProductDTO {
    public String unFabCode;
    public String comCode;
    public String category;
    public String shortDesc;


    public ProductDTO(String unFabCode, String comCode, String shortDesc, String category) {
        this.unFabCode = unFabCode;
        this.comCode = comCode;
        this.category = category;
        this.shortDesc=shortDesc;
    }

    public String UnFabCode() {
        return unFabCode;
    }

    @Override
    public String toString() {
        return "Product{" +
                "unFabCode='" + unFabCode + '\'' +
                ", comCode='" + comCode + '\'' +
                ", category='" + category + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                '}';
    }
}
