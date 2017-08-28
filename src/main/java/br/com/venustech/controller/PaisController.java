package br.com.venustech.controller;

import br.com.venustech.model.Pais;
import br.com.venustech.service.CustomersService;
import br.com.venustech.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PaisController {

    private PaisService paisService;

    @Autowired
    public void setPaisService(PaisService paisService) {
        this.paisService = paisService;
    }

    @RequestMapping(value = "/pais")
    public String index() {
        return "redirect:/pais/1";
    }

    @RequestMapping(value = "/pais/{pageNumber}", method = RequestMethod.GET)
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<Pais> page = paisService.getCustomList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "pais/list";

    }

    @RequestMapping("/pais/add")
    public String add(Model model) {

        model.addAttribute("pais", new Pais());
        return "pais/form";

    }

    @RequestMapping("/pais/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        model.addAttribute("pais", paisService.get(id));
        return "pais/form";

    }

    @RequestMapping(value = "/pais/save", method = RequestMethod.POST)
    public String save(Pais pais, final RedirectAttributes ra) {

        Pais save = paisService.save(pais);
        ra.addFlashAttribute("successFlash", "Cliente foi salvo com sucesso.");
        return "redirect:/pais";

    }

    @RequestMapping("/pais/delete/{id}")
    public String delete(@PathVariable Long id) {

        paisService.delete(id);
        return "redirect:/pais";

    }

}
