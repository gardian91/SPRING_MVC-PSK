package com.psk.bank.model;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

public interface Account {
    String getAccountNumber();
    String getFirstName();
    String getLastName();
    Boolean isActive();
    LocalDateTime getCreationTs();
}
