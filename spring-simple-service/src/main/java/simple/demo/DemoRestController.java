package simple.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
@RefreshScope
@RestController
@RequestMapping("/api/position")
public class DemoRestController
{

    @Autowired
    MongoOperations mongoOperations;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    ResponseEntity getPositions()
    {
        List<Position> positionList = mongoOperations.findAll(Position.class);
        return new ResponseEntity(positionList, HttpStatus.OK);
    }

}

@Document(collection = "position")
class Position
{
    @Id
    String id;
    String name;
    String companyName;
    String groupName;
    String functionName;
    String subFuncName;

    @Override
    public String toString() {
        return "Position{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", companyName='" + companyName + '\'' +
                ", groupName='" + groupName + '\'' +
                ", functionName='" + functionName + '\'' +
                ", subFuncName='" + subFuncName + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
