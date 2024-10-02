package com.mymoney.finance_control.controller;

import com.mymoney.finance_control.dtos.EntriesRequestDto;
import com.mymoney.finance_control.models.AddMoney;
import com.mymoney.finance_control.models.User;
import com.mymoney.finance_control.repositories.UserRepository;
import com.mymoney.finance_control.services.AddMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/add")
public class AddMoneyController {

    @Autowired
    private AddMoneyService addMoneyService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<?> listAllEntries(){
        List<AddMoney> allEntries = addMoneyService.listAll();

        if(allEntries.isEmpty()){
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(allEntries);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> listEntriesByUser(@PathVariable("id") String id){
        List<AddMoney> allEntriesByUser = addMoneyService.listByUser(id);

        if(allEntriesByUser.isEmpty()){
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(allEntriesByUser);
    }

    @PostMapping("/entries")
    public ResponseEntity<?> AddEntriesMoney(@RequestBody EntriesRequestDto entriesRequestDto){
        Optional<User> findedUser = userRepository.findById(entriesRequestDto.id());

        if(findedUser.isEmpty()){
            return ResponseEntity.status(404).body("User not found or not authorized to do this action");
        }

        User user = findedUser.get();

        AddMoney addMoney = new AddMoney();
        addMoney.setContext(entriesRequestDto.context());
        addMoney.setValue(entriesRequestDto.value());
        addMoney.setUserAdd(user);

        addMoneyService.save(addMoney);
        return ResponseEntity.status(201).body(addMoney);

    }

}
