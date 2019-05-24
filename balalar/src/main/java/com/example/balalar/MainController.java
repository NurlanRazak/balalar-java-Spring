package com.example.balalar;
import com.example.balalar.data.BuyRepository;
import com.example.balalar.data.IBuyService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MainController {

    @Autowired
    private BuyRepository buyRepository;

    @Autowired
    IBuyService buyService;



    @GetMapping("/main")
    public List<Buy> getIds(){
        return buyService.findAll();
    }

    @GetMapping("/main/{id}")
    public Optional<Buy> getId(@PathVariable Long id){
        return buyRepository.findById(id);
    }
    @DeleteMapping("/main/{id}")
    public boolean deleteUser(@PathVariable Long id){
        System.out.println(id);
        buyRepository.deleteById(id);
        return true;
    }
    @PostMapping("/main")
    public Buy createUser(@RequestBody Buy buy){
        return buyRepository.save(buy);
    }

    @PutMapping("/main")
    public Buy updateUser(@RequestBody Buy buy){
        return buyRepository.save(buy);
    }


//    @GetMapping("/edit/{buyId}")
//    public String showUpdateForm(@PathVariable Long buyId, Model model) {
//        Buy buy = buyRepository.findById(buyId)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + buyId));
//
//        model.addAttribute("buy", buy);
//        return "update-user";
//    }

//    @PostMapping("/update/{buyId}")
//    public String updateUser(@PathVariable Long buyId, @Valid Buy buy,
//                             BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            buy.setId(buyId);
//            return "update-user";
//        }
//
//        buyRepository.save(buy);
//        model.addAttribute("buys", buyRepository.findAll());
//        return "main";
//    }

//    @GetMapping("/delete/{buyId}")
//    public String deleteUser(@PathVariable Long buyId, Model model) {
//        Buy user = buyRepository.findById(buyId)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + buyId));
//        buyRepository.delete(user);
//        model.addAttribute("buys", buyRepository.findAll());
//        return "main";
//    }
//    @RequestMapping("/main")
//    public String findBuys(Model model) {
//
//        List<Buy> buys = (List<Buy>) buyService.findAll();
//
//        model.addAttribute("buys", buys);
//
//        return  "main";
//    }

    /*
    @PutMapping("/main/{buyId}")
    public Buy updateBuy(@PathVariable Long buyId,
                         @Valid @RequestBody Buy buyRequest) {
        return buyRepository.findById(buyId)
                .map(buy -> {
                    buy.setName(buyRequest.)
                })

    }
    */


    /*
    @GetMapping("/main/{buyId}")
    public Buy retrieveBuy(@PathVariable Long buyId) {
        Optional<Buy> buy = buyRepository.findById(buyId);

        if (!buy.isPresent())
            throw new ResourceNotFoundException("id - " + buyId);
        return buy.get();
    }

    @DeleteMapping("/main/delete/{buyId}")
    public ResponseEntity<?> deleteBuy(@PathVariable Long buyId) {
        return buyRepository.findById(buyId)
                .map(buy -> {
                    buyRepository.delete(buy);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Data not found with id " + buyId));
    }
*/
}
