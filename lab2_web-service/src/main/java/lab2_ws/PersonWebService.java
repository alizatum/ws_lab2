package lab1_ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "PersonService")
public class PersonWebService {


    @WebMethod(operationName = "getAllPersons")
    public List<Person> getAllPersons() {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        List<Person> persons = dao.getAllPersons();
        return persons;
    }

    @WebMethod(operationName = "getPersons")
    public List<Person> getPersons(@WebParam(name = "name") String name,
                                   @WebParam(name = "surname") String surname,
                                   @WebParam(name = "age") Integer age,
                                   @WebParam(name = "phone") Integer phone,
                                   @WebParam(name = "gender") String gender) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        List<Person> persons = dao.getPersons(name, surname, age, phone, gender);
        return persons;
    }

    @WebMethod(operationName = "addPerson")
    public Integer addPerson(@WebParam(name = "name") String name,
                                @WebParam(name = "surname") String surname,
                                @WebParam(name = "age") Integer age,
                                @WebParam(name = "phone") Integer phone,
                                @WebParam(name = "gender") String gender
    ) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        Integer id = dao.addPerson(name, surname, age, phone, gender);
        return id;
    }

    @WebMethod(operationName = "deletePerson")
    public String deletePerson(@WebParam(name = "id") Integer id) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        String status = dao.deletePerson(id);
        return status;
    }

    @WebMethod(operationName = "updatePerson")
    public String insertPerson(@WebParam(name = "id") Integer id,
                               @WebParam(name = "name") String name,
                               @WebParam(name = "surname") String surname,
                               @WebParam(name = "age") Integer age,
                               @WebParam(name = "phone") Integer phone,
                               @WebParam(name = "gender") String gender
    ) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        String status = dao.updatePerson(id, name, surname, age, phone, gender);
        return status;
    }
}