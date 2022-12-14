package ma.fpbm.fpbmback.toExcel;

import ma.fpbm.fpbmback.beans.ProfesseurHasModuleHasEtudiant;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class ExcelExportEtudModule extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(
            Map<String, Object> model,
            Workbook workbook,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // define excel file name to be exported
        response.addHeader("Content-Disposition", "attachment;fileName=InvoiceData.xls");

        // read data provided by controller
        //@SuppressWarnings("unchecked")
        //List<Examen> list = (List<Examen>) model.get("list");
        @SuppressWarnings("unchecked")
        List<ProfesseurHasModuleHasEtudiant> listModule = (List<ProfesseurHasModuleHasEtudiant>) model.get("listModule");

        // create one sheet
        Sheet sheet = workbook.createSheet("ProfesseurHasModuleHasEtudiant");

        // create row0 as a header
        Row row0 = sheet.createRow(0);
        row0.createCell(0).setCellValue("code");
        row0.createCell(1).setCellValue("cne");
        row0.createCell(2).setCellValue("prenom");
        row0.createCell(3).setCellValue("nom");
        row0.createCell(4).setCellValue("Date de naiss");
        row0.createCell(5).setCellValue("cin");
        row0.createCell(6).setCellValue("module");
        row0.createCell(7).setCellValue("Section");
        row0.createCell(8).setCellValue("semestre");
        row0.createCell(9).setCellValue("filliere");

        // create row1 onwards from List<T>
        int rowNum = 1;
        for(ProfesseurHasModuleHasEtudiant spec : listModule) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(spec.getIdEtudiant().getCode());
            row.createCell(1).setCellValue(spec.getIdEtudiant().getCne());
            row.createCell(2).setCellValue(spec.getIdEtudiant().getPrenom());
            row.createCell(3).setCellValue(spec.getIdEtudiant().getPrenom());
            row.createCell(4).setCellValue(spec.getIdEtudiant().getDateNaissance());
            row.createCell(5).setCellValue(spec.getIdEtudiant().getCin());
            row.createCell(6).setCellValue(spec.getProfesseurHasModule_id().getModule().getName());
            row.createCell(7).setCellValue(spec.getProfesseurHasModule_id().getSection().getName());
            row.createCell(8).setCellValue(spec.getProfesseurHasModule_id().getModule().getSemestre().getName_semester());
            row.createCell(9).setCellValue(spec.getProfesseurHasModule_id().getModule().getSemestre().getFillier_id().getName());
        }
    }
}
