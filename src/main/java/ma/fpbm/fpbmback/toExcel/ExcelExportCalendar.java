package ma.fpbm.fpbmback.toExcel;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fpbm.fpbmback.beans.Examen;
import ma.fpbm.fpbmback.beans.ProfesseurHasModuleHasEtudiant;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


import org.springframework.web.servlet.view.document.AbstractXlsView;




public class ExcelExportCalendar extends AbstractXlsView {
    private int test;

    public Examen checkSameExam(Examen examen,List<Examen> examenList){
        this.test = 0;
        for (Examen spec:examenList){
            if(spec.getProfHasModule().getModule().getCodeModule().equals(examen.getProfHasModule().getModule().getCodeModule())
                    && !spec.getId().toString().equals(examen.getId().toString())
                    && spec.getProfHasModule().getSection().getName().equals(examen.getProfHasModule().getSection().getName())
                    && spec.getId() < examen.getId()){
                System.out.println(spec.getId().toString());
                return spec;
            }
            this.test += 1;
        }
        return null;
    }



    @Override
    protected void buildExcelDocument(
            Map<String, Object> model,
            Workbook workbook,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // define excel file name to be exported
        response.addHeader("Content-Disposition", "attachment;fileName=InvoiceData.xls");

        // read data provided by controller
        @SuppressWarnings("unchecked")
        List<Examen> list = (List<Examen>) model.get("list");
        @SuppressWarnings("unchecked")
        List<ProfesseurHasModuleHasEtudiant> listModule = (List<ProfesseurHasModuleHasEtudiant>) model.get("listModule");

        // create one sheet
        Sheet sheet = workbook.createSheet("Examen");



        // create row0 as a header
        Row row0 = sheet.createRow(0);
        row0.createCell(0).setCellValue("Date");
        row0.createCell(1).setCellValue("Filliere");
        row0.createCell(2).setCellValue("Semestre");
        row0.createCell(3).setCellValue("Parc/Sec");
        row0.createCell(4).setCellValue("Module");
        row0.createCell(5).setCellValue("Responsable de module");
        row0.createCell(6).setCellValue("Heure");
        row0.createCell(7).setCellValue("Effectif");
        row0.createCell(8).setCellValue("CodeModule");
        row0.createCell(9).setCellValue("Salles");

        // create row1 onwards from List<T>
        int rowNum = 1;
        for(Examen spec : list) {
            if ( checkSameExam(spec,list) == null){
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(spec.getJour());
                row.createCell(1).setCellValue(spec.getProfHasModule().getModule().getSemestre().getFillier_id().getName());
                row.createCell(2).setCellValue(spec.getProfHasModule().getModule().getSemestre().getName_semester());
                row.createCell(3).setCellValue(spec.getProfHasModule().getSection().getName());
                row.createCell(4).setCellValue(spec.getProfHasModule().getModule().getName());
                row.createCell(5).setCellValue(spec.getProfHasModule().getProfesseur().getNom()+" "+spec.getProfHasModule().getProfesseur().getPrenom());
                row.createCell(6).setCellValue(spec.getHeure());

                int countEff = 0;
                //countEffectif
                for(ProfesseurHasModuleHasEtudiant temp:listModule){
                    if(spec.getProfHasModule().getModule().getName().equals(temp.getProfesseurHasModule_id().getModule().getName()) && spec.getProfHasModule().getSection().getName().equals(temp.getProfesseurHasModule_id().getSection().getName())){
                        countEff++;
                    }
                }
                row.createCell(7).setCellValue(countEff);
                row.createCell(8).setCellValue(spec.getProfHasModule().getModule().getCodeModule());
                row.createCell(9).setCellValue(spec.getSalle().getName());
            }else {
                //pour ajouter la salle #concatenation
                for(Row row : sheet){
                    if(spec.getProfHasModule().getModule().getCodeModule().equals(row.getCell(8).getStringCellValue())
                            && spec.getProfHasModule().getSection().getName().equals(row.getCell(3).getStringCellValue())
                    ){
                        row.getCell(9).setCellValue(row.getCell(9).getStringCellValue() + "+" + spec.getSalle().getName());
                    }
                }
            }
            /*
            for(Examen spec1 : list){

                if ((spec1.getJour().equals(spec.getJour()) && spec1.getHeure().equals(spec.getHeure()) && spec1.getProfHasModule().equals(spec.getProfHasModule())) && !spec.getId().toString().equals(spec1.getId().toString())) {
                    Row rowTemp = sheet.getRow(0);
                    System.out.println(spec.getId().intValue());
                    rowTemp.getCell(3).setCellValue(rowTemp.getCell(3).getStringCellValue() + "+" +spec1.getSalle().getName());
                    this.test = true;
                    break;
                }else {
                    Row row = sheet.createRow(rowNum++);
                    row.createCell(0).setCellValue(spec.getId());
                    row.createCell(1).setCellValue(spec.getJour());
                    row.createCell(2).setCellValue(spec.getHeure());
                    row.createCell(3).setCellValue(spec.getSalle().getName());
                    row.createCell(4).setCellValue(spec.getProfHasModule().getSection().getName());
                    row.createCell(5).setCellValue(spec.getProfHasModule().getModule().getSemestre().getName_semester());
                    row.createCell(6).setCellValue(spec.getProfHasModule().getModule().getName());
                    int countEff = 0;
                    //countEffectif
                    for(ProfesseurHasModuleHasEtudiant temp:listModule){
                        if(spec.getProfHasModule().getModule().getName().equals(temp.getProfesseurHasModule_id().getModule().getName()) && spec.getProfHasModule().getSection().getName().equals(temp.getProfesseurHasModule_id().getSection().getName())){
                            countEff++;
                        }
                    }
                    row.createCell(7).setCellValue(countEff);
                }
                }*/
            for(int i=0 ; i<10 ; i++){
                sheet.autoSizeColumn(i);
            }

        }

    }

}
