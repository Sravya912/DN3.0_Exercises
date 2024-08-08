CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddNewCustomer (
        p_customer_id IN NUMBER,
        p_name IN VARCHAR2,
        p_dob IN DATE,
        p_balance IN NUMBER
    );
    
    PROCEDURE UpdateCustomerDetails (
        p_customer_id IN NUMBER,
        p_name IN VARCHAR2,
        p_dob IN DATE
    );
    
    FUNCTION GetCustomerBalance (
        p_customer_id IN NUMBER
    ) RETURN NUMBER;
END CustomerManagement;
/
