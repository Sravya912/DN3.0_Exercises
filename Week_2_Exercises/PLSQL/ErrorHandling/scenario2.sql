CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_employee_id IN NUMBER,
    p_percentage IN NUMBER
) 
IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_percentage / 100)
    WHERE EmployeeID = p_employee_id;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Employee ID not found.');
    END IF;

    COMMIT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        INSERT INTO ErrorLog (ErrorID, ErrorMessage, ErrorDate)
        VALUES (seq_error_id.NEXTVAL, 'Employee ID ' || p_employee_id || ' not found.', SYSDATE);

    WHEN OTHERS THEN
        ROLLBACK;
        RAISE_APPLICATION_ERROR(-20002, 'Error occurred during salary update: ' || SQLERRM);
END;
/
