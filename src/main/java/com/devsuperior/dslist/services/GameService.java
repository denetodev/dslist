package com.devsuperior.dslist.services;


import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;


import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;



    @Transactional(readOnly = true)
    public GameDTO findById(Long Id){
        Game result = gameRepository.findById(Id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        return gameRepository
                .findAll()
                .stream()
                .map(GameMinDTO::new)
                .collect(Collectors.toList());
    }

}
