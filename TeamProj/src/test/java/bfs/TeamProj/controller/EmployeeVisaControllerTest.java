package bfs.TeamProj.controller;

import bfs.TeamProj.Service.DigitalDocumentService;
import bfs.TeamProj.Service.EmployeeVisaService;
import bfs.TeamProj.domain.DigitalDocument;
import bfs.TeamProj.domain.EmployeeVisaInformation;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = EmployeeVisaController.class)
class EmployeeVisaControllerTest {
    @MockBean
    private EmployeeVisaService employeeVisaService;

    @MockBean
    private DigitalDocumentService digitalDocumentService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getDoc() throws Exception {
        DigitalDocument doc = new DigitalDocument();
        doc.setId(1);
        doc.setType("Work authentication");
        doc.setDescription("auth");
        doc.setRequired(true);
        doc.setTemplateLocation("url");
        Mockito.when(digitalDocumentService.getDigitalDocumentById(1)).thenReturn(doc);
        mockMvc.perform(MockMvcRequestBuilders.get("/employee/visa/test/1"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json("{'id': 1,'type': 'Work authentication','templateLocation':'url', 'description':'auth','required':true}"));
    }

    @Test
    void newStep(){
        EmployeeVisaInformation.VisaStage visaStage = new EmployeeVisaInformation.VisaStage(1, "OPT completed", "I-983", "comment", LocalDate.now(), true);
        Mockito.when(employeeVisaService.newStep(visaStage)).thenReturn(visaStage);
        Gson gson = new Gson();
        String json = gson.toJson(visaStage);
        System.out.println(json);
        /*
        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/employee/visa/newStep")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json))
                    .andExpect(MockMvcResultMatchers.status().is(404))
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.content().json("{'awfId':1,'status':'OPT completed','type':'I-983','comment':'comment','visaEndDate':{'year':2021,'month':10,'day':30},'uploadedI983':true}"));
        } catch (Exception e) {
            e.printStackTrace();
        }

         */
    }
}