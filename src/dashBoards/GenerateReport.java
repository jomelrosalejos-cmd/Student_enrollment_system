package dashBoards;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class GenerateReport {

	ReportDatabaseConnection database = new ReportDatabaseConnection();

    public void generate(String schoolYear) {
        String desktopPath = System.getProperty("user.home") + "\\Desktop\\Enrollment_Report_" + schoolYear + ".pdf";

        try {
            Document document = new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(document, new FileOutputStream(desktopPath));
            document.open();

            // ── FONTS ──
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
            Font subTitleFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            Font normalFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
            Font boldFont = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
            Font smallFont = new Font(Font.FontFamily.HELVETICA, 8, Font.NORMAL);
            
            titleFont.setColor(48, 46, 127);
            subTitleFont.setColor(251, 181, 23);
            
            // ── HEADER ──
            Paragraph schoolName = new Paragraph("YOBHEL CHRISTIAN ACADEMY", titleFont);
            schoolName.setAlignment(Element.ALIGN_CENTER);
            document.add(schoolName);

            Paragraph reportTitle = new Paragraph("ENROLLMENT REPORT", subTitleFont);
            reportTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(reportTitle);

            Paragraph schoolYearPara = new Paragraph("School Year: " + schoolYear, normalFont);
            schoolYearPara.setAlignment(Element.ALIGN_CENTER);
            document.add(schoolYearPara);

//            Paragraph dateGenerated = new Paragraph("Date Generated: " + LocalDate.now(), normalFont);
//            dateGenerated.setAlignment(Element.ALIGN_CENTER);
//            document.add(dateGenerated);

            document.add(Chunk.NEWLINE);

            // ── SUMMARY ──
            int totalEnrolled = database.getTotalEnrolledBySchoolYear(schoolYear);
            Paragraph summary = new Paragraph("Total Enrolled Students: " + totalEnrolled, boldFont);
            document.add(summary);

            document.add(Chunk.NEWLINE);

            // ── STUDENTS PER STRAND PER SECTION ──
            ArrayList<String[]> strands = database.getStrandsWithEnrolledStudents(schoolYear);

            for (String[] strand : strands) {
                String strandID = strand[0];
                String strandName = strand[1];

                // Strand header
                Paragraph strandHeader = new Paragraph("Strand: " + strandName, subTitleFont);
                strandHeader.setSpacingBefore(10);
                document.add(strandHeader);

                ArrayList<String[]> sections = database.getSectionsByStrand(strandID, schoolYear);

                for (String[] section : sections) {
                    String sectionID = section[0];
                    String sectionName = section[1];
                    String teacherName = section[2];

                    // Section header
                    Paragraph sectionHeader = new Paragraph(
                        "Section: " + sectionName + "     |     Adviser: " + teacherName, boldFont);
                    sectionHeader.setSpacingBefore(6);
                    document.add(sectionHeader);

                    // Table
                    PdfPTable table = new PdfPTable(9);
                    table.setWidthPercentage(100);
                    table.setSpacingBefore(4f);
                    table.setWidths(new float[]{2f, 3f, 6f, 4f, 2.5f, 3f, 4f, 6f, 8f});

                    // Table header
                    String[] headers = {"#","Student ID", "Full Name", "LRN", "Gender", "Birthdate", "Phone Number", "Email", "Address"};
                    for (String header : headers) {
                        PdfPCell cell = new PdfPCell(new Phrase(header, boldFont));
                        cell.setBackgroundColor(new BaseColor(48, 46, 127));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setPadding(4);
                        // Set font color to white
                        cell.setPhrase(new Phrase(header, new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE)));
                        table.addCell(cell);
                    }

                    // Table data
                    ArrayList<Object[]> students = database.getEnrolledStudentsBySection(sectionID, schoolYear);
                    int rowNum = 1;
                    for (Object[] student : students) {
                    	
                        PdfPCell numCell = new PdfPCell(new Phrase(String.valueOf(rowNum++), smallFont));
                        numCell.setPadding(4);
                        numCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(numCell);
                    	
                        for (Object field : student) {
                            PdfPCell cell = new PdfPCell(new Phrase(String.valueOf(field), smallFont));
                            cell.setPadding(4);
                            table.addCell(cell);
                        }
                    }

                    document.add(table);
                    document.add(Chunk.NEWLINE);
                }
            }

            // ── FOOTER ──
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            String endMessage = "---------------------------* This is a computer-generated enrollment report by the Registrar's Enrollment Management System. "
            		+ "Date Generated: "
            		+  LocalDate.now() + " *-----------------------------";
            
            Paragraph preparedBy = new Paragraph(endMessage, normalFont);
            document.add(preparedBy);

            document.close();

            System.out.println("Report generated: " + desktopPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}