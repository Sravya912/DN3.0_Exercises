CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_customer_id IN NUMBER,
    p_name IN VARCHAR2,
    p_dob IN DATE,
    p_balance IN NUMBER
) 
IS
BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);

    COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        INSERT INTO ErrorLog (ErrorID, ErrorMessage, ErrorDate)
        VALUES (seq_error_id.NEXTVAL, 'Customer ID ' || p_customer_id || ' already exists.', SYSDATE);

        RAISE_APPLICATION_ERROR(-20001, 'Customer ID already exists.');
    
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20002, 'Error occurred during customer insertion: ' || SQLERRM);
END;
/
