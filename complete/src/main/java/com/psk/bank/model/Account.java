package com.psk.bank.model;

import java.time.LocalDateTime;

import org.joda.time.DateTime;

public interface Account {
    String getAccountNumber();
    String getFirstName();
    String getLastName();
    Boolean isActive();
    DateTime getCreationTs();
}
