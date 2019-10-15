package com.dvilela.stringcalculator.controller;
import com.dvilela.stringcalculator.Util;
import com.dvilela.stringcalculator.model.Word;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

    private ModelAndView index = new ModelAndView("index");
    private ModelAndView result = new ModelAndView("result");

    @GetMapping("/")
    public ModelAndView index(Model model) {
        model.addAttribute("word", new Word());
        index.addObject("exception", "");
        return index;
    }

    @PostMapping("/add")
    public ModelAndView greetingSubmit(@ModelAttribute Word word){
        try{
            word.setSum(Util.add(word.getValue()));
            return result;
        }catch (Exception e){
            word.setNegatives(Util.negatives);
            index.addObject("exception", e.getMessage());
            return index;
        }
    }

}
