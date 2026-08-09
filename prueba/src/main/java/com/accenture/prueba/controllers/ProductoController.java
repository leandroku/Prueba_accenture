package com.accenture.prueba.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.prueba.DTO.ProductoDTO;
import com.accenture.prueba.models.Producto;
import com.accenture.prueba.services.Itf.ProductoService;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;



@RestController
@RequestMapping("/producto")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping()
    public Flux<ProductoDTO> getAllProductos() {
        return productoService.getAllProductos();
    }

    @RequestMapping(value = "/createProducto", method = RequestMethod.POST)
    @ResponseBody
    public Producto createProducto(@RequestBody ProductoDTO productoDTO) {
        return productoService.crearProducto(productoDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public boolean deleteProducto(@PathVariable Long id) {
        return productoService.eliminarProducto(id);
    }

    @PatchMapping("/{id}/stock")
    @ResponseBody
    public String updateStockProducto(@PathVariable Long id,@RequestBody int nuevoStock) {
        return productoService.actualizarStockProducto(id, nuevoStock);
    }

    @GetMapping("/MaxStockProductoSucursal/{id}")
    public List<Map<String, String>> getMaxStockProductoSucursal(@PathVariable Long id) {
        return productoService.getMaxStockProductoSucursal(id);
    }
    
    @PatchMapping("/{id}/nombre")
    @ResponseBody
    public String updateNombreProducto(@PathVariable Long id, @RequestBody String nuevoNombre) {
        return productoService.actualizarNombreProducto(id, nuevoNombre);
    }


}
