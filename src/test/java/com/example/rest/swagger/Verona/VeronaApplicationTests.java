package com.example.rest.swagger.Verona;

import com.example.rest.swagger.verona.model.Account;
import com.example.rest.swagger.verona.repository.AccountRepository;
import com.example.rest.swagger.verona.rest.TransactionController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TransactionController.class)
public class VeronaApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AccountRepository accountRepository;

    @Test
    public void whenConsultBalance_Call() throws Exception {
        // given
        mvc.perform(get("/api/Transaction/ConsultBalance")
                .param("idAccount" , "2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void whenMakeTransaction_Call() throws Exception {

        Account user = new Account();
        user.setBalance(800);
        user.setId(1);
        user.setAccountNumber("12345");
        user.setAccountId(1);
        // given
        mvc.perform(post("/api/Transaction/MakeTransaction")
                .content(objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}