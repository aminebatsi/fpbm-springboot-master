package ma.fpbm.fpbmback.ToPdf;

import ma.fpbm.fpbmback.beans.Examen;

import java.util.List;

import java.awt.Color;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


import javax.servlet.http.HttpServletResponse;

import com.google.zxing.WriterException;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import ma.fpbm.fpbmback.beans.Examen;
import ma.fpbm.fpbmback.beans.ExamenHasProfesseurHasModuleHasEtudiant;
import ma.fpbm.fpbmback.beans.Professeur;


public class GenrateProfPv {
    private List<Examen> examenList;

    private Professeur profInfo;

    public GenrateProfPv(List<Examen> examenList, Professeur profInfo) {
        this.examenList = examenList;
        this.profInfo = profInfo;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Filliere", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Date", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Heure", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Module", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Salle", font));
        table.addCell(cell);

    }

    private void writeTableData(PdfPTable table) {


        for(Examen spec:examenList){
            if(profInfo.getId().equals(spec.getProfHasModule().getProfesseur().getId())){

                table.addCell(spec.getProfHasModule().getModule().getSemestre().getFillier_id().getName()+ "/" +spec.getProfHasModule().getModule().getSemestre().getName_semester());
                table.addCell(spec.getJour());
                table.addCell(spec.getHeure());
                table.addCell(spec.getProfHasModule().getModule().getName());
                table.addCell(spec.getSalle().getName());
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

        Paragraph titre = new Paragraph("Professeur invitation",font1);
        titre.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(titre);

        //<------ space ----->
        Paragraph space = new Paragraph(" ", font1);
        space.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(space);

        Paragraph nomProf = new Paragraph("Nom : " +  profInfo.getNom(), font);
        nomProf.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(nomProf);

        Paragraph prenomProf = new Paragraph("Prénom : " +  profInfo.getPrenom(), font);
        prenomProf.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(prenomProf);

        Paragraph p = new Paragraph("QrCode : ", font);
        p.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(p);

        Image qrCodeImage = Image.getInstance(GenerateQrCode.getQRCodeImage(profInfo.getCode(),100,100));
        //qrCodeImage.scalePercent(400, 400);
        qrCodeImage.setAlignment(Element.ALIGN_LEFT);
        document.add(qrCodeImage);


        Paragraph list = new Paragraph("List des examen : ", font);
        list.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(list);

        PdfPTable examensTable = new PdfPTable(5);
        examensTable.setWidthPercentage(100f);
        //SUm =5
        examensTable.setWidths(new float[]{2f,2.5f,2f,3f,3f});
        examensTable.setSpacingBefore(10);
        writeTableHeader(examensTable);

        writeTableData(examensTable);
        document.add(examensTable);

        document.close();

    }


}
