package com.myproject.FoodAPI.rest;

import com.myproject.FoodAPI.entity.*;
import com.myproject.FoodAPI.service.FoodOptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FoodOptionsRestController {

    private FoodOptionsService foodOptionsService;

    @Autowired
    public FoodOptionsRestController(FoodOptionsService thefoodOptionsService) {
        foodOptionsService = thefoodOptionsService;
    }

    // Beverage Rest API
    @GetMapping("/beverageoptions")
    public List<BeverageOptions> listAllBeverageOptions() {
        return foodOptionsService.findAllBeverageOptions();
    }

    @GetMapping("/beverageoptions/{beverageOptionsId}")
    public BeverageOptions getBeverageOption(@PathVariable int beverageOptionsId) {
        BeverageOptions theBeverageOption = foodOptionsService.findBeverageOptionById(beverageOptionsId);

        if(theBeverageOption == null) {
            throw new RuntimeException("Beverage Option id not found - " + beverageOptionsId);
        }

        return theBeverageOption;
    }

    @PostMapping("/beverageoptions")
    public BeverageOptions addBeverageOption(@RequestBody BeverageOptions theBeverageOption) {
        theBeverageOption.setId(0);

        BeverageOptions dbBeverageOption =  foodOptionsService.saveBeverageOption(theBeverageOption);

        return dbBeverageOption;
    }

    @PutMapping("/beverageoptions")
    public BeverageOptions updateBeverageOption(@RequestBody BeverageOptions theBeverageOption) {

        BeverageOptions dbBeverageOption =  foodOptionsService.saveBeverageOption(theBeverageOption);

        return dbBeverageOption;
    }

    @DeleteMapping("/beverageoptions/{beverageOptionsId}")
    public String deleteBeverageOption(@PathVariable int beverageOptionsId) {
        BeverageOptions theBeverageOption = foodOptionsService.findBeverageOptionById(beverageOptionsId);

        if(theBeverageOption == null) {
            throw new RuntimeException("Beverage Option id not found - " + beverageOptionsId);
        }

        foodOptionsService.deleteBeverageOptionById(beverageOptionsId);

        return "Deleted Beverage Option with Id - " + beverageOptionsId;
    }

    // Bowl Rest API
    @GetMapping("/bowloptions")
    public List<BowlOptions> listAllBowlOptions() {
        return foodOptionsService.findAllBowlOptions();
    }

    @GetMapping("/bowloptions/{bowlOptionsId}")
    public BowlOptions getBowlOption(@PathVariable int bowlOptionsId) {
        BowlOptions theBowlOption = foodOptionsService.findBowlOptionById(bowlOptionsId);

        if(theBowlOption == null) {
            throw new RuntimeException("Bowl Option id not found - " + bowlOptionsId);
        }

        return theBowlOption;
    }

    @PostMapping("/bowloptions")
    public BowlOptions addBowlOption(@RequestBody BowlOptions theBowlOption) {
        theBowlOption.setId(0);

        BowlOptions dbBowlOption =  foodOptionsService.saveBowlOption(theBowlOption);

        return dbBowlOption;
    }

    @PutMapping("/bowloptions")
    public BowlOptions updateBowlOption(@RequestBody BowlOptions theBowlOption) {

        BowlOptions dbBowlOption =  foodOptionsService.saveBowlOption(theBowlOption);

        return dbBowlOption;
    }

    @DeleteMapping("/bowloptions/{bowlOptionsId}")
    public String deleteBowlOption(@PathVariable int bowlOptionsId) {
        BowlOptions theBowlOption = foodOptionsService.findBowlOptionById(bowlOptionsId);

        if(theBowlOption == null) {
            throw new RuntimeException("Bowl Option id not found - " + bowlOptionsId);
        }

        foodOptionsService.deleteBowlOptionById(bowlOptionsId);

        return "Deleted Bowl Option with Id - " + bowlOptionsId;
    }

    // Desert Rest API
    @GetMapping("/desertoptions")
    public List<DesertOptions> listAllDesertOptions() {
        return foodOptionsService.findAllDesertOptions();
    }

    @GetMapping("/desertoptions/{desertOptionsId}")
    public DesertOptions getDesertOption(@PathVariable int desertOptionsId) {
        DesertOptions theDesertOption = foodOptionsService.findDesertOptionById(desertOptionsId);

        if(theDesertOption == null) {
            throw new RuntimeException("Desert Option id not found - " + desertOptionsId);
        }

        return theDesertOption;
    }

    @PostMapping("/desertoptions")
    public DesertOptions addDesertOption(@RequestBody DesertOptions theDesertOption) {
        theDesertOption.setId(0);

        DesertOptions dbDesertOption =  foodOptionsService.saveDesertOption(theDesertOption);

        return dbDesertOption;
    }

    @PutMapping("/desertoptions")
    public DesertOptions updateDesertOption(@RequestBody DesertOptions theDesertOption) {

        DesertOptions dbDesertOption =  foodOptionsService.saveDesertOption(theDesertOption);

        return dbDesertOption;
    }

    @DeleteMapping("/desertoptions/{desertOptionsId}")
    public String deleteDesertOption(@PathVariable int desertOptionsId) {
        DesertOptions theDesertOption = foodOptionsService.findDesertOptionById(desertOptionsId);

        if(theDesertOption == null) {
            throw new RuntimeException("Desert Option id not found - " + desertOptionsId);
        }

        foodOptionsService.deleteDesertOptionById(desertOptionsId);

        return "Deleted Desert Option with Id - " + desertOptionsId;
    }

    // Pasta Rest API
    @GetMapping("/pastaoptions")
    public List<PastaOptions> listAllPastaOptions() {
        return foodOptionsService.findAllPastaOptions();
    }

    @GetMapping("/pastaoptions/{pastaOptionsId}")
    public PastaOptions getPastaOption(@PathVariable int pastaOptionsId) {
        PastaOptions thePastaOption = foodOptionsService.findPastaOptionById(pastaOptionsId);

        if(thePastaOption == null) {
            throw new RuntimeException("Pasta Option id not found - " + pastaOptionsId);
        }

        return thePastaOption;
    }

    @PostMapping("/pastaoptions")
    public PastaOptions addPastaOption(@RequestBody PastaOptions thePastaOption) {
        thePastaOption.setId(0);

        PastaOptions dbPastaOption =  foodOptionsService.savePastaOption(thePastaOption);

        return dbPastaOption;
    }

    @PutMapping("/pastaoptions")
    public PastaOptions updatePastaOption(@RequestBody PastaOptions thePastaOption) {

        PastaOptions dbPastaOption =  foodOptionsService.savePastaOption(thePastaOption);

        return dbPastaOption;
    }

    @DeleteMapping("/pastaoptions/{pastaOptionsId}")
    public String deletePastaOption(@PathVariable int pastaOptionsId) {
        PastaOptions thePastaOption = foodOptionsService.findPastaOptionById(pastaOptionsId);

        if(thePastaOption == null) {
            throw new RuntimeException("Pasta Option id not found - " + pastaOptionsId);
        }

        foodOptionsService.deletePastaOptionById(pastaOptionsId);

        return "Deleted Pasta Option with Id - " + pastaOptionsId;
    }

    // Pizza Rest API
    @GetMapping("/pizzaoptions")
    public List<PizzaOptions> listAllPizzaOptions() {
        return foodOptionsService.findAllPizzaOptions();
    }

    @GetMapping("/pizzaoptions/{pizzaOptionsId}")
    public PizzaOptions getPizzaOption(@PathVariable int pizzaOptionsId) {
        PizzaOptions thePizzaOption = foodOptionsService.findPizzaOptionById(pizzaOptionsId);

        if(thePizzaOption == null) {
            throw new RuntimeException("Pizza Option id not found - " + pizzaOptionsId);
        }

        return thePizzaOption;
    }

    @PostMapping("/pizzaoptions")
    public PizzaOptions addPizzaOption(@RequestBody PizzaOptions thePizzaOption) {
        thePizzaOption.setId(0);

        PizzaOptions dbPizzaOption =  foodOptionsService.savePizzaOption(thePizzaOption);

        return dbPizzaOption;
    }

    @PutMapping("/pizzaoptions")
    public PizzaOptions updatePizzaOption(@RequestBody PizzaOptions thePizzaOption) {

        PizzaOptions dbPizzaOption =  foodOptionsService.savePizzaOption(thePizzaOption);

        return dbPizzaOption;
    }

    @DeleteMapping("/pizzaoptions/{pizzaOptionsId}")
    public String deletePizzaOption(@PathVariable int pizzaOptionsId) {
        PizzaOptions thePizzaOption = foodOptionsService.findPizzaOptionById(pizzaOptionsId);

        if(thePizzaOption == null) {
            throw new RuntimeException("Pizza Option id not found - " + pizzaOptionsId);
        }

        foodOptionsService.deletePizzaOptionById(pizzaOptionsId);

        return "Deleted Pizza Option with Id - " + pizzaOptionsId;
    }

}
