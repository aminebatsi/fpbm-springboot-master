package ma.fpbm.fpbmback.ToPdf;


import java.awt.Color;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.google.zxing.WriterException;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import ma.fpbm.fpbmback.beans.Examen;

import ma.fpbm.fpbmback.beans.ExamenHasProfesseurHasModuleHasEtudiant;




public class GeneratePV{
    private int test;
    private List<ExamenHasProfesseurHasModuleHasEtudiant> list;



    private Examen exam;



    public GeneratePV(Examen examen,List<ExamenHasProfesseurHasModuleHasEtudiant> list) {
        this.exam = examen;
        this.list=list;
    }

    private void writeTableHeaderForSurveillants(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Nom et Prénom", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Téléphone", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Singnature", font));
        table.addCell(cell);
    }
    private void writeTableDataEmptyForSurv(PdfPTable table) {
        for (int i=0;i<5;i++) {
            table.addCell("-");
            table.addCell("");
            table.addCell("");
        }
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("N°Ord", font));

        table.addCell(cell);


        cell.setPhrase(new Phrase("Apogee", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("CNE", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Prénom", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Nom", font));
        table.addCell(cell);

    }
    /*
    private void writeTableData(PdfPTable table) {
        for (User user : listUsers) {
            table.addCell(String.valueOf(user.getId()));
            table.addCell(user.getEmail());
            table.addCell(user.getFullName());
            table.addCell(user.getRoles().toString());
            table.addCell(String.valueOf(user.isEnabled()));
        }
    }*/

    private void writeTableData(PdfPTable table) {
        int cmpt =0;

        for(ExamenHasProfesseurHasModuleHasEtudiant spec:list){
            if(exam.getId().toString().equals(spec.getExamen().getId().toString())){
                cmpt++;
                table.addCell(String.valueOf(cmpt));
                table.addCell(spec.getProfesseurHasModuleHasEtudiant().getIdEtudiant().getCode());
                table.addCell(spec.getProfesseurHasModuleHasEtudiant().getIdEtudiant().getCne());
                table.addCell(spec.getProfesseurHasModuleHasEtudiant().getIdEtudiant().getNom());
                table.addCell(spec.getProfesseurHasModuleHasEtudiant().getIdEtudiant().getPrenom());
            }
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException, WriterException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setSize(10);
        font.setColor(Color.BLUE);

        Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font1.setSize(16);
        font1.setColor(Color.BLUE);

        //Image img = Image.getInstance("C:\\Users\\d\\Downloads\\fpbm.png");
        File image = new File("src\\main\\resources\\fpbm.png");
        Image img = Image.getInstance(Files.readAllBytes(image.toPath()));
        img.scalePercent(40, 40);
        img.setAlignment(Element.ALIGN_CENTER);
        document.add(img);

        Paragraph titre = new Paragraph("Module : " + exam.getProfHasModule().getModule().getName() + "/" + exam.getProfHasModule().getModule().getSemestre().getName_semester(), font);
        titre.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(titre);

        Paragraph salle = new Paragraph("Salle "+ exam.getSalle().getName(), font);
        salle.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(salle);

        Paragraph heure = new Paragraph("Horaire : " + exam.getJour()+"  -  "+exam.getHeure(), font);
        heure.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(heure);

        Paragraph duree = new Paragraph("duree : ........... ", font);
        duree.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(duree);

        //<------ space ----->
        Paragraph space = new Paragraph(" ", font1);
        space.setAlignment(Paragraph.ALIGN_LEFT);

        document.add(space);

        Paragraph codeExamen = new Paragraph("Code Examen : " + exam.getProfHasModule().getModule().getCodeModule(), font);
        codeExamen.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(codeExamen);

        Paragraph SalleCode = new Paragraph("Code Salle : " + exam.getSalle().getCode(), font);
        SalleCode.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(SalleCode);

        Paragraph qrCode = new Paragraph("qr code", font);
        qrCode.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(qrCode);

        Image qrCodeImage = Image.getInstance(GenerateQrCode.getQRCodeImage(exam.getSalle().getCode(),100,100));
        //qrCodeImage.scalePercent(400, 400);
        qrCodeImage.setAlignment(Element.ALIGN_LEFT);
        document.add(qrCodeImage);

        Paragraph p = new Paragraph("Liste des surveillants :", font);
        p.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(p);

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100f);
        //SUm = 12,5
        table.setWidths(new float[]{4.5f, 4.5f, 3.5f});
        table.setSpacingBefore(10);

        writeTableHeaderForSurveillants(table);
        writeTableDataEmptyForSurv(table);

        document.add(table);

        //<------ space ----->
        document.add(space);
        //table des etudiant
        document.newPage();
        PdfPTable tableEtud = new PdfPTable(5);
        tableEtud.setWidthPercentage(100f);
        //SUm = 12,5
        tableEtud.setWidths(new float[]{2f,2.5f,2f,3f,3f});
        tableEtud.setSpacingBefore(10);
        writeTableHeader(tableEtud);

        writeTableData(tableEtud);
        document.add(tableEtud);

        document.close();

    }
}

