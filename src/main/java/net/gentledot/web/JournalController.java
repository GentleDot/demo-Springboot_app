package net.gentledot.web;

import net.gentledot.domain.Journal;
import net.gentledot.repository.JournalRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Sang on 2017-06-15.
 */
@Controller
public class JournalController {

    @Autowired
    JournalRepository repository;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("journal", repository.findAll()); // findAll() : DB에 저장된 모든 레코드를 반환

        return "index";
    }

    @RequestMapping(value = "/journal", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody
    List<Journal> getJournal(){
        return repository.findAll();
    }
}
