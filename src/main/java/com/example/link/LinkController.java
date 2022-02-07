package com.example.link;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LinkController {
    
    @Autowired
    private LinkRepository linkRepository;

   @GetMapping("/")
   public String viewHomePage(Model model) {
       model.addAttribute("listLinks", linkRepository.findAll());
       return "index";
   }
   @GetMapping("/showNewLinkForm")
   public String showForm(Model model) {
       Link link = new Link();
       model.addAttribute("link", link);
       return "addLink";
   }

   
   @PostMapping("/saveLink")
   public String add(@RequestParam String title, @RequestParam String link, @RequestParam String description, @RequestParam String keyword){
    if(!(title.isEmpty()) && !(description.isEmpty()) && !(link.isEmpty()) && !(keyword.isEmpty())){
       
      Link l = new Link();
      l.setTitle(title);
      l.setLink(link);
      l.setDescription(description);
      l.setKeyword(keyword);
      linkRepository.save(l);
    }
     return "redirect:/";
  }

    
}
