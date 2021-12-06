package com.example.demo.controller;

import com.example.demo.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class UIController {

  private SearchService searchService;

  @Autowired
  public UIController(SearchService searchService) {
    this.searchService = searchService;
  }

  @GetMapping("/")
  public String home(Model model) {

//    List<Product> products = searchService.fetchProductNamesContaining("Hornby");
//
//    List<String> names = products.stream().flatMap(prod->{
//      return Stream.of(prod.getName());
//    }).collect(Collectors.toList());
//    log.info("product names {}", names);
//
    List<String> names = new ArrayList<>();
    names.add("Abc");
    names.add("def");
    names.add("ijk");
    names.add("xyz");
    model.addAttribute("names", names);
    return "search";
  }

}
