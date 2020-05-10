package com.company.exceptions;

public class WarehouseIsRentedException extends Exception {
    public WarehouseIsRentedException(String warehouse_is_already_rented) {
        super("the warehouse is already rented");
    }
}
