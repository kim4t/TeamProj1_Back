package bfs.TeamProj.Service;

import bfs.TeamProj.domain.ApplicationWorkFlow;
import bfs.TeamProj.domain.EmployeeVisaInformation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmployeeVisaServiceTest {

    @Mock
    private ApplicationWorkFlowService applicationWorkFlowService;

    @InjectMocks
    private EmployeeVisaService employeeVisaService;

    @Test
    void newStep() {
        ApplicationWorkFlow expected = new ApplicationWorkFlow(1, LocalDate.now(), LocalDate.now(), "OPT completed", "I-983");
        Mockito.when(applicationWorkFlowService.getApplicationWorkFlowById(1))
                .thenReturn(new ApplicationWorkFlow(1, LocalDate.now(), LocalDate.now(), "OPT completed", "I-983"));
        assertEquals(expected, applicationWorkFlowService.getApplicationWorkFlowById(1));
        expected.setType("I-20");
        Mockito.when(applicationWorkFlowService.updateApplicationWorkFlow(expected)).thenReturn(expected);
        ApplicationWorkFlow res = applicationWorkFlowService.updateApplicationWorkFlow(expected);
        Mockito.verify(applicationWorkFlowService, Mockito.times(1)).updateApplicationWorkFlow(expected);

    }
}