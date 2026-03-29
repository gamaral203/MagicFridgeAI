package dev.java10x.MagicFridgeAI.controller;

import dev.java10x.MagicFridgeAI.dto.FoodItemDTO;
import dev.java10x.MagicFridgeAI.service.FoodItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodItemController {

    private FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    @PostMapping("/criar")
    public ResponseEntity<FoodItemDTO> criar(@RequestBody FoodItemDTO foodItem) {
        FoodItemDTO foodItemDTO = foodItemService.criar(foodItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(foodItemDTO);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<FoodItemDTO>> listar() {
        List<FoodItemDTO> foodItemDTO = foodItemService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(foodItemDTO);
    }

    @GetMapping("/listarPorId/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        FoodItemDTO foodItemDTO = foodItemService.listarPorId(id);

        if (foodItemDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(foodItemDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Igrediente não encontrado");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        if (foodItemService.listarPorId(id) != null) {
            foodItemService.deletarItem(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Item com o id " + id + " deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("nenhum igrediente encontrado");
        }
    }

}
