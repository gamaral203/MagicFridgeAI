package dev.java10x.MagicFridgeAI.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class FoodItemDTO {

    private Long id;

    private String nome;

    private String categoria;

    private Integer quantidade;

    private LocalDateTime validade;
}
