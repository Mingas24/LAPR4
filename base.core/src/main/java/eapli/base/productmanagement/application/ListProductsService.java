package eapli.base.productmanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.domain.*;
import eapli.base.productmanagement.dto.ProductDTO;
import eapli.base.productmanagement.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListProductsService {

    private final ProductRepository repo = PersistenceContext.repositories().product();

    public List<ProductDTO> findProductsWithoutProductionSheet() {
        List<ProductDTO> productsDTO = new ArrayList<>();
        Iterable<Product> products = repo.findWithoutProductionSheet();
        for(Product product : products){
            ProductDTO dto = new ProductDTO(product.unFabCode().unFabCode(),
                    product.comCode().comCode(), product.shortDesc().shortDesc(),
                    product.category().category());
            productsDTO.add(dto);
        }
        return productsDTO;
    }
    public List<ProductDTO> findAllProducts(){
        List<ProductDTO> productsDTOList = new ArrayList<>();
        Iterable<Product> products = repo.findAll();
        for(Product p : products){
            ProductDTO pDTO = new ProductDTO(p.unFabCode().unFabCode(),
                    p.comCode().comCode(), p.shortDesc().shortDesc()
                    ,p.category().category());;
            productsDTOList.add(pDTO);
        }

        return productsDTOList;
    }

    public Product convertDTOtoProduct(ProductDTO prodDTO){
        Optional<Product> pAux = repo.findProductByUFP(prodDTO.UnFabCode());
        Product p =pAux.get();
      return p;
    }

    public boolean specifyProdutionSheet(ProductDTO pDTO, List<ProductionSheet>psl){
        Product p =convertDTOtoProduct(pDTO);
        p.changeProdSheet(psl);
        repo.save(p);
        return true;
    }
}
