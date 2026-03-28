package dev.java10x.MagicFridgeAI.mapper;

import dev.java10x.MagicFridgeAI.dto.FoodItemDTO;
import dev.java10x.MagicFridgeAI.model.FoodItemModel;
import org.springframework.stereotype.Component;

@Component
public class FoodItemMapper {

    public FoodItemModel map (FoodItemDTO foodItemDTO) {
        FoodItemModel foodItemModel = new FoodItemModel();
        foodItemModel.setId(foodItemDTO.getId());
        foodItemModel.setCategoria(foodItemDTO.getCategoria());
        foodItemModel.setQuantidade(foodItemDTO.getQuantidade());
        foodItemModel.setValidade(foodItemDTO.getValidade());
        foodItemModel.setNome(foodItemDTO.getNome());

        return foodItemModel;

    }

    public FoodItemDTO mapToDTO (FoodItemModel foodItemModel) {
        FoodItemDTO foodItemDTO = new FoodItemDTO();
        foodItemDTO.setId(foodItemModel.getId());
        foodItemDTO.setCategoria(foodItemModel.getCategoria());
        foodItemDTO.setQuantidade(foodItemModel.getQuantidade());
        foodItemDTO.setValidade(foodItemModel.getValidade());
        foodItemDTO.setNome(foodItemModel.getNome());
        return foodItemDTO;
    }

}
