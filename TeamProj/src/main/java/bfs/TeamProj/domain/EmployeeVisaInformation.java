package bfs.TeamProj.domain;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeeVisaInformation {
    private VisaStage visaStage;
    private List<SampleDocument> sampleDocumentList;
    private List<VisaDocument> visaDocumentList;

    @Data
    public static class VisaStage{
        private int awfId;
        private String status;
        private String type;
    }

    @Data
    public static class SampleDocument{
        private String type;
        private String path;
    }

    @Data
    public static class VisaDocument {
        private int docId;
        private String path;
        private String title;
        private LocalDate createDate;
    }
}
