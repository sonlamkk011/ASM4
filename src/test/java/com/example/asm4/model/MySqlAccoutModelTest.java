package com.example.asm4.model;

import com.example.asm4.entity.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySqlAccoutModelTest {

    @Test
    void save() {
        MySqlAccoutModel mySqlAccoutModel = new MySqlAccoutModel();
        Account account = new Account("Lam Son Dep trai", "Lam Son", "lamsondeptrai@gmail.com","123456", 1);

        assertEquals(true, mySqlAccoutModel.save(account));
    }
}