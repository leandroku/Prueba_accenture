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
    public Producto createProducto(@RequestBody Map<String, String> params) {
        return productoService.crearProducto(params);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProducto(@PathVariable Long id) {
        return productoService.eliminarProducto(id);
    }

    @PatchMapping("/updateStockProducto")
    @ResponseBody
    public String updateStockProducto(@RequestBody Map<String, String> params) {
        return productoService.actualizarStockProducto(params);
    }

    @GetMapping("/MaxStockProductoSucursal/{id}")
    public List<Map<String, String>> getMaxStockProductoSucursal(@PathVariable Long id) {
        return productoService.getMaxStockProductoSucursal(id);
    }
    
    @PatchMapping("/updateNombreProducto")
    @ResponseBody
    public String updateNombreProducto(@RequestBody Map<String, String> params) {
        return productoService.actualizarNombreProducto(params);
    }


}
