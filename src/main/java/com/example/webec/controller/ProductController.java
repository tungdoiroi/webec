package com.example.webec.controller;

import com.example.webec.dto.ProductResponsive;
import com.example.webec.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductResponsive productRepo;
    @GetMapping("/listProduct")
    public String showExample(Model model) {
        List<Product> products = productRepo.findAll();
        model.addAttribute("products", products);
        return "/listProduct";
    }
//    @GetMapping("/products")
//    public String show() {
//        return "/listProduct";
//    }
    @GetMapping("/addProduct")
    public String showAddProduct(){
        return "/addProduct.html";
    }

    @PostMapping("/addProduct")
    public String saveProduct(@RequestParam("name") String name,
                              @RequestParam("description") String description,
                              @RequestParam("price") int price){
        Product p = new Product();
//        p.setId((long) 4);
        p.setName(name);
        p.setDescription(description);
        p.setPrice(price);
        productRepo.save(p);
        return "redirect:/listProduct";
    }
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productRepo.deleteById(id);
        return "redirect:/listProduct";
    }
    @PostMapping("/changeName")
    public String changeName(@RequestParam("id") Long id,
                             @RequestParam("newName") String name)
    {
        Product p = new Product();
        p = productRepo.findById(id).get();
        p.setName(name);
        productRepo.save(p);
        return "redirect:/listProduct";
    }
    @PostMapping("/changeDecription")
    public String changeDecription(@RequestParam("id") Long id,
                             @RequestParam("newDescription") String decription)
    {
        Product p = new Product();
        p = productRepo.findById(id).get();
        p.setDescription(decription);
        productRepo.save(p);
        return "redirect:/listProduct";


    }
    @PostMapping("/changePrice")
    public String changePrice(@RequestParam("id") Long id,
                                   @RequestParam("newPrice") int price)
    {
        Product p = new Product();
        p = productRepo.findById(id).get();
        p.setPrice(price);
        productRepo.save(p);
        return "redirect:/listProduct";


    }
}
