package simple.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sai on 16-8-3.
 */
@RestController
@RequestMapping("/api/position")
public class DemoRestController
{

    @Autowired
    MongoOperations mongoOperations;

    @Value("${message}")
    String message;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    ResponseEntity getPositions()
    {
        List<Position> positionList = mongoOperations.findAll(Position.class);
        return new ResponseEntity(positionList, HttpStatus.OK);
    }

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    String getMessage()
    {
        return this.message;
    }


}

@Document(collection = "position")
class Position
{
    @Id
    String id;

    String companyName;
    String groupName;
    String functionName;
    String subFuncName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getSubFuncName() {
        return subFuncName;
    }

    public void setSubFuncName(String subFuncName) {
        this.subFuncName = subFuncName;
    }
}
