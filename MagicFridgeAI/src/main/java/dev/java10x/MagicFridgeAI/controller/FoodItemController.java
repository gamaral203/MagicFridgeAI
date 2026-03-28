package dev.java10x.MagicFridgeAI.controller;

import dev.java10x.MagicFridgeAI.dto.FoodItemDTO;
import dev.java10x.MagicFridgeAI.service.FoodItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/food")
public class FoodItemController {

    private FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    public ResponseEntity<FoodItemDTO> criar(@RequestBody FoodItemDTO foodItem) {
      FoodItemDTO foodItemDTO = foodItemService.salvar(foodItem);
      return ResponseEntity.status(HttpStatus.CREATED).body(foodItemDTO);
    }
}
