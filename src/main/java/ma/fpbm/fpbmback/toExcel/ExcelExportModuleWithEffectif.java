package ma.fpbm.fpbmback.toExcel;

import ma.fpbm.fpbmback.beans.Examen;
import ma.fpbm.fpbmback.beans.Module;
import ma.fpbm.fpbmback.beans.ProfesseurHasModuleHasEtudiant;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class ExcelExportModuleWithEffectif extends AbstractXlsView {
    @Override
    protected void buildExcelDocument(
            Map<String, Object> model,
            Workbook workbook,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // define excel file name to be exported
        response.addHeader("Content-Disposition", "attachment;fileName=InvoiceData.xls");

        @SuppressWarnings("unchecked")
        List<ProfesseurHasModuleHasEtudiant> listModule = (List<ProfesseurHasModuleHasEtudiant>) model.get("listModule");

        @SuppressWarnings("unchecked")
        List<Examen> module = (List<Examen>) model.get("module");
        // create one sheet
        Sheet sheet = workbook.createSheet("ProfesseurHasModuleHasEtudiant");

        // create row0 as a header
        Row row0 = sheet.createRow(0);
        row0.createCell(0).setCellValue("code module");
        row0.createCell(1).setCellValue("module");
        row0.createCell(2).setCellValue("semestre");
        row0.createCell(3).setCellValue("filliere");
        row0.createCell(4).setCellValue("section");
        row0.createCell(5).setCellValue("Nb Etudiants");


        // create row1 onwards from List<T>
        int rowNum = 1;
        for(Examen spec : module) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(spec.getProfHasModule().getModule().getId());
            row.createCell(1).setCellValue(spec.getProfHasModule().getModule().getName());
            row.createCell(2).setCellValue(spec.getProfHasModule().getModule().getSemestre().getName_semester());
            row.createCell(3).setCellValue(spec.getProfHasModule().getModule().getSemestre().getFillier_id().getName());
            row.createCell(4).setCellValue(spec.getProfHasModule().getSection().getName());
            int countEff = 0;
            //countEffectif
            for(ProfesseurHasModuleHasEtudiant temp:listModule){
                if(spec.getProfHasModule().getModule().getName().equals(temp.getProfesseurHasModule_id().getModule().getName()) && spec.getProfHasModule().getSection().getName().equals(temp.getProfesseurHasModule_id().getSection().getName())){
                    countEff++;
                }
            }
            row.createCell(5).setCellValue(countEff);

        }
    }
}
