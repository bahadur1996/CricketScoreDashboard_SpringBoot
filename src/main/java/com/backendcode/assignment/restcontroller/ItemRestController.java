package com.backendcode.assignment.restcontroller;

import com.backendcode.assignment.model.Item;
import com.backendcode.assignment.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("rest/v1/item")
public class ItemRestController {
    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> getItems(@RequestParam(value = "search", required = false) String queryParam,
                                               @RequestParam(value = "limit", required = false) Integer noOfItems){
        List<Item> items = itemService.getItems(noOfItems,queryParam);
        return ResponseEntity.ok(items);
    }
}
