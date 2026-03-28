package dev.java10x.MagicFridgeAI.service;

import dev.java10x.MagicFridgeAI.dto.FoodItemDTO;
import dev.java10x.MagicFridgeAI.mapper.FoodItemMapper;
import dev.java10x.MagicFridgeAI.model.FoodItemModel;
import dev.java10x.MagicFridgeAI.repository.FoodItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class FoodItemService {

    private FoodItemRepository foodItemRepository;
    private FoodItemMapper foodItemMapper;

    public FoodItemService(FoodItemRepository foodItemRepository, FoodItemMapper foodItemMapper) {
        this.foodItemRepository = foodItemRepository;
        this.foodItemMapper = foodItemMapper;
    }

    public FoodItemDTO criar(@RequestBody FoodItemDTO foodItemDTO) {
        FoodItemModel foodItemModel = foodItemMapper.map(foodItemDTO);
        foodItemModel = foodItemRepository.save(foodItemModel);
        return foodItemMapper.mapToDTO(foodItemModel);
    }
}
