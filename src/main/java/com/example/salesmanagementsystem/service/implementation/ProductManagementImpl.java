package com.example.salesmanagementsystem.service.implementation;

import com.example.salesmanagementsystem.dto.request.ProductManagementCreationRequest;
import com.example.salesmanagementsystem.dto.request.ProductManagementUpdateRequest;
import com.example.salesmanagementsystem.dto.response.ProductManagementCreationResponse;
import com.example.salesmanagementsystem.dto.response.ProductManagementUpdateResponse;
import com.example.salesmanagementsystem.dto.response.ProductResponse;
import com.example.salesmanagementsystem.enums.ProductCategory;
import com.example.salesmanagementsystem.model.ProductManagement;
import com.example.salesmanagementsystem.repository.ProductManagementRepository;
import com.example.salesmanagementsystem.service.ProductManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductManagementImpl implements ProductManagementService {

    private final ProductManagementRepository productManagementRepository;

    @Override
    public ResponseEntity<ProductManagementCreationResponse> createProduct(ProductManagementCreationRequest productManagementCreationRequest){
        ProductManagement newProduct = ProductManagement.builder().build();
        newProduct.setName(productManagementCreationRequest.getName());
        newProduct.setDescription(productManagementCreationRequest.getDescription());
        newProduct.setPrice(productManagementCreationRequest.getPrice());
        newProduct.setProductCategory(ProductCategory.valueOf(productManagementCreationRequest.getProductCategory().toUpperCase()));
        newProduct.setAvailableQuantity(productManagementCreationRequest.getAvailableQuantity());
        newProduct.setInitialQuantity(productManagementCreationRequest.getInitialQuantity());

        ProductManagement savedProduct = productManagementRepository.save(newProduct);

        ProductManagementCreationResponse response = new ProductManagementCreationResponse(savedProduct.getId(), "Product created successfully");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
    @Override
    public ResponseEntity<ProductManagementUpdateResponse> updateProduct(ProductManagementUpdateRequest productManagementUpdateRequest){
        ProductManagement updateProduct = productManagementRepository.findProductManagementById(productManagementUpdateRequest.getId());

        if (updateProduct == null) {
            return ResponseEntity.notFound().build();
        }
        updateProduct.setName(productManagementUpdateRequest.getName());
        updateProduct.setPrice(productManagementUpdateRequest.getPrice());
        updateProduct.setDescription(productManagementUpdateRequest.getDescription());
        updateProduct.setProductCategory(ProductCategory.valueOf(productManagementUpdateRequest.getProductCategory().toUpperCase()));
        updateProduct.setInitialQuantity(productManagementUpdateRequest.getInitialQuantity());
        updateProduct.setAvailableQuantity(productManagementUpdateRequest.getAvailableQuantity());

        ProductManagement updatedProduct = productManagementRepository.save(updateProduct);

        ProductManagementUpdateResponse response = new ProductManagementUpdateResponse(updatedProduct.getId(), "Product Updated Successfully");
        return ResponseEntity.ok().body(response);
    }

    @Override
    public Page<ProductResponse> getProduct(Long productId, int page, int size) {
        Optional<ProductManagement> productOptional = productManagementRepository.findById(productId);
        if (productOptional.isPresent()) {
            ProductManagement product = productOptional.get();
            ProductResponse productResponse = new ProductResponse(
                    product.getId(),
                    product.getName(),
                    product.getDescription(),
                    product.getProductCategory(),
                    product.getInitialQuantity(),
                    product.getAvailableQuantity(),
                    product.getPrice()
            );
            return new PageImpl<>(Collections.singletonList(productResponse));
        } else {
            return Page.empty();
        }
}
    @Override
    public ResponseEntity<String> deleteProduct(Long id) {
        Optional<ProductManagement> productOptional = productManagementRepository.findById(id);
        if (productOptional.isPresent()) {
            productManagementRepository.deleteById(id);
            return ResponseEntity.ok("Deleted ID: " + id + " Successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
