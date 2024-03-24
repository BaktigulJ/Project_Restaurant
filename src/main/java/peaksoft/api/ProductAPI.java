/*
package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.AddColourRequest;
import peaksoft.dto.request.ProductRequest;
import peaksoft.dto.responce.PaginationResponse;
import peaksoft.dto.responce.ProductInnerPageResponse;
import peaksoft.dto.responce.ProductResponse;
import peaksoft.dto.responce.SimpleResponse;
import peaksoft.enums.Category;
import peaksoft.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductAPI {

    private final ProductService productService;

    @Secured({"ADMIN, CLIENT"})
    @GetMapping
    private List<ProductResponse> findAll() {
        return productService.findAll();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/{loginId}")
    public SimpleResponse save(@PathVariable Long loginId,
                               @RequestParam Category category,
                               @RequestBody ProductRequest productRequest) {
        return productService.save(loginId, category, productRequest);
    }

    @Secured({"ADMIN"})
    @PostMapping("/{loginID}/{productID}")
    public SimpleResponse addColours(@RequestBody AddColourRequest addColourRequest,
                                     @PathVariable Long loginID,
                                     @PathVariable Long productID) {
        return productService.addColour(loginID, productID, addColourRequest);
    }

    @PutMapping("/{loginID}/{productID}")
    public SimpleResponse addOrRemoveFavorite(@PathVariable Long loginID,
                                              @PathVariable Long productID) {
        return productService.addOrRemoveFav(loginID, productID);
    }

    @GetMapping("/favorite/{loginID}")
    public List<ProductResponse> findFav(@PathVariable Long loginID) {
        return productService.findAllFavProducts(loginID);
    }

    @GetMapping("/{productID}")
    public ProductInnerPageResponse findById(@PathVariable Long productID) {
        return productService.findById(productID);
    }

    @GetMapping("/pagination")
    public PaginationResponse findAllProducts(@RequestParam(defaultValue = "1") int page,
                                              @RequestParam(defaultValue = "3") int size){
        return productService.findAllProducts(page, size);
    }

}
*/
