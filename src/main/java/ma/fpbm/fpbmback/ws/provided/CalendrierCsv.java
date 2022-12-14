package ma.fpbm.fpbmback.ws.provided;

import ma.fpbm.fpbmback.beans.Examen;
import ma.fpbm.fpbmback.beans.ProfesseurHasModuleHasEtudiant;
import ma.fpbm.fpbmback.service.imple.ExamenServiceImple;
import ma.fpbm.fpbmback.service.imple.ProfesseurModuleEtudiantServiceImpl;
import ma.fpbm.fpbmback.toExcel.ExcelExportCalendar;
import ma.fpbm.fpbmback.toExcel.ExcelExportEtdModWtFillndSem;
import ma.fpbm.fpbmback.toExcel.ExcelExportEtudModule;
import ma.fpbm.fpbmback.toExcel.ExcelExportModuleWithEffectif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@RestController
public class CalendrierCsv {

    @Autowired
    private ExamenServiceImple examenService;

    @Autowired
    private ProfesseurModuleEtudiantServiceImpl professeurModuleEtudiantService;

    @GetMapping("/excelExportCalendar")
    public ModelAndView exportToExcel() {
        ModelAndView mav = new ModelAndView();
        mav.setView(new ExcelExportCalendar());
        //read data from DB
        List<Examen> list= examenService.findAll();
        List<ProfesseurHasModuleHasEtudiant> listModule = professeurModuleEtudiantService.getAll();
        //send to excelImpl class
        mav.addObject("list", list);
        mav.addObject("listModule",listModule);
        return mav;
    }

    @GetMapping("/excelExportModEtd")
    public ModelAndView exportToExcelEtdMod() {
        ModelAndView mav1 = new ModelAndView();
        mav1.setView(new ExcelExportEtudModule());
        //read data from DB
        List<ProfesseurHasModuleHasEtudiant> listModule = professeurModuleEtudiantService.getAll();
        //send to excelImpl class
        mav1.addObject("listModule",listModule);
        return mav1;
    }
    @GetMapping("/excelExportModEff")
    public ModelAndView exportToExcelModuleEffectif() {
        ModelAndView mav1 = new ModelAndView();
        mav1.setView(new ExcelExportModuleWithEffectif());
        //read data from DB
        List<Examen> module = examenService.findAll();
        List<ProfesseurHasModuleHasEtudiant> listModule = professeurModuleEtudiantService.getAll();
        //send to excelImpl class
        mav1.addObject("listModule",listModule);
        mav1.addObject("module",module);
        return mav1;
    }

    @GetMapping("/excelExportModSemestre/{filliere}/{semestre}")
    public ModelAndView exportToExcelModuleWithSemestre(@PathVariable String semestre , @PathVariable String filliere) {
        ModelAndView mav1 = new ModelAndView();
        mav1.setView(new ExcelExportEtdModWtFillndSem(filliere,semestre));
        //read data from DB
        List<ProfesseurHasModuleHasEtudiant> listModule = professeurModuleEtudiantService.getAll();
        //send to excelImpl class
        mav1.addObject("listModule",listModule);
        return mav1;
    }

}
