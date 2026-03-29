package dev.java10x.MagicFridgeAI.service;

import dev.java10x.MagicFridgeAI.dto.FoodItemDTO;
import dev.java10x.MagicFridgeAI.mapper.FoodItemMapper;
import dev.java10x.MagicFridgeAI.model.FoodItemModel;
import dev.java10x.MagicFridgeAI.repository.FoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodItemService {

    private FoodItemRepository foodItemRepository;
    private FoodItemMapper foodItemMapper;

    public FoodItemService(FoodItemRepository foodItemRepository, FoodItemMapper foodItemMapper) {
        this.foodItemRepository = foodItemRepository;
        this.foodItemMapper = foodItemMapper;
    }

    public FoodItemDTO criar(FoodItemDTO foodItemDTO) {
        FoodItemModel foodItemModel = foodItemMapper.map(foodItemDTO);
        foodItemModel = foodItemRepository.save(foodItemModel);
        return foodItemMapper.mapToDTO(foodItemModel);
    }

    public List<FoodItemDTO> listar() {
        List<FoodItemModel> foodItem = foodItemRepository.findAll();
        return foodItem.stream()
                .map(foodItemMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public FoodItemDTO buscarPorId(Long id) {
        Optional<FoodItemModel> foodItem = foodItemRepository.findById(id);
        return foodItem.map(foodItemMapper::mapToDTO).orElse(null);
    }

    public void deletarItem(Long id) {
        foodItemRepository.deleteById(id);
    }
}
